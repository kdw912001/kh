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
 * Servlet implementation class FaqDetailServlet
 */
@WebServlet("/faqdetail")
public class FaqDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// faq 상세보기 처리용 컨트롤러
		int faqNum = Integer.parseInt(request.getParameter("fnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		FaqService fservice = new FaqService();
		
		//해당 글번호의 게시글 조회해 옴
		Faq faq= fservice.selectFaq(faqNum);
		
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(faq != null) {
			view = request.getRequestDispatcher("views/faq/faqDetailView.jsp");
			request.setAttribute("faq", faq);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
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
