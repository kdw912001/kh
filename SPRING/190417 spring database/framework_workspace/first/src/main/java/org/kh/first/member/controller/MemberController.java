package org.kh.first.member.controller;

import javax.servlet.http.HttpSession;

import org.kh.first.member.model.service.MemberService;
import org.kh.first.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	//MemberService DI
	@Autowired
	private MemberService memberService;

	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(Member member, 
			HttpSession session) {
		
		Member loginMember = memberService.selectLogin(member);
		
		session.setAttribute("loginMember", loginMember);
		
		return "home";
	}
	
}






