package org.kh.first.member.model.service;

import java.util.ArrayList;

import org.kh.first.member.model.vo.Member;

public interface MemberService {
	//추상메소드만 멤버로 가짐
	//[public abstract] 반환형 메소드명(자료형 매개변수);
	Member selectLogin(Member member);
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String userid);
	ArrayList<Member> selectList();
	Member selectMember(String userid);
	
}
