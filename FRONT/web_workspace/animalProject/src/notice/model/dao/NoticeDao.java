package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import notice.model.vo.Notice;

public class NoticeDao {
	public NoticeDao() {}
	
	public ArrayList<Notice> selectList(Connection conn) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice order by notice_no desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			System.out.println(1);
			while(rset.next()) {
				Notice notice = new Notice();
				//번호제목이름조회수날짜첨부파일
				notice.setNoticeNo(rset.getInt("notice_no"));
				notice.setNoticeTitle(rset.getString("notice_title"));
				notice.setManagerId(rset.getString("manager_id"));
				notice.setNoticeViews(rset.getInt("notice_views"));
				notice.setNoticeDate(rset.getDate("notice_date"));
				notice.setNoticeOriginFile(rset.getString("notice_originfile"));
				notice.setNoticeReFile(rset.getString("notice_refile"));
				list.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			
		}
		return list;
	}

	public int insertNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println("서비스확인중1");
		String query = "insert into notice values((select max(notice_no) + 1 from notice), ?, ?, sysdate, ?, 0, ?, 'N', ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getNoticeOriginFile());	
			pstmt.setString(4, notice.getManagerId());
			pstmt.setString(5, notice.getNoticeReFile());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("dao확인 : " + result);
		return result;
	}

	public Notice selectOne(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice where notice_no = ?";
		System.out.println("디테일쿼리");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				
				notice.setNoticeNo(noticeNo);
				notice.setNoticeTitle(rset.getString("notice_title"));
				notice.setNoticeDate(rset.getDate("notice_date"));
				notice.setManagerId(rset.getString("manager_id"));
				notice.setNoticeContent(rset.getString("notice_content"));
				notice.setNoticeOriginFile(rset.getString("notice_originfile"));
				notice.setNoticeReFile(rset.getString("notice_refile"));
			}
			System.out.println(notice.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "delete from notice where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int addReadCount(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update notice set notice_views = notice_views + 1 where notice_no =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
