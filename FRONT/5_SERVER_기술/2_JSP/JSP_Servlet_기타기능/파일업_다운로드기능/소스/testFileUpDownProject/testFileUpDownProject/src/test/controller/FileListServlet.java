package test.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileListServlet
 */
@WebServlet("/flist")
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 업로드된 파일이 저장된 폴더의 파일 목록을 뷰로 전달하는 컨트롤러
		String savePath = "E:\\오전반_수업자료\\workspace\\testFileUpDownProject\\web\\uploadFiles";
		String savePath2 = "E:\\오전반_수업자료\\workspace\\testFileUpDownProject\\web\\uploadFiles2";
		
		File dir = new File(savePath);
		File dir2 = new File(savePath2);
		String[] files1 = null;
		String[] files2 = null;
		
		if(dir.isDirectory()){
			files1 = dir.list();
		}
		
		if(dir2.isDirectory()){
			files2 = dir2.list();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("fileListView.jsp");
		request.setAttribute("files1", files1);
		request.setAttribute("files2", files2);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
