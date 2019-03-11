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
 * Servlet implementation class BoardReplyServlet
 */
@WebServlet("/breply")
public class BoardReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글달기 처리용 컨트롤러
		
		request.setCharacterEncoding("utf-8");
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		String boardTitle = request.getParameter("btitle");
		String boardWriter = request.getParameter("bwriter");
		String boardContent = request.getParameter("bcontent");
		
		BoardService bservice = new BoardService();
		
		//원글 조회
		Board originBoard = bservice.selectBoard(boardNum);
		
		//댓글객체 생성
		Board replyBoard = new Board();
		
		replyBoard.setBoardContent(boardContent);
		replyBoard.setBoardTitle(boardTitle);
		replyBoard.setBoardWriter(boardWriter);
		replyBoard.setBoardReplyLev(originBoard.getBoardReplyLev() + 1);
		//참조하는 원글 번호
		replyBoard.setBoardRef(originBoard.getBoardRef());
			
		if(replyBoard.getBoardReplyLev() == 2) //댓글의 댓글일 때
			//참조하는 댓글 번호 기록
			replyBoard.setBoardReplyRef(originBoard.getBoardNum());
		
		//댓글의 순번 : 무조건 1로 함
		replyBoard.setBoardReplySeq(1);
		
		//같은 레벨의 기존 댓글의 seq를 1증가 처리함
		bservice.updateReplySeq(replyBoard);
		
		//댓글 등록
		int result = bservice.insertReply(replyBoard);
		
		if(result > 0) {
			response.sendRedirect("/first/blist?page=" + currentPage);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message",boardNum+ "번 글에 대한 댓글 등록 실패!");
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
