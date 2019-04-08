package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/jipsalogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인처리용 컨트롤러
		System.out.println("멤버서블릿 호출");
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("userpwd");
		Member loginUser = new MemberService().loginMember(userid, passwd);
		System.out.println("전송값 : "+ userid + ", " + passwd);
		
		response.setContentType("text/html; charset=utf-8");
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(10*60);
			System.out.println("세션아이디 : " + session.getId());
			session.setAttribute("loginUser", loginUser);
		
			response.sendRedirect("/doggybeta/index.jsp");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", "로그인 실패!");
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
