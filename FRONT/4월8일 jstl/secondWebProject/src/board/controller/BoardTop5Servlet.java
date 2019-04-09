package board.controller;

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

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardTop5Servlet
 */
@WebServlet("/btop5")
public class BoardTop5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardTop5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 조회 많은 순으로 탑 5 조회 처리용 컨트롤러
		
		ArrayList<Board> list = new BoardService().selectReadCountTop5();
		System.out.println("btop5 : " + list);
		
		//전송할 json 객체 한 개 준비
		JSONObject sendJson = new JSONObject();
		//list 옮겨 저장할 json 배열 객체 준비
		JSONArray jsonArr = new JSONArray();
		
		for(Board b : list) {
			//b 객체값 저장할 json 객체 준비
			JSONObject job = new JSONObject();
			//필드값 하나씩 옮겨 저장함 : 멥 방식(키, 값)
			job.put("bnum", b.getBoardNum());
			job.put("btitle", URLEncoder.encode(b.getBoardTitle(), "UTF-8"));
			job.put("rcount", b.getBoardReadCount());
			
			jsonArr.add(job);			
		}  //for each
		
		sendJson.put("list", jsonArr);
		System.out.println("sendJson : " + sendJson.toJSONString());
		
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
