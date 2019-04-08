package tipboard.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tipboard.model.service.TipBoardService;
import tipboard.model.vo.TipBoard;

/**
 * Servlet implementation class TipBoardSearchDateServlet
 */
@WebServlet("/tsearchd")
public class TipBoardSearchDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipBoardSearchDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date begin = Date.valueOf(request.getParameter("begin"));
		Date end = Date.valueOf(request.getParameter("end"));
		int currentPage = 1;
		int limit = 10;
		TipBoardService tservice = new TipBoardService();
		ArrayList<TipBoard> list = tservice.tipBoardSearchDate(begin, end, currentPage, limit);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
