package tipboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tipboard.model.service.TipBoardService;
import tipboard.model.vo.TipBoard;

/**
 * Servlet implementation class TipBoardDetailServlet
 */
@WebServlet("/tdetail")
public class TipBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipBoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tipBoardNum = Integer.parseInt(request.getParameter("tnum"));
		int currentPage = Integer.parseInt(request.getParameter("tpage"));
		TipBoardService tservice = new TipBoardService();
		
		//조회수 1증가 처리함
		tservice.addReadCount(tipBoardNum);
		
		//해당 글번호의 게시글 조회해 옴
		TipBoard tboard = tservice.selectBoard(tipBoardNum);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
