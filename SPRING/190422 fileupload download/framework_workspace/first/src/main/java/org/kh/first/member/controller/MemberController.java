package org.kh.first.member.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.first.member.model.service.MemberService;
import org.kh.first.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	//MemberService DI
	@Autowired
	private MemberService memberService;

	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(Member member, 
			HttpSession session, SessionStatus status, 
			Model model) {
		
		Member loginMember = memberService.selectLogin(member);
		
		if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			status.setComplete();   //요청 성공
			
			return "home";
		}else {
			model.addAttribute("message", "로그인 실패!");
			return "common/error";
		}
	}
	
	@RequestMapping("logout.do")
	public String logoutMethod(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		return "home";
	}
	
	@RequestMapping("enroll.do")
	public String moveEnrollPage() {
		return "member/enrollPage";
	}
	
	@RequestMapping(value="minsert.do", method=RequestMethod.POST)
	public String insertMember(Member member, 
			@RequestParam(name="photo", required=false) 
			MultipartFile mphoto, HttpServletRequest request, 
			Model model) {
		System.out.println("member : " + member);
		System.out.println("프로필사진 : " + mphoto);
		
		//폴더에 전송온 파일 저장 처리
		String savePath = request.getSession().getServletContext()
				.getRealPath("resources/files/photo");
		
		try {
			if(mphoto != null) {
				mphoto.transferTo(new File(savePath + "\\" 
					+ mphoto.getOriginalFilename()));
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(memberService.insertMember(member) > 0)
			return "home";
		else {
			model.addAttribute("message", "회원 가입 실패!");
			return "common/error";
		}
	}
	
	@RequestMapping("myinfo.do")
	public ModelAndView selectMember(ModelAndView mv, 
			/*HttpServletRequest request*/
			@RequestParam(name="userid") String userid) {
		//ModelAndView mv = new ModelAndView();
		//String userid = request.getParameter("userid");
		
		Member member = memberService.selectMember(userid);
		
		mv.addObject("member", member);
		//request.setAttribute("member", member);
		mv.setViewName("member/memberDetailView");
		
		return mv;		
	}
	
	@RequestMapping("mdel.do")
	public String memberDelete(Model model,
			@RequestParam(name="userid") String userid) {
		int result = memberService.deleteMember(userid);
		if(result > 0)
			return "redirect:logout.do";
		else {
			model.addAttribute("message", "회원 탈퇴 실패!");
			return "common/error";
		}
			
	}
	
	@RequestMapping("mupview.do")
	public ModelAndView updateViewMember(ModelAndView mv,
			@RequestParam(name="userid") String userid) {
		
		Member member = memberService.selectMember(userid);
		
		if(member != null) {
			mv.addObject("member", member);
			mv.setViewName("member/memberUpdatePage");		
		}else {
			mv.addObject("message", "수정할 회원정보 조회 실패!");
			mv.setViewName("common/error");
		}
		
		return mv;
	}
	
	@RequestMapping(value="mupdate.do", method=RequestMethod.POST)
	public String updateMember(Member member, 
			Model model) {
		int result = memberService.updateMember(member);
		if(result > 0) {
			return "redirect:myinfo.do?userid=" + member.getUserid();
		}else {
			model.addAttribute("message", "회원정보 수정 실패!");
			return "common/error";
		}
	}
	
}









