package faq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.model.service.FaqService;
import faq.model.vo.Faq;

/**
 * Servlet implementation class FaqSearchTitleServlet
 */
@WebServlet("/faqsearch")
public class FaqSearchTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqSearchTitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.
		request.setCharacterEncoding("UTF-8");
						
		//3.
		ArrayList<Faq> list = null;
		FaqService fservice = new FaqService();
						
		String title = request.getParameter("keyword");
						
		int currentPage = 1;
		int limit = 10;
						
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
				
		list = fservice.faqSearchTitle(title, currentPage, limit);
					
		int maxPage = (int)((double)list.size() / limit + 0.9);
				
		int startPage = (((int)((double)currentPage / limit + 0.9)) - 1 ) * limit + 1;
		int endPage = startPage + limit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
					
		//4.
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/faq/faqListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", list.size());
			request.setAttribute("search", "title");
			request.setAttribute("keyword", title);
					
			view.forward(request, response);
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('검색된 내용이 없습니다.'); location.href='/doggybeta/faqlist';</script>");
			out.flush();
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
