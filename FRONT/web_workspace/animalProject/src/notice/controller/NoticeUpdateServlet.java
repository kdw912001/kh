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

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/nupdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
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
			view = request.getRequestDispatcher("view/notice/noticeError.jsp");
			view.forward(request, response);
		}
		
		int maxSize = 1024 * 1024 * 10;
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "files/notice";
		MultipartRequest mrequest 
		= new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		Notice notice = new Notice();
		notice.setNoticeNo(Integer.parseInt(mrequest.getParameter("no")));
		notice.setNoticeTitle(mrequest.getParameter("title"));
		notice.setManagerId(mrequest.getParameter("writer"));
		notice.setNoticeContent(mrequest.getParameter("content"));
		
		String originFile = mrequest.getFilesystemName("upfile");
		
		//기존에 첨부파일이 있을 때
		if(originFile != null) {
			notice.setNoticeOriginFile(originFile);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			Date currentTime = new Date(System.currentTimeMillis());
			String reFile = sdf.format(currentTime) + "." + originFile.substring(originFile.lastIndexOf(".") + 1);
			//파일 이름 새로 만들어줌
			
			File originfile = new File(savePath + "\\" + originFile);
			File refile = new File(savePath + "\\" + reFile); 
			
			//renameTo 실패 했을 때
			if(!originfile.renameTo(refile)) {
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
			
			//첨부 파일이 변경되었을 때, 기존에 있던 파일을 지워준다
			notice.setNoticeReFile(reFile);
			if(!mrequest.getParameter("ofile").equals(notice.getNoticeOriginFile()))
				new File(savePath + "\\" + mrequest.getParameter("refile")).delete();
			
		}else {
			notice.setNoticeOriginFile(mrequest.getParameter("ofile"));
			notice.setNoticeReFile(mrequest.getParameter("refile"));
		}
		
		int result = new NoticeService().updateNotice(notice);
		
		if(result > 0) {
			response.sendRedirect("/first/ndetail?no=" + notice.getNoticeNo());
		}else {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
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
