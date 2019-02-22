package first.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.UserException;

import shopping.exceptions.ShopException;
import board.exceptions.BoardException;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// first controller
		// 모든 서비스 요청은 first controller 를 거치도록 함
		
		//각 서블릿으로 한글이 전송되어 올 경우, 문자셋 인코딩 처리
		//코드의 중복 해결함
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getParameter("action");
		
		RequestDispatcher rd = null;
		
		try{
			switch(action){
			case "login": rd = request.getRequestDispatcher("login");
					rd.forward(request, response);
					break;
			case "logout":	rd = request.getRequestDispatcher("logout");
					rd.forward(request, response);
					break;
			case "uinsert":	rd = request.getRequestDispatcher("uinsert");
				rd.forward(request, response);
				break;
			case "uupdate":	rd = request.getRequestDispatcher("uupdate");
				rd.forward(request, response);
				break;
			case "udelete":	rd = request.getRequestDispatcher("udelete");
				rd.forward(request, response);
				break;
			case "ulist":	rd = request.getRequestDispatcher("ulist");
				rd.forward(request, response);
				break;
			case "udetail":	rd = request.getRequestDispatcher("udetail");
				rd.forward(request, response);
				break;
			case "blist":	rd = request.getRequestDispatcher("blist");
				rd.forward(request, response);
				break;
			case "binsert":	rd = request.getRequestDispatcher("binsert");
				rd.forward(request, response);
				break;
			case "bupdate":	rd = request.getRequestDispatcher("bupdate");
				rd.forward(request, response);
				break;
			case "bdelete":	rd = request.getRequestDispatcher("bdelete");
				rd.forward(request, response);
				break;
			case "bdetail":	rd = request.getRequestDispatcher("bdetail");
				rd.forward(request, response);
				break;
			case "bsearch":	rd = request.getRequestDispatcher("bsearch");
				rd.forward(request, response);
				break;
			case "breply":	rd = request.getRequestDispatcher("breply");
				rd.forward(request, response);
				break;
			}
		}catch(Exception e){
			rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("message", e.getMessage());
			rd.forward(request, response);
		}
	}

}
