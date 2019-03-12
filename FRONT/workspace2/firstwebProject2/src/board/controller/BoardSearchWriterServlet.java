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
 * Servlet implementation class BoardSearchWriterServlet
 */
@WebServlet("/bsearchw")
public class BoardSearchWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				request.setCharacterEncoding("utf-8");
				int currentPage = 1;
				if (request.getParameter("page") != null) {
					currentPage = Integer.parseInt(request.getParameter("page"));
				}
				int limit = 10;
				BoardService bservice = new BoardService();
				String boardWriter = request.getParameter("keyword");
				ArrayList<Board> list = bservice.boardSearchWriter(boardWriter, currentPage, limit);
							
				int maxPage = (int) ((double) list.size() / limit + 0.9);
				int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
				int endPage = startPage + limit - 1;

				if (maxPage < endPage) {
					endPage = maxPage;
				}

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
					request.setAttribute("search", "title");
					request.setAttribute("keyword", boardWriter);

					view.forward(request, response);
				} else {
					view = request.getRequestDispatcher("views/board/boardError.jsp");
					request.setAttribute("message", currentPage + "에 대한 목록 조회 실패");
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
