package faq.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.model.service.FaqService;
import faq.model.vo.Faq;

/**
 * Servlet implementation class FaqUpdateViewServlet
 */
@WebServlet("/faqupview")
public class FaqUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int faqNum = Integer.parseInt(request.getParameter("fnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
				
		Faq faq = new FaqService().selectFaq(faqNum);
				
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		System.out.println(faq);
		if(faq != null) {
			view = request.getRequestDispatcher("views/faq/faqUpdateView.jsp");
			request.setAttribute("faq", faq);
			request.setAttribute("page", currentPage);
			view.forward(request, response);
		}else {
			System.out.println("에러");
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
