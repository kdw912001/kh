package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}

	public Member loginMember(String userid, String userpwd) {
		Connection conn = getConnection();
		System.out.println(userid +"=service="+userpwd);
		Member loginUser = mdao.loginCheck(conn, userid, userpwd);
		System.out.println("loginUser : " + loginUser);
		close(conn);
		
		return loginUser;
	}

	public int findPassword(Member member) {
		Connection conn = getConnection();
		int result = mdao.findPassword(conn, member);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}

	public int updateTempPassword(Member member) {
		Connection conn = getConnection();
		int result = mdao.updateTempPassword(conn, member);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = mdao.insertMember(conn, member);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	

	

}
