package notice.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import notice.model.vo.Notice;

public class NoticeDao {
	public NoticeDao() {
	}

	public HashMap<Integer, Notice> selectMap(
			Connection conn) {
		HashMap<Integer, Notice> list = 
				new HashMap<Integer, Notice>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice order by noticeno desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeDate(rset.getDate("noticedate"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeContent(rset.getString("noticecontent"));
				notice.setOriginalFilePath(rset.getString("original_filepath"));
				notice.setRenameFilePath(rset.getString("rename_filepath"));
								
				list.put(notice.getNoticeNo(), notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public Notice selectOne(Connection conn, int noticeNo) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				
				notice.setNoticeNo(noticeNo);
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeDate(rset.getDate("noticedate"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeContent(rset.getString("noticecontent"));
				notice.setOriginalFilePath(rset.getString("original_filepath"));
				notice.setRenameFilePath(rset.getString("rename_filepath"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}

	public int insertNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into notice values "
				+ "((select max(noticeno) + 1 from notice), "
				+ "?, default, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeWriter());
			pstmt.setString(3, notice.getNoticeContent());
			pstmt.setString(4, notice.getOriginalFilePath());
			pstmt.setString(5, notice.getRenameFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
	
		return result;
	}

	public int updateNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update notice set "
				+ "noticetitle = ?, noticecontent = ?, "
				+ "original_filepath = ?, "
				+ "rename_filepath = ? "
				+ "where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());			
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getOriginalFilePath());
			pstmt.setString(4, notice.getRenameFilePath());
			pstmt.setInt(5, notice.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from notice "
				+ "where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}









