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
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/minsert")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입 처리용 컨트롤러
		//1. 전송온 값에 한글이 있다면 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 도메인객체에 저장
		Member member = new Member();
		
		member.setUserId(request.getParameter("userid"));
		member.setUserName(request.getParameter("username"));
		member.setUserPwd(request.getParameter("userpwd"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setGender(request.getParameter("gender"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setEtc(request.getParameter("etc"));
		
		//한 개의 이름으로 여러 개의 값이 전송된 경우
		String[] hobbies = request.getParameterValues("hobby");
		//, 를 구분자로 여러 개의 문자열을 하나의 문자열로 바꿈
		member.setHobby(String.join(",", hobbies));
		//확인
		System.out.println("member : " + member);
		
		//3. 서비스모델로 객체 전달하고 결과 받기
		int result = new MemberService().insertMember(member);
		
		//4. 받은 결과로 성공/실패에 따라 뷰를 선택해서 내보냄
		response.setContentType("text/html; charset=utf-8");
		if(result > 0) {
			response.sendRedirect("/second/index.jsp");
		}else {
			RequestDispatcher view = 
				request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", "회원가입 실패!");
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
