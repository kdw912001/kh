package freeboard.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import freeboard.model.vo.FreeBoard;

public class FreeBoardDao {

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from freeboard";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	
	public FreeBoard selectFreeBoard(Connection conn, int boardNum) {
		FreeBoard freeboard = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from freeboard "
				+ "where freeboard_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				freeboard = new FreeBoard();
				
				freeboard.setFreeboardNo(rset.getInt("FREEBOARD_NO"));
				freeboard.setFreeboardTitle(rset.getString("FREEBOARD_TITLE"));
				freeboard.setFreeboardContent(rset.getString("FREEBOARD_CONTENT"));
				freeboard.setFreeboardDate(rset.getDate("FREEBOARD_DATE"));
				freeboard.setFreeboardOriginalFile(rset.getString("FREEBOARD_ORIGINFILE"));
				freeboard.setFreeboardViews(rset.getInt("FREEBOARD_VIEWS"));
				freeboard.setFreeboardRecommend(rset.getInt("FREEBOARD_RECOMMEND"));
				freeboard.setUserId(rset.getString("USER_ID"));
				freeboard.setFreeboardDelete(rset.getString("FREEBOARD_DELETE"));
				freeboard.setFreeboardRefile(rset.getString("FREEBOARD_REFILE"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return freeboard;
	}


	public ArrayList<FreeBoard> selectList(Connection conn) {
		ArrayList<FreeBoard> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from freeboard";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				
				FreeBoard freeboard = new FreeBoard();
				
				freeboard.setFreeboardNo(rset.getInt("FREEBOARD_NO"));
				freeboard.setFreeboardTitle(rset.getString("FREEBOARD_TITLE"));
				freeboard.setFreeboardContent(rset.getString("FREEBOARD_CONTENT"));
				freeboard.setFreeboardDate(rset.getDate("FREEBOARD_DATE"));
				freeboard.setFreeboardOriginalFile(rset.getString("FREEBOARD_ORIGINFILE"));
				freeboard.setFreeboardViews(rset.getInt("FREEBOARD_VIEWS"));
				freeboard.setFreeboardRecommend(rset.getInt("FREEBOARD_RECOMMEND"));
				freeboard.setUserId(rset.getString("USER_ID"));
				freeboard.setFreeboardDelete(rset.getString("FREEBOARD_DELETE"));
				freeboard.setFreeboardRefile(rset.getString("FREEBOARD_REFILE"));
				
				list.add(freeboard);
				}
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}


	public int insertFreeBoard(Connection conn, FreeBoard freeboard) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into freeboard values "
				+ "((select max(freeboard_no) + 1 from freeboard), "
				+ "?, ?, ,sysdate, ?, default, default, ?, default, ?) ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, freeboard.getFreeboardTitle());
			pstmt.setString(2, freeboard.getFreeboardContent());
			pstmt.setString(3, freeboard.getFreeboardOriginalFile());
			pstmt.setString(4, freeboard.getUserId());
			pstmt.setString(5, freeboard.getFreeboardRefile());
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public ArrayList<FreeBoard> selectTitleList(Connection conn, String title, int currentPage, int limit) {
		ArrayList<FreeBoard> list = new ArrayList<FreeBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from freeboard where freeboard_title like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + title + "%");
			
			rset = pstmt.executeQuery();
			
				while(rset.next()) {
					FreeBoard freeboard = new FreeBoard();
					
					freeboard.setFreeboardNo(rset.getInt("FREEBOARD_NO"));
					freeboard.setFreeboardTitle(rset.getString("FREEBOARD_TITLE"));
					freeboard.setFreeboardContent(rset.getString("FREEBOARD_CONTENT"));
					freeboard.setFreeboardDate(rset.getDate("FREEBOARD_DATE"));
					freeboard.setFreeboardOriginalFile(rset.getString("FREEBOARD_ORIGINFILE"));
					freeboard.setFreeboardViews(rset.getInt("FREEBOARD_VIEWS"));
					freeboard.setFreeboardRecommend(rset.getInt("FREEBOARD_RECOMMEND"));
					freeboard.setUserId(rset.getString("USER_ID"));
					freeboard.setFreeboardDelete(rset.getString("FREEBOARD_DELETE"));
					freeboard.setFreeboardRefile(rset.getString("FREEBOARD_REFILE"));
					
					list.add(freeboard);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public ArrayList<FreeBoard> selectWriterList(Connection conn, String userid, int currentPage, int limit) {
		ArrayList<FreeBoard> list = new ArrayList<FreeBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from freeboard where user_id like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + userid + "%");
			
			rset = pstmt.executeQuery();
			
				while(rset.next()) {
					FreeBoard freeboard = new FreeBoard();
					
					freeboard.setFreeboardNo(rset.getInt("FREEBOARD_NO"));
					freeboard.setFreeboardTitle(rset.getString("FREEBOARD_TITLE"));
					freeboard.setFreeboardContent(rset.getString("FREEBOARD_CONTENT"));
					freeboard.setFreeboardDate(rset.getDate("FREEBOARD_DATE"));
					freeboard.setFreeboardOriginalFile(rset.getString("FREEBOARD_ORIGINFILE"));
					freeboard.setFreeboardViews(rset.getInt("FREEBOARD_VIEWS"));
					freeboard.setFreeboardRecommend(rset.getInt("FREEBOARD_RECOMMEND"));
					freeboard.setUserId(rset.getString("USER_ID"));
					freeboard.setFreeboardDelete(rset.getString("FREEBOARD_DELETE"));
					freeboard.setFreeboardRefile(rset.getString("FREEBOARD_REFILE"));
					
					list.add(freeboard);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public ArrayList<FreeBoard> selectDateList(Connection conn, Date begin, Date end, int currentPage, int limit) {
		ArrayList<FreeBoard> list = new ArrayList<FreeBoard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from freeboard where board_date between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, begin);
			pstmt.setDate(2, end);
			rset = pstmt.executeQuery();
			
				while(rset.next()) {
					FreeBoard freeboard = new FreeBoard();
					
					freeboard.setFreeboardNo(rset.getInt("FREEBOARD_NO"));
					freeboard.setFreeboardTitle(rset.getString("FREEBOARD_TITLE"));
					freeboard.setFreeboardContent(rset.getString("FREEBOARD_CONTENT"));
					freeboard.setFreeboardDate(rset.getDate("FREEBOARD_DATE"));
					freeboard.setFreeboardOriginalFile(rset.getString("FREEBOARD_ORIGINFILE"));
					freeboard.setFreeboardViews(rset.getInt("FREEBOARD_VIEWS"));
					freeboard.setFreeboardRecommend(rset.getInt("FREEBOARD_RECOMMEND"));
					freeboard.setUserId(rset.getString("USER_ID"));
					freeboard.setFreeboardDelete(rset.getString("FREEBOARD_DELETE"));
					freeboard.setFreeboardRefile(rset.getString("FREEBOARD_REFILE"));
					
					list.add(freeboard);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public int deleteFreeBoard(Connection conn, int boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from board where freeboard_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);				
			pstmt.setInt(1, boardNum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateFreeBoard(Connection conn, FreeBoard freeboard) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update freeboard "
				+ "set freeboard_title = ?, "
				+ "freeboard_content = ?, "
				+ "FREEBOARD_ORIGINFILE = ?, "
				+ "FREEBOARD_REFILE = ? "
				+ "where freeboard_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, freeboard.getFreeboardTitle());
			pstmt.setString(2, freeboard.getFreeboardContent());
			pstmt.setString(3, freeboard.getFreeboardOriginalFile());
			pstmt.setString(4, freeboard.getFreeboardRefile());
			pstmt.setInt(5, freeboard.getFreeboardNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int addReadCount(Connection conn, int boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update freeboard "
				+ "set freeboard_views = freeboard_views + 1 "
				+ "where freeboard_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
	
	
	



