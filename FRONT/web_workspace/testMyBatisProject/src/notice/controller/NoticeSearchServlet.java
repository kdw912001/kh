package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/nsearch")
public class NoticeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 검색 처리용 컨트롤러
		//1. 
		request.setCharacterEncoding("utf-8");
		
		//2.
		String search = request.getParameter("search");
		
		//3.
		HashMap<Integer, Notice> map = null;
		NoticeService nservice = new NoticeService();
		
		switch(search) {
		case "title": String noticeTitle = request.getParameter("keyword");
				  map = nservice.selectSearchTitle(noticeTitle);
				  break;
		case "writer": String noticeWriter = request.getParameter("keyword");
				  map = nservice.selectSearchWriter(noticeWriter);
				  break;
		case "date": String beginDate = request.getParameter("begin");
				   String endDate = request.getParameter("end");
				   map = nservice.selectSearchDate(
						   Date.valueOf(beginDate), Date.valueOf(endDate));
		}
		
		//4.
		RequestDispatcher view = null;
		if(map.size() > 0) {
			view = request.getRequestDispatcher("views/notice/noticeListView.jsp");
			request.setAttribute("list", map);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", "요청된 조회결과가 없습니다.");
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
