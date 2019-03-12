package board.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Board;

public class BoardDao {
	public BoardDao() {}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from board";
		
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

	public ArrayList<Board> selectList(
			Connection conn, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//해당 페이지에 출력할 목록의 시작행과 끝행 계산
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = "SELECT * " + 
				"FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_WRITER, " + 
				"BOARD_TITLE, BOARD_CONTENT, " + 
				"BOARD_ORIGINAL_FILENAME, " + 
				"BOARD_RENAME_FILENAME, BOARD_REF, " + 
				"BOARD_REPLY_REF, BOARD_REPLY_LEV, " + 
				"BOARD_REPLY_SEQ, BOARD_READCOUNT, " + 
				"BOARD_DATE " + 
				"FROM (SELECT * FROM BOARD " + 
				"ORDER BY BOARD_REF DESC, BOARD_REPLY_REF ASC, " + 
				"BOARD_REPLY_LEV ASC, BOARD_REPLY_SEQ ASC))" + 
				"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board board = new Board();
				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setBoardOriginalFileName(rset.getString("board_original_filename"));
				board.setBoardRenameFileName(rset.getString("board_rename_filename"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int addReadCount(Connection conn, int boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board "
				+ "set board_readcount = board_readcount + 1 "
				+ "where board_num = ?";
		
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

	public Board selectBoard(Connection conn, int boardNum) {
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from board "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board = new Board();
				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setBoardOriginalFileName(rset.getString("board_original_filename"));
				board.setBoardRenameFileName(rset.getString("board_rename_filename"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	public int insertBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into board values "
				+ "((select max(board_num) + 1 from board), "
				+ "?, ?, ?, ?, ?, "
				+ "(select max(board_num) + 1 from board), "
				+ "0, 0, 0, default, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardWriter());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getBoardOriginalFileName());
			pstmt.setString(5, board.getBoardRenameFileName());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReply(Connection conn, Board replyBoard) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		//원글의 댓글일 때
		if(replyBoard.getBoardReplyLev() == 1) {
			query = "insert into board values "
				+ "((select max(board_num) + 1 from board), "
				+ "?, ?, ?, NULL, NULL, ?, "
				+ "(select max(board_num) + 1 from board), "
				+ "1, ?, default, default)";
		}
		
		//댓글의 댓글일 때
		if(replyBoard.getBoardReplyLev() == 2) {
			query = "insert into board values "
				+ "((select max(board_num) + 1 from board), "
				+ "?, ?, ?, NULL, NULL, "
				+ "?, ?, 2, ?, default, default)";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, replyBoard.getBoardWriter());
			pstmt.setString(2, replyBoard.getBoardTitle());
			pstmt.setString(3, replyBoard.getBoardContent());
			pstmt.setInt(4, replyBoard.getBoardRef());
			
			if(replyBoard.getBoardReplyLev() == 1)
				pstmt.setInt(5, replyBoard.getBoardReplySeq());
			
			if(replyBoard.getBoardReplyLev() == 2) {
				pstmt.setInt(5, replyBoard.getBoardReplyRef());
				pstmt.setInt(6, replyBoard.getBoardReplySeq());
			}
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReplySeq(Connection conn, Board replyBoard) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board "
					+ "set board_reply_seq = board_reply_seq + 1 "
					+ "where board_ref = ? "
					+ "and board_reply_lev = ? "
					+ "and board_reply_ref = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replyBoard.getBoardRef());
			pstmt.setInt(2, replyBoard.getBoardReplyLev());
			pstmt.setInt(3, replyBoard.getBoardReplyRef());
			
			result = pstmt.executeUpdate();
			System.out.println("dao: " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReply(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board "
				+ "set board_title = ?, board_content = ? "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board "
				+ "set board_title = ?, "
				+ "board_content = ?, "
				+ "board_original_filename = ?, "
				+ "board_rename_filename = ? "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, board.getBoardOriginalFileName());
			pstmt.setString(4, board.getBoardRenameFileName());
			pstmt.setInt(5, board.getBoardNum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, int boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from board "
				+ "where board_num = ?";
		
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

	public ArrayList<Board> selectDateList(Connection conn, Date begin, Date end, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//해당 페이지에 출력할 목록의 시작행과 끝행 계산
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = "SELECT * " + 
				"FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_WRITER, " + 
				"BOARD_TITLE, BOARD_CONTENT, " + 
				"BOARD_ORIGINAL_FILENAME, " + 
				"BOARD_RENAME_FILENAME, BOARD_REF, " + 
				"BOARD_REPLY_REF, BOARD_REPLY_LEV, " + 
				"BOARD_REPLY_SEQ, BOARD_READCOUNT, " + 
				"BOARD_DATE " + 
				"FROM (SELECT * FROM BOARD where board_date between ? and ? " + 
				"ORDER BY BOARD_REF DESC, BOARD_REPLY_REF ASC, " + 
				"BOARD_REPLY_LEV ASC, BOARD_REPLY_SEQ ASC))" + 
				"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, begin);
			pstmt.setDate(2, end);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board board = new Board();
				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setBoardOriginalFileName(rset.getString("board_original_filename"));
				board.setBoardRenameFileName(rset.getString("board_rename_filename"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectWriterList(Connection conn, String writer, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//해당 페이지에 출력할 목록의 시작행과 끝행 계산
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = "SELECT * " + 
				"FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_WRITER, " + 
				"BOARD_TITLE, BOARD_CONTENT, " + 
				"BOARD_ORIGINAL_FILENAME, " + 
				"BOARD_RENAME_FILENAME, BOARD_REF, " + 
				"BOARD_REPLY_REF, BOARD_REPLY_LEV, " + 
				"BOARD_REPLY_SEQ, BOARD_READCOUNT, " + 
				"BOARD_DATE " + 
				"FROM (SELECT * FROM BOARD where board_writer like ? " + 
				"ORDER BY BOARD_REF DESC, BOARD_REPLY_REF ASC, " + 
				"BOARD_REPLY_LEV ASC, BOARD_REPLY_SEQ ASC))" + 
				"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, writer);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board board = new Board();
				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setBoardOriginalFileName(rset.getString("board_original_filename"));
				board.setBoardRenameFileName(rset.getString("board_rename_filename"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectTitleList(Connection conn, String title, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//해당 페이지에 출력할 목록의 시작행과 끝행 계산
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = "SELECT * " + 
				"FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_WRITER, " + 
				"BOARD_TITLE, BOARD_CONTENT, " + 
				"BOARD_ORIGINAL_FILENAME, " + 
				"BOARD_RENAME_FILENAME, BOARD_REF, " + 
				"BOARD_REPLY_REF, BOARD_REPLY_LEV, " + 
				"BOARD_REPLY_SEQ, BOARD_READCOUNT, " + 
				"BOARD_DATE " + 
				"FROM (SELECT * FROM BOARD where board_title like ? " + 
				"ORDER BY BOARD_REF DESC, BOARD_REPLY_REF ASC, " + 
				"BOARD_REPLY_LEV ASC, BOARD_REPLY_SEQ ASC))" + 
				"WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + title + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board board = new Board();
				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setBoardOriginalFileName(rset.getString("board_original_filename"));
				board.setBoardRenameFileName(rset.getString("board_rename_filename"));
				board.setBoardReplyLev(rset.getInt("board_reply_lev"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	
}











