package board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.exception.BoardException;
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
		// 게시글 전체 목록 조회용 컨트롤러
		response.setContentType("text/html; charset=utf-8");
		try {
			Map<Integer, Board> map = new BoardService().selectList();
			
			RequestDispatcher view = request.getRequestDispatcher("view/board/boardListView.jsp");
			request.setAttribute("map", map);
			view.forward(request, response);
			
		} catch (BoardException e) {
			RequestDispatcher error = request.getRequestDispatcher("view/board/boardError.jsp");
			request.setAttribute("message", e.getMessage());
			error.forward(request, response);
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
