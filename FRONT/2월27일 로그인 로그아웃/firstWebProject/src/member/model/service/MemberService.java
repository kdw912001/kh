package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}

	public Member selectLogin(String userId, String userPwd) {
		Connection conn = getConnection();
		Member loginUser = 
				mdao.selectLogin(conn, userId, userPwd);
		close(conn);
		return loginUser;
	}
}









