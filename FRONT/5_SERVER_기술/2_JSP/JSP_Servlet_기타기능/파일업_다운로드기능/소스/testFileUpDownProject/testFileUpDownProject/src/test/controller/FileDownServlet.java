package test.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownServlet
 */
@WebServlet("/filedown")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 다운로드 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		//파일이 저장된 폴더 위치 지정
		String savePath = "E:\\오전반_수업자료\\workspace\\testFileUpDownProject\\web\\uploadFiles";
		String savePath2 = "E:\\오전반_수업자료\\workspace\\testFileUpDownProject\\web\\uploadFiles2";

		int no = Integer.parseInt(request.getParameter("no"));
		String downFileName = request.getParameter("fname");
		
		//서버 해당 위치의 파일 읽기용 입력스트림
		BufferedInputStream bin = null;
		//서버에서 클라이언트로 파일을 내보낼 출력스트림
		ServletOutputStream sout = null;
		File downFile = null;
		
		try {
			//다운로드 시킬 파일 객체
			if(no == 1)
				downFile = new File(savePath + "\\" + downFileName);
			if(no == 2)
				downFile = new File(savePath2 + "\\" + downFileName);
			
			response.setContentType("text/plane");
			response.setCharacterEncoding("utf-8");
			response.addHeader("Content-Disposition", "attachment; filename=" + downFileName);
			response.setContentLength((int)downFile.length());
			
			sout = response.getOutputStream();
			bin = new BufferedInputStream(new FileInputStream(downFile));
			
			int read = 0;
			while((read = bin.read()) != -1){
				sout.write(read);
			}
			
			bin.close();
			sout.close();
			
		} catch (Exception e) {
			e.printStackTrace();
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
