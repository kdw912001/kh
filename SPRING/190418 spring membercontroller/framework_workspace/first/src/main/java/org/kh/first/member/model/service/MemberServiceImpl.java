package org.kh.first.member.model.service;

import java.util.ArrayList;

import org.kh.first.member.model.dao.MemberDao;
import org.kh.first.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	//마이바티스 연동 객체 선언
	@Autowired
	private SqlSessionTemplate mybatisSession;
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member selectLogin(Member member) {
		return memberDao.selectLogin(mybatisSession, member);
	}

	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(mybatisSession, member);
	}

	@Override
	public int updateMember(Member member) {		
		return memberDao.updateMember(mybatisSession, member);
	}

	@Override
	public int deleteMember(String userid) {		
		return memberDao.deleteMember(mybatisSession, userid);
	}

	@Override
	public ArrayList<Member> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectMember(String userid) {		
		return memberDao.selectMember(mybatisSession, userid);
	}

}










