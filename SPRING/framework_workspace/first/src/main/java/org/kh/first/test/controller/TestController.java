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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	//testAOPPage.jsp 내보내기
	@RequestMapping("moveAOP.do")
	public String moveAOPPage() {
		return "test/testAOPPage";
	}
	
	//패스워드 암호화 처리 페이지 내보내기
	@RequestMapping("testView.do")
	public String moveCryptoPage() {
		return "test/testCrypto";
	}
	
	@RequestMapping(value="bcrypto.do", method=RequestMethod.POST)
	public String testBcryptPassword(@RequestParam("userpwd") String userpwd) {
		System.out.println("전송온 암호 : " + userpwd);
		
		String buserpwd = bcryptPasswordEncoder.encode(userpwd);
		
		System.out.println("암호화된 패스워드 : " + buserpwd);
		System.out.println("글자갯수 : " + buserpwd.length());
		
		//로그인시 전송온 암호와 crypto 처리된 암호값 비교시에는 
		//matches(원래문자열, 암호화된 문자열) 메소드 사용함
		System.out.println("비교결과 : " + bcryptPasswordEncoder.matches(userpwd, buserpwd));
		
		return "home";
	}
	
	//testFileUpDown.jsp 파일 내보내기용
	@RequestMapping("moveFile.do")
	public String moveFilePage() {
		return "test/testFilePage";
	}
	
	//파일 업로드 처리용
	@RequestMapping(value="fileup.do", method=RequestMethod.POST)
	public String testFileUpload(Sample sample, HttpServletRequest request, @RequestParam(name="upfile") MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("sample : " + sample);
		System.out.println("file : " + file.getOriginalFilename());
		
		//파일 저장 폴더 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/files/test");
		file.transferTo(new File(savePath + "\\" + file.getOriginalFilename()));
		
		
		return "home";
	}
	
	//파일 다운로드 처리용
	@RequestMapping("fdown.do")
	public ModelAndView fileDownMethod(HttpServletRequest request, @RequestParam("filename") String fileName) {
		String savePath = request.getSession().getServletContext().getRealPath("/resources/files/test");
		File downFile = new File(savePath + "\\" + fileName);
		
		/* ModelAndView(java.lagn.String viewName, java.lang.String modelName, java.lang.Object modelObject)
		 * model == request 객체
		 * modelName == request 객체에 저장할 이름 
		 * modelObject == request 객체에 저장할 객체
		 * request.setAttribute("저장할 이름", 저장할 객체)*/
		return new ModelAndView("filedown", "downFile", downFile);
	}
	
	//testAjaxPage.jsp 파일 내보내기용
	@RequestMapping("moveAjax.do")
	public String moveAjaxPage() {
		return "test/testAjaxPage";
	}
	
	//ajax test method --------------------------------
	@RequestMapping(value="test1.do", method=RequestMethod.POST)
	public void test1Method(Sample sample, HttpServletResponse response) throws IOException {
		System.out.println("sample : " + sample);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(sample.getName().equals("박혁거세")) {
			out.append("ok");
			out.flush();
		}else {
			out.append("fail");
			out.flush();
		}
		
		out.close();
	}
	
	@RequestMapping(value="test2.do", method=RequestMethod.POST)
	@ResponseBody //리턴하는 json 문자열을 response 객체에 담아서 보내라는 의미
	public String test2Method(HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("application/json; charset=utf-8");
		
		JSONObject job = new JSONObject();
		job.put("no", 123);
		job.put("title", URLEncoder.encode("ajax로 json 리턴 테스트", "utf-8"));
		job.put("writer", "user01");
		job.put("content", URLEncoder.encode("컨트롤러에서 json 객체를 ajax로 보냈습니다.","utf-8"));
		
		return job.toJSONString();
	}
	@RequestMapping(value="test3.do", method=RequestMethod.POST)
	public void test3Method(HttpServletResponse response) throws IOException {
		List<User> list = new ArrayList<>();
		
		list.add(new User("u1111","p1111","홍길동",25,"h1111@kh.org","010-1111-1111"));
		list.add(new User("u2222","p2222","박문수",35,"p2222@kh.org","010-2222-1111"));
		list.add(new User("u3333","p3333","장영실",45,"j3333@kh.org","010-3333-1111"));
		list.add(new User("u4444","p4444","이순신",55,"j4444@kh.org","010-4444-1111"));
		list.add(new User("u5555","p5555","유관순",65,"j5555@kh.org","010-5555-1111"));
		
		//전송용 객체 생성
		JSONObject sendObj = new JSONObject();
		//배열 객체 생성
		JSONArray jarr = new JSONArray();
		
		//list 를 jarr 에 복사
		for(User user : list) {
			//user 객체 저장용 json 객체 생성
			JSONObject juser = new JSONObject();
			
			juser.put("userid", user.getUserid());
			juser.put("userpwd", user.getUserpwd());
			juser.put("username", user.getUsername());
			juser.put("age", user.getAge());
			juser.put("email",	user.getEmail());
			juser.put("phone", user.getPhone());
			
			//jarr에 juser저장
			jarr.add(juser);
		}
		
		sendObj.put("list", jarr);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(sendObj.toJSONString());
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="test4.do", method=RequestMethod.POST)
	public ModelAndView test4Method(ModelAndView mv) throws UnsupportedEncodingException {
		//Map 을 ModelAndView 에 담아서 JonsView로 보냄
		Sample samp = new Sample("이율곡", 55);
		samp.setName(URLEncoder.encode(samp.getName(), "utf-8"));
		Map<String, Sample> map = new HashMap<String, Sample>();
		map.put("samp", samp);
		
		mv.addObject(map);
		//뷰지정 : servlet-context.xml에 등록된 JsonView 의 id를 뷰이름으로 지정함
		mv.setViewName("jsonView");
		
		return mv;	//뷰리졸버로 전달되고, 요청한 ajax는 json 객체를 받음
	}
	
	@RequestMapping(value="test5.do", method=RequestMethod.POST)
	public ResponseEntity<String> test5Method(@RequestBody String param) throws ParseException {//POST방식은 @RequestBody
		//request body에 저장되어 전송 온 json 문자열을 param 에 저장함
		
		//전송 온 json 문자열을 json 객체로 바꿈
		JSONParser jparser = new JSONParser();
		JSONObject job = (JSONObject)jparser.parse(param);
		
		String name = (String) job.get("name");
		int age = ((Long)job.get("age")).intValue();
		
		System.out.println(name + ", " + age);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@RequestMapping(value="test6.do", method=RequestMethod.POST)
	public ResponseEntity<String> test6Method(@RequestBody String param) throws ParseException {//POST방식은 @RequestBody
		//request body에 저장되어 전송 온 json 배열 문자열을 param 에 저장함
		
		//전송 온 json 배열 문자열을 json 배열객체로 바꿈
		JSONParser jparser = new JSONParser();
		JSONArray jarr = (JSONArray)jparser.parse(param);
		System.out.println("jarr size : " + jarr.size());
		
		for(int i = 0; i< jarr.size(); i++) {
			JSONObject job = (JSONObject) jarr.get(i);
			Sample samp = new Sample();
			samp.setName((String)job.get("name"));
			samp.setAge(((Long)job.get("age")).intValue());
			
			System.out.println(samp);
		}
		
		//정상 완료되었음을 클라이언트로 보냄
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
}
