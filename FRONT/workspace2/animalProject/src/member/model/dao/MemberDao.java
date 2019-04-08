package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static common.JDBCTemplate.*;
import member.model.vo.Member;

public class MemberDao {
	private StringBuffer query = new StringBuffer();
	public MemberDao () {}

	public Member loginCheck(Connection conn, String userid, String userpwd) {
		// 로그인 확인
		/*ArrayList<Member> loginUser = new ArrayList<> ();*/
		Member member = null;
		PreparedStatement pstat = null;
		ResultSet rSet = null;
		query.append("select * from member where user_id = ? and password = ?");
		/*String query = "select * from member where user_id = ? and password = ?";*/
		System.out.println(userid +", "+userpwd);
		try {
			pstat = conn.prepareStatement(query.toString());
			pstat.setString(1, userid);
			pstat.setString(2, userpwd);
			rSet = pstat.executeQuery();
			
			if(rSet.next()) {
				member = new Member();
				member.setUserId(userid);
				member.setEmail(rSet.getString("email"));
				member.setUserName(rSet.getString("user_name"));
				member.setAddress(rSet.getString("address"));
				member.setPhone(rSet.getString("phone"));
				member.setJob(rSet.getString("job"));
				member.setPetSitter(rSet.getString("petsitter"));
				member.setPrice(rSet.getInt("price"));
				member.setUserDate(rSet.getDate("user_date"));
				member.setUserPwd(userpwd);
				member.setUserDelete(rSet.getString("user_delete"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pstat);
		}
		
		return member;
	}

	public int findPassword(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstat = null;
		ResultSet rSet = null;
		query.append("select count(*) from member where user_id = ? and email = ?");
		
		try {
			pstat = conn.prepareStatement(query.toString());
			pstat.setString(1, member.getUserId());
			pstat.setString(2, member.getEmail());
			
			rSet = pstat.executeQuery();
			if(rSet.next()) {
				result = rSet.getInt(1);
			}
			System.out.println("findPwd result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pstat);
		}
		
		return result;
	}

	public int updateTempPassword(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstat = null;
		query.append("update member set password = ? where user_id = ?");
		try {
			pstat = conn.prepareStatement(query.toString());
			
			pstat.setString(1, member.getUserPwd());
			pstat.setString(2, member.getUserId());
			
			result = pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstat);
		}
		return result;
	}

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstat = null;
		
		query.append("insert into member values ( ");
		query.append("?,?,?,?,?,?,?,?,sysdate,?,? )");
		
		try {
			
			pstat = conn.prepareStatement(query.toString());
			
			pstat.setString(1, member.getUserId());
			pstat.setString(2, member.getEmail());
			pstat.setString(3, member.getUserName());
			pstat.setString(4, member.getAddress());
			pstat.setString(5, member.getPhone());
			pstat.setString(6, member.getJob());
			pstat.setString(7, "n");
			pstat.setInt(8, 0);
			pstat.setString(9, member.getUserPwd());
			pstat.setString(10, "n");
			
			result = pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstat);
		}
		return result;
	}

	
}
