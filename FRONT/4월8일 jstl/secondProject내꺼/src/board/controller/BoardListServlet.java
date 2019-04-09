package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/blist")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지별로 출력되는 게시글 전체 조회 처리용 컨트롤러
		//출력될 페이지 기본값 지정
		int currentPage = 1;
		
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//한 페이지에 출력할 목록 갯수 지정
		int limit = 10;
		
		BoardService bservice = new BoardService();
		
		//테이블에 저장된 전체 목록 갯수 조회
		int listCount = bservice.getListCount();
		//System.out.println("총목록수 : " + listCount);
		
		//현재 페이지에 출력할 목록 조회
		ArrayList<Board> list = bservice.selectList(currentPage, limit);
		//System.out.println("list : " + list);
		
		//총 페이지수 계산 : 목록이 마지막 1개일 때 1페이지로 처리
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지그룹(10개 페이지를 한 그룹으로 처리)에 
		//보여줄 시작 페이지 수
		//현재 페이지가 13이면 그룹은 11~20이 보여지게 함
		int startPage = (((int)((double)currentPage / limit + 0.9)) - 1)
						* limit + 1;
		int endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(list.size() > 0) {
			view = request.getRequestDispatcher(
					"views/board/boardListView.jsp");
			
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher(
					"views/board/boardError.jsp");
			request.setAttribute("message", currentPage + "에 대한 목록 조회 실패!");
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
