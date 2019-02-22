package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDao;
import model.vo.Product;

import java.util.*;


/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(description = "Ajax 처리용 서블릿", urlPatterns = { "/products" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 get 방식으로 연결 요청시 자동으로 실행되는 메소드임
		System.out.println("doGet 연결됨....");
		//클라이언트가 보낸 변수 값을 꺼냄
		String dummy = request.getParameter("dummy");
		Date sendTime = new Date(Long.parseLong(dummy));
		System.out.println("클라이언트가 보낸 값 : " + dummy);
		System.out.println("클라이언트가 전송 요청한 시간 : " + sendTime.toString());
		
		//서버 클래스와 클라이언트의 문자 인코딩이 다르면,
		//response 객체에 셋팅하면 한글이 안 깨짐
		response.setContentType("text/html;charset=utf-8");
		
		//연결 요청한 클라이언트한테 답변을 보냄
		response.getWriter().println("서버에서 보낸 값 : " + 
									sendTime.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트의 연결 요청 방식이 post 일 때 자동 실행되는 메소드임
		System.out.println("doPost 연결됨....");
		
		//한글 인코딩 문자셋이 일치하지 않을 경우에는
		//클라이언트가 보낸 한글값에 대해서는 
		//클라이언트 문자셋으로 지정을 하면 됨
		request.setCharacterEncoding("utf-8");
		
		//클라이언트가 보낸 정보 꺼내기
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		System.out.println(name + ", " + price);
		
		response.setContentType("text/html;charset=utf-8");
		
		//서버가 처리한 결과를 클라이언트로 보냄
		response.getWriter().println(name + "님이 구매하신 금액은 " + 
							price + "원 입니다.");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 put 방식으로 연결 요청했을 때 자동 실행되는 메소드임
		System.out.println("doPut 연결됨....");
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println("price : " + request.getParameter("price"));
		int price = Integer.parseInt(request.getParameter("price"));
		 
		ProductDao pdao = new ProductDao();
				
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("서버에 저장된 상품 정보 확인\n" +
				pdao.addProduct(new Product(name, price)));
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 delete 방식으로 연결 요청했을 때 자동 실행되는 메소드임
		System.out.println("doDelete 연결됨....");
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(
				new ProductDao().deleteProduct());
	}

}
