package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardReplyUpdateServlet
 */
@WebServlet("/breplyup")
public class BoardReplyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글 수정 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		Board board = new Board();
		board.setBoardNum(Integer.parseInt(request.getParameter("bnum")));
		board.setBoardTitle(request.getParameter("btitle"));
		board.setBoardContent(request.getParameter("bcontent"));
		
		int result = new BoardService().updateReply(board);
		
		if(result > 0) {
			response.sendRedirect("/second/blist?page=" 
		         + Integer.parseInt(request.getParameter("page")));
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message", board.getBoardNum() + "번 댓글 수정 실패!");
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
