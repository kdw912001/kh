package member.model.dao;

import java.sql.*;
import static common.JDBCTemplate.*;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao() {}

	public Member selectLogin(Connection conn, String userId, String userPwd) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where userid = ? and userpwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member();
				
				loginUser.setUserId(userId);
				loginUser.setUserPwd(userPwd);
				loginUser.setUserName(rset.getString("username"));
				loginUser.setGender(rset.getString("gender"));
				loginUser.setAge(rset.getInt("age"));
				loginUser.setPhone(rset.getString("phone"));
				loginUser.setEmail(rset.getString("email"));
				loginUser.setHobby(rset.getString("hobby"));
				loginUser.setEtc(rset.getString("etc"));
				loginUser.setEnroll_date(rset.getDate("enroll_date"));
				loginUser.setLastmodified(rset.getDate("lastmodified"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}
}
