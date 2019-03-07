package board.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
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
		
		String query = "SELECT * \r\n" + 
				"FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_WRITER,\r\n" + 
				"                BOARD_TITLE, BOARD_CONTENT, \r\n" + 
				"                BOARD_ORIGINAL_FILENAME, \r\n" + 
				"                BOARD_RENAME_FILENAME, BOARD_REF, \r\n" + 
				"                BOARD_REPLY_REF, BOARD_REPLY_LEV, \r\n" + 
				"                BOARD_REPLY_SEQ, BOARD_READCOUNT,\r\n" + 
				"                BOARD_DATE \r\n" + 
				"        FROM (SELECT * FROM BOARD\r\n" + 
				"               ORDER BY BOARD_REF DESC, BOARD_REPLY_REF DESC, \r\n" + 
				"                         BOARD_REPLY_LEV ASC, BOARD_REPLY_SEQ ASC))\r\n" + 
				"WHERE RNUM >= 1 AND RNUM <= 10";
		
		
		
		return list;
	}
	
	
}











