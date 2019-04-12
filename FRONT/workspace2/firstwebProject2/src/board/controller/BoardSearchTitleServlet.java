package board.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class BoardSearchTitle
 */
@WebServlet("/bsearcht")
public class BoardSearchTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardSearchTitleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 공지글 검색 처리용 컨트롤러
		// 1.
		request.setCharacterEncoding("utf-8");

		// 출력물 페이지 기본값 지정
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		// 한 페이지에 출력할 목록 갯수 지정
		int limit = 10;
		// 2.
		//String search = request.getParameter("search");
	/*	String keyword = request.getParameter("keyword");*/
		// 3.		
		BoardService bservice = new BoardService();
		
		
		
		String boardTitle = request.getParameter("keyword");
		ArrayList<Board> list = bservice.boardSearchTitle(boardTitle, currentPage, limit);
		
		// 총 페이지 수 계산 : 목록이 마지막 1개일 때 1페이지로 처리
				int maxPage = (int) ((double) list.size() / limit + 0.9);
				// 현재 페이지 그룹(10개 페이지를 한 그룹으로 처리)에
				// 보여줄 시작 페이지 수
				// 현재 페이지가 13이면 그룹은 11~20이 보여지게 함
				int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
				int endPage = startPage + limit - 1;

				if (maxPage < endPage) {
					endPage = maxPage;
				}
		  
		/*switch (search) {
		case "title":
			String boardTitle = request.getParameter("keyword");
			list = bservice.boardSearchTitle(boardTitle, currentPage, limit);
			break;
		}*/

		// 4.
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if (list.size() > 0) {
			view = request.getRequestDispatcher("views/board/boardListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", list.size());
			//페이지 단위를 처리하기 위해 추가 (notice search와 달리 아래 두 문장 추가)
			request.setAttribute("search", "title");
			request.setAttribute("keyword", boardTitle);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message", currentPage + "에 대한 목록 조회 실패");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}