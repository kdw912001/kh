package notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeTop5NewWriteServlet
 */
@WebServlet("/ntop5")
public class NoticeTop5NewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeTop5NewWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//최근 등록한 공지글 5개를 조회 처리하는 컨트롤러
		
		ArrayList<Notice> list = new NoticeService().selectTop5Write();
		System.out.println("ntop5 list : " + list);
		
		JSONObject sendJson = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		
		for(Notice n : list) {
			JSONObject job = new JSONObject();
			
			job.put("no", n.getNoticeNo());
			job.put("ntitle", URLEncoder.encode(n.getNoticeTitle(), "UTF-8"));
			//날짜데이터 그대로 JSON 에 담아서 전송하면 에러남
			//날짜데이터를 toString() 으로 문자열값으로 바꾸면 됨.
			job.put("ndate", n.getNoticeDate().toString());
			
			jsonArr.add(job);
		}
		
		sendJson.put("list", jsonArr);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(sendJson.toJSONString());
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
