package member.model.service;

import member.model.dao.MemberDao;
import member.model.vo.Member;

import static common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {
	//의존성 주입 (DI : Dependancy Injection)
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}
	
	public Member selectLogin(
			String userId, String userPwd) {
		Connection conn = getConnection();
		Member member = mdao.selectLogin(
						conn, userId, userPwd);
		close(conn);
		return member;
	}
}










