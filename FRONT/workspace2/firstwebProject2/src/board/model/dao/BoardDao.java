package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Board;

import static common.JDBCTemplate.*;
public class BoardDao {

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
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<Board> selectList(Connection conn, int currentPage, int limit) {
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//해당 페이지에 출력할 목록의 시작행과 끝행
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit -1;
		String query = "SELECT * " + 
				"FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_WRITER, BOARD_TITLE, BOARD_CONTENT, " + 
				"BOARD_ORIGINAL_FILENAME,BOARD_RENAME_FILENAME,BOARD_REF," + 
				"BOARD_REPLY_REF,BOARD_REPLY_LEV,BOARD_REPLY_SEQ,BOARD_READCOUNT,BOARD_DATE " + 
				"FROM (SELECT * FROM BOARD " + 
				"      ORDER BY BOARD_REF DESC, BOARD_REPLY_REF DESC, BOARD_REPLY_LEV ASC, BOARD_REPLY_SEQ ASC)) " + 
				"WHERE RNUM >= ? AND RNUM <= ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board();
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardOriginalFileName(rset.getString("BOARD_ORIGINAL_FILENAME"));
				board.setBoardRenameFileName(rset.getString("BOARD_RENAME_FILENAME"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("BOARD_REPLY_REF"));
				board.setBoardReplyLev(rset.getInt("BOARD_REPLY_LEV"));
				board.setBoardReplySeq(rset.getInt("BOARD_REPLY_SEQ"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				board.setBoardDate(rset.getDate("board_date"));
				
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int addReadCount(Connection conn, int boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update board set board_readcount = board_readcount + 1 where board_num = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Board selectBoard(Connection conn, int boardNum) {
		Board board = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from board where board_num = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			rset = pstmt.executeQuery();
			if(rset.next()) {				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardOriginalFileName(rset.getString("BOARD_ORIGINAL_FILENAME"));
				board.setBoardRenameFileName(rset.getString("BOARD_RENAME_FILENAME"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("BOARD_REPLY_REF"));
				board.setBoardReplyLev(rset.getInt("BOARD_REPLY_LEV"));
				board.setBoardReplySeq(rset.getInt("BOARD_REPLY_SEQ"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				board.setBoardDate(rset.getDate("board_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return board;
	}

}
