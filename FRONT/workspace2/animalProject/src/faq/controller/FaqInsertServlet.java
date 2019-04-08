package faq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.model.service.FaqService;
import faq.model.vo.Faq;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class FaqInsertServlet
 */
@WebServlet("/faqinsert")
public class FaqInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// faq 작성 컨트롤러, 첨부파일없음
		
		request.setCharacterEncoding("utf-8");
		
		Faq faq = new Faq();
		
		faq.setFaqTitle(request.getParameter("title"));
		faq.setFaqType(request.getParameter("type"));
		faq.setFaqContent(request.getParameter("content"));
		
		System.out.println(faq);
		int result = new FaqService().insertFaq(faq);
		
		if(result > 0) {
			response.sendRedirect("/doggybeta/faqlist");
		}else {
			
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
