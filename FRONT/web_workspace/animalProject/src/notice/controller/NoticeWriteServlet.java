package notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet("/ninsert")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드 기능이 포함된 공지글 등록 처리용 컨트롤러
		RequestDispatcher view = null;
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			view.forward(request, response);
		}
		
		int maxSize = 1024 * 1024 * 10;
		
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root : " + root);
		String savePath = root + "files/notice";
		System.out.println("savepath : " + savePath);
		MultipartRequest mrequest = new MultipartRequest(
				request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Notice notice = new Notice();
		
		notice.setNoticeTitle(request.getParameter("title"));
		notice.setManagerId(request.getParameter("writer"));
		notice.setNoticeContent(request.getParameter("content"));
		System.out.println(notice);
		
		String originFile = mrequest.getFilesystemName("upfile");
		notice.setNoticeOriginFile(originFile);
		System.out.println(notice);
		
		if(originFile != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date currentTime = new Date(System.currentTimeMillis());
			String reFile = sdf.format(currentTime) + "." + originFile.substring(originFile.lastIndexOf(".") + 1);
			System.out.println(reFile);
			
			File originfile = new File(savePath + "\\" + originFile);
			File refile = new File(savePath + "\\" + reFile);
			
			if(originfile.renameTo(refile)) {
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(originfile);
				FileOutputStream fout = new FileOutputStream(refile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				fin.close();
				fout.close();
				originfile.delete();
			}
			
			notice.setNoticeReFile(reFile);
		}
		int result = new NoticeService().insertNotice(notice);
		System.out.println(result);
		if(result > 0){
			response.sendRedirect("/doggybeta/nlist");
		}else {
			view = request.getRequestDispatcher("views/notice/noticeError");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
