package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/resistenroll")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		//2. 전송값 변수 or 도메인객체에 담기
		Member member = new Member();
		member.setUserId(request.getParameter("userid"));
		member.setUserName(request.getParameter("username"));
		member.setUserPwd(request.getParameter("userpwd"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		//확인
		System.out.println(member);
		//3. 서비스모델로 객체 전달하고 결과받기.
		int re = new MemberService().insertMember(member);
		//4. 성공 실패해 따라 뷰를 선택해서 내보내기.
		response.setContentType("text/html; charset=utf-8");
		if(re > 0) {
			response.sendRedirect("/doggybeta/index.jsp");
		} else {
			//절대경로 못씀
			RequestDispatcher view = request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", "회원가입실패");
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
