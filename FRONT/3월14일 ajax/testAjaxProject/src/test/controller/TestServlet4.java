package test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import test.model.vo.User;

/**
 * Servlet implementation class TestServlet4
 */
@WebServlet("/t4.do")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// test4 버튼 클릭시 연결되는 컨트롤러
		// no 를 전달받고, json 객체를 내보냄
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		User user = new User(no, "u1234", "p1234", 
				"김철수", 30, "kcs30@kh.org", 
				"010-1234-5678");
		
		//자바객체를 자바스크립트객체(json)로 바꿈
		//자바에서 제공되지 않으므로, 외부 라이브러리 가져다 사용함
		JSONObject job = new JSONObject();
		//user 의 필드값 하나씩 꺼내서, json 객체에 기록
		//맵 구조임. (키, 값)
		job.put("no", user.getNo());
		job.put("userid", user.getUserId());
		job.put("userpwd", user.getUserPwd());
		//json 에서 한글깨짐을 막으려면, 
		//java.net.URLEncoder 클래스의 encode() 로 인코딩 처리
		job.put("username", URLEncoder.encode(user.getUserName(), "UTF-8"));
		job.put("age", user.getAge());
		job.put("email", user.getEmail());
		job.put("phone", user.getPhone());
		
		System.out.println("job : " + job.toJSONString());
		
		//요청한 클라이언트쪽으로 json 객체 전송함
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(job.toJSONString());
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
