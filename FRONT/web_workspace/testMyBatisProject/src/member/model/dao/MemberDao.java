package member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao() {}

	public Member selectLogin(SqlSession session, Member member) {
		return session.selectOne("memberMapper.selectLogin", member);
	}

	public int selectCheckId(SqlSession session, String userId) {
		return session.selectOne("memberMapper.selectCheckId",userId);
	}

	public int insertMember(SqlSession session, Member member) {
		return session.insert("memberMapper.insertMember", member);
	}

	public Member selectMember(SqlSession session, String userId) {
		return session.selectOne("memberMapper.selectMember", userId);
	}

	public int updateMember(SqlSession session, Member member) {
		return session.update("memberMapper.updateMember", member);
	}

	public int deleteMember(SqlSession session, String userId) {
		return session.delete("memberMapper.deleteMember", userId);
	}

	public ArrayList<Member> selectList(SqlSession session) {
		List<Member> list = session.selectList("memberMapper.selectList");
		//1. Object를 Member로 변환
		//2. List를 ArrayList로 변환
		//1,2 한번에 하려면 괄호를 여러 번 묶어야됨.
		return (ArrayList<Member>)list;
	}
}







