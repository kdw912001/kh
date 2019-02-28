package member.model.service;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}

	public Member selectLogin(String userId, String userPwd) {
		Connection conn = getConnection();
		Member loginUser = mdao.selectLogin(conn, userId, userPwd);
		close(conn);
		return loginUser;
	}

	public int selectCheckId(String userId) {
		Connection conn = getConnection();
		int result = mdao.selectCheckId(conn, userId);
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
