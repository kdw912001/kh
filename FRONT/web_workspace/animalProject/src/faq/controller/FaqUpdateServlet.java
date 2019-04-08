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
 * Servlet implementation class FaqUpdateServlet
 */
@WebServlet("/faqupdate")
public class FaqUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); 
		Faq faq = new Faq();
		
		faq.setFaqNo(Integer.parseInt(request.getParameter("fnum")));
		faq.setFaqTitle(request.getParameter("title"));
		faq.setFaqType(request.getParameter("type"));
		faq.setFaqContent(request.getParameter("content"));
		

		int result = new FaqService().updateFaq(faq);
		System.out.println("수정한 faq : " + faq);
		
		if(result > 0) {
			response.sendRedirect("/doggybeta/faqlist?page=" + Integer.parseInt(request.getParameter("page")));
			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/faq/faqError.jsp");
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
