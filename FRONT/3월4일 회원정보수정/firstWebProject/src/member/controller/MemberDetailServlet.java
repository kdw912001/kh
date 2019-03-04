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
 * Servlet implementation class MemberDetailServlet
 */
@WebServlet("/myinfo")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내 정보보기 처리용 컨트롤러
		//1. 전송온 값에 한글이 있을 경우 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 객체에 저장 처리
		String userId = request.getParameter("userid");
		
		//3. 서비스모델로 값 전달하고 결과받기
		Member member = new MemberService().selectMember(userId);
		
		//4. 받은 결과를 가지고 성공/실패에 따라 뷰 선택해서 내보냄
		//내보낼 값에 한글이 있다면 컨텐츠타입 지정함
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher view = null;
		if(member != null) {  //조회 성공시
			view = request.getRequestDispatcher("views/member/memberDetailView.jsp");
			request.setAttribute("member", member);
			view.forward(request, response);
		}else { //조회 실패시
			view = request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", userId + " 회원님의 상세정보 조회 실패!");
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
