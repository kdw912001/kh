package freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeboard.model.service.FreeBoardService;
import freeboard.model.vo.FreeBoard;


/**
 * Servlet implementation class BoardUpdateViewServlet
 */
@WebServlet("/bupview")
public class freeBoardUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public freeBoardUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 수정페이지 출력 처리용 컨트롤러
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		FreeBoard board = new FreeBoardService().selectBoard(boardNum);
		//System.out.println("b : " + board);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(board != null) {
			view = request.getRequestDispatcher("views/freeboard/freeBoardUpdateView.jsp");
			request.setAttribute("board", board);
			request.setAttribute("page", currentPage);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/freeboard/freeBoardError.jsp");
			request.setAttribute("message", boardNum + "번 게시글 수정페이지로 이동 실패!");
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
