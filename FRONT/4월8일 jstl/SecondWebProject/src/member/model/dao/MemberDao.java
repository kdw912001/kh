package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao() {}

	public Member selectLogin(
		Connection conn, String userId, String userPwd) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member "
				+ "where userid = ? and userpwd = ?";
		
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
				loginUser.setEnrollDate(rset.getDate("enroll_date"));
				loginUser.setLastModified(rset.getDate("lastmodified"));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	public int selectCheckId(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(userid) from member "
				+ "where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			System.out.println("result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into member "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ "sysdate, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getHobby());
			pstmt.setString(9, member.getEtc());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member "
					+ "where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
						
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				
				member.setUserId(userId);
				member.setUserPwd(rset.getString("userpwd"));
				member.setUserName(rset.getString("username"));
				member.setGender(rset.getString("gender"));
				member.setAge(rset.getInt("age"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
				member.setHobby(rset.getString("hobby"));
				member.setEtc(rset.getString("etc"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				member.setLastModified(rset.getDate("lastmodified"));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update member "
				+ "set userpwd = ?, age = ?, "
				+ "email = ?, phone = ?, etc = ?, "
				+ "hobby = ? where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, member.getUserPwd());		
			pstmt.setInt(2, member.getAge());			
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getPhone());			
			pstmt.setString(5, member.getEtc());
			pstmt.setString(6, member.getHobby());
			pstmt.setString(7, member.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from member where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> selectList(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getString("userid"));
				member.setUserPwd(rset.getString("userpwd"));
				member.setUserName(rset.getString("username"));
				member.setGender(rset.getString("gender"));
				member.setAge(rset.getInt("age"));
				member.setPhone(rset.getString("phone"));
				member.setEmail(rset.getString("email"));
				member.setHobby(rset.getString("hobby"));
				member.setEtc(rset.getString("etc"));
				member.setEnrollDate(rset.getDate("enroll_date"));
				member.setLastModified(rset.getDate("lastmodified"));		
				
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	
}







