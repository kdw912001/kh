package user.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.exceptions.UserException;
import user.model.biz.UserBiz;
import user.model.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// 로그인 처리용		
		UserBiz ubiz = new UserBiz();
		User loginUser = null;		
		RequestDispatcher rd = null;
		
		//전송된 아이디와 암호 꺼내기
		String uid = request.getParameter("loginId");
		String upwd = request.getParameter("loginPwd");
		
		try{
			loginUser = ubiz.loginCheck(uid, upwd);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}catch(UserException e){
			rd = request.getRequestDispatcher("user/userError.jsp");
			request.setAttribute("message", e.getMessage());
			rd.forward(request, response);	 		
		}
	}

}
