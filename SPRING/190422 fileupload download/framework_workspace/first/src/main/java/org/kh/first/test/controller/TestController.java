package org.kh.first.test.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.kh.first.test.model.vo.Sample;
import org.kh.first.test.model.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	// testFileUpDown.jsp 파일 내보내기 용
	@RequestMapping("moveFile.do")
	public String moveFilePage() {
		return "test/testFilePage";
	}

	// 파일 업로드 처리용
	@RequestMapping(value = "fileup.do", method = RequestMethod.POST)
	public String testFileUpload(Sample sample, HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile file)
			throws IllegalStateException, IOException {
		System.out.println("sample : " + sample);
		System.out.println("file : " + file.getOriginalFilename());

		// 파일 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("/resources/files/test");

		file.transferTo(new File((savePath) + "\\" + file.getOriginalFilename()));

		return "home";
	}

	// 파일 다운로드 처리용
	@RequestMapping("fdown.do")
	public ModelAndView fileDownMethod(HttpServletRequest request, @RequestParam("filename") String fileName) {
		String savePath = request.getSession().getServletContext().getRealPath("resources/files/test");
		File downFile = new File(savePath + "\\" + fileName);

		/*
		 * ModelAndView(java.lang.String viewName, java.lang.String modelName,
		 * java.lang.Object modelObject) model == request 객체 modelName == request 객체에
		 * 저장할 이름 modelObject == request 객체에 저장할 객체 request.setAttribute("저장할 이름", 저장할
		 * 객체)
		 */
		return new ModelAndView("filedown", "downFile", downFile);
	}

	// ---------------------------------------------------------------
	// testAjaxPage.jsp 파일 내보내기
	@RequestMapping("moveAjax.do")
	public String moveAjaxPage() {
		return "test/testAjaxPage";
	}

	// ajax test method -------------------------
	@RequestMapping(value = "test1.do", method = RequestMethod.POST)
	public void test1Method(Sample sample, HttpServletResponse response) throws IOException {
		System.out.println("sample : " + sample);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		if (sample.getName().equals("박혁거세")) {
			out.append("ok");
		} else {
			out.append("fail");
		}
		out.flush();
		out.close();
	}

	@RequestMapping(value = "test2.do", method = RequestMethod.POST)
	@ResponseBody // 리턴하는 json 문자열을 response 객체에
	public String test2Method(HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("application/json; charset=utf-8");
		JSONObject job = new JSONObject();
		job.put("no", 123);
		job.put("title", URLEncoder.encode("ajax로 json 리턴 테스트", "utf-8"));
		job.put("writer", "user01");
		job.put("content", URLEncoder.encode("컨트롤러에서 json 객체를 ajax로 보냈습니다.", "utf-8"));
		return job.toJSONString();
	}

	@RequestMapping(value = "test3.do", method = RequestMethod.POST)
	public void test3Method(HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		List<User> list = new ArrayList<>();
		list.add(new User("u111", "p111", "홍길동", 25, "h11@h.com", "010-1111-1111"));
		list.add(new User("u222", "p222", "박문수", 33, "h22@h.com", "010-2222-2222"));
		list.add(new User("u333", "p333", "장영실", 45, "h33@h.com", "010-3333-3333"));
		list.add(new User("u444", "p444", "이순신", 48, "h44@h.com", "010-4444-4444"));
		list.add(new User("u555", "p555", "유관순", 19, "h55@h.com", "010-5555-5555"));

		// 전송용 객체 생성
		JSONObject sendObj = new JSONObject();
		// 배열 객체 생성
		JSONArray jarr = new JSONArray();

		// list 를 jarr 에 복사
		for (User user : list) {
			JSONObject juser = new JSONObject();

			juser.put("userid", user.getUserid());
			juser.put("userpwd", user.getUserpwd());
			juser.put("username", user.getUsername());
			juser.put("age", user.getAge());
			juser.put("email", user.getEmail());
			juser.put("phone", user.getPhone());
			// jarr 에 juser 저장
			jarr.add(juser);
		}
		sendObj.put("list", jarr);

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(sendObj.toJSONString());
		out.flush();
		out.close();
	}

	@RequestMapping(value = "test4.do", method = RequestMethod.POST)
	public ModelAndView test4Method(ModelAndView mv) throws UnsupportedEncodingException {
		// Map 을 ModelAndView 에 담아서
		// JsonView 로 보냄
		Sample samp = new Sample("이율곡", 55);
		samp.setName(URLEncoder.encode(samp.getName(), "utf-8"));
		Map<String, Sample> map = new HashMap<>();

		map.put("samp", samp);

		mv.addObject(map);
		// 뷰지정 : 등록된 jsonView 의 id를 뷰이름으로 지정함
		mv.setViewName("jsonView");

		return mv; // 뷰리졸버로 전달되고, 요청한 ajax 는 json 객체를 받음
	}

	@RequestMapping(value = "test5.do", method = RequestMethod.POST)
	public ResponseEntity<String> test5Method(@RequestBody String param) throws ParseException {
		// request body 에 저장되어서 전송 온 json 문자열을
		// param에 저장함

		// 전송 온 json 문자열을 json 객체로 바꿈
		JSONParser jparser = new JSONParser();
		JSONObject job = (JSONObject) jparser.parse(param);
		String name = (String) job.get("name");
		int age = ((Long) job.get("age")).intValue();
		System.out.println(name + ", " + age);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "test6.do", method = RequestMethod.POST)
	public ResponseEntity<String> test6Method(@RequestBody String param) throws ParseException {
		// request body 에 저장되어서 전송 온 jsonArray 배열 문자열을
		// param에 저장함

		// 전송 온 json 배열문자열을 jsonArray 객체로 바꿈

		JSONParser jparser = new JSONParser();
		JSONArray jarr = (JSONArray) jparser.parse(param);
		System.out.println("jarr size : " + jarr.size());

		for (int i = 0; i < jarr.size(); i++) {
			JSONObject job = (JSONObject) jarr.get(i);
			Sample samp = new Sample();
			samp.setName((String) job.get("name"));
			samp.setAge(((Long) job.get("age")).intValue());
		}
		// 정상 완료되었음을 클라이언트로 보냄
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

}
