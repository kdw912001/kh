package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/ndetail")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 글번호에 대한 상세보기 처리용 컨트롤러
		int noticeNo = Integer.parseInt(request.getParameter("no"));
		
		Notice notice = new NoticeService().selectOne(noticeNo);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(notice != null) {
			view = request.getRequestDispatcher("views/notice/noticeDetailView.jsp");
			request.setAttribute("notice", notice);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", noticeNo + "번 공지글 상세보기 실패!");
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
