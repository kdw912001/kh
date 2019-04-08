package tipboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tipboard.model.service.TipBoardService;
import tipboard.model.vo.TipBoard;

/**
 * Servlet implementation class TipBoardSearchWriterServlet
 */
@WebServlet("/tsearchw")
public class TipBoardSearchWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipBoardSearchWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("keyword");
		int currentPage = 1;
		int limit = 10;
		TipBoardService tservice = new TipBoardService();
		ArrayList<TipBoard> list = tservice.tipBoardSearchWriter(writer, currentPage, limit);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
