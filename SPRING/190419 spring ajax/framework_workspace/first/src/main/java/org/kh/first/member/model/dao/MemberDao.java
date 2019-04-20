package org.kh.first.member.model.dao;

import org.kh.first.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {

	public Member selectLogin(SqlSessionTemplate session, Member member) {
		return session.selectOne("memberMapper.selectLogin", member);
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










