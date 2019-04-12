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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 요청 처리용 컨트롤러
		//1. 전송 온 값에 한글이 있다면, 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송 온 값 꺼내서, 변수 또는 객체에 저장 처리
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		//확인
		//System.out.println("전송온 값 : " + userId + ", " + userPwd);
		
		//3. 서비스 모델로 추출한 값 전송하고, 결과 받기
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		Member loginUser = 
			new MemberService().selectLogin(member);
		//확인
		//System.out.println("loginUser : " + loginUser);
		
		//4. 받은 결과에 따라 성공/실패에 따른 뷰 파일 선택해서 내보냄
		//내보내는 값에 한글이 있다면, 컨텐츠타입을 셋팅함
		response.setContentType("text/html; charset=utf-8");
		if(loginUser != null) {  //로그인 성공시
			//로그인 확인을 위한 세션 객체 생성하기
			HttpSession session = request.getSession();
			//session.setMaxInactiveInterval(10*60);
			//System.out.println("세션id : " + session.getId());
			
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect("/testm/index.jsp");
		}else {  //로그인 실패시
			RequestDispatcher view = 
				request.getRequestDispatcher("views/member/memberError.jsp");
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
