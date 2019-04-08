package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberCheckIdServlet
 */
@WebServlet("/chkid")
public class MemberCheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCheckIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입시 사용자아이디 중복확인 처리용 컨트롤러
		//1. 전송온 값에 한글이 있으며 인코딩처리함
		//request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 도메인객체에 저장하기
		String userId = request.getParameter("userid");
		System.out.println("전송온 값 : " + userId);
		
		//3. 서비스모델로 값 또는 객체 전달하고, 결과받기
		int result = new MemberService().selectCheckId(userId);
		
		//4. 받은 결과를 가지고 요청자에서 응답처리하기
		String returnValue = null;
		if(result == 0)
			returnValue = "ok";
		else if(result == 1)
			returnValue = "dup";
		
		//ajax 통신에 대한 응답 처리는 출력 스트림으로 값을 전송함
		PrintWriter out = response.getWriter();
		out.append(returnValue);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
