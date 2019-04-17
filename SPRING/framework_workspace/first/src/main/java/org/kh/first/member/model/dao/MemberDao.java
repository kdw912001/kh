package org.kh.first.member.model.dao;

import org.kh.first.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {

	public Member selectLogin(SqlSessionTemplate session, Member member) {
		return session.selectOne("memberMapper.selectLogin", member);
	}

}
