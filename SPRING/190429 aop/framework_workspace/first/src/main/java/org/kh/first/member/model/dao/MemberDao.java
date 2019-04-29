package org.kh.first.member.model.dao;

import org.kh.first.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public Member selectLogin(SqlSessionTemplate session, Member member) {
		Member loginMember = session.selectOne("memberMapper.selectLogin", member);
	
		if(!bcryptPasswordEncoder.matches(
				member.getUserpwd(), loginMember.getUserpwd())) {
			loginMember = null;
		}
		
		return loginMember;
	}

	public int insertMember(SqlSessionTemplate session, Member member) {
		return session.insert("memberMapper.insertMember", member);
	}

	public Member selectMember(SqlSessionTemplate session, String userid) {
		return session.selectOne("memberMapper.selectMember", userid);
	}

	public int deleteMember(SqlSessionTemplate session, String userid) {
		return session.delete("memberMapper.deleteMember", userid);
	}

	public int updateMember(SqlSessionTemplate session, Member member) {
		return session.update("memberMapper.updateMember", member);
	}

}










