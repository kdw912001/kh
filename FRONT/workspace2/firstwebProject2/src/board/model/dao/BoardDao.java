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
		String query = "SELECT *\r\n" + 
				"FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_WRITER, BOARD_TITLE, BOARD_CONTENT, \r\n" + 
				"BOARD_ORIGINAL_FILENAME,BOARD_RENAME_FILENAME,BOARD_REF,\r\n" + 
				"BOARD_REPLY_REF,BOARD_REPLY_LEV,BOARD_REPLY_SEQ,BOARD_READCOUNT,BOARD_DATE\r\n" + 
				"FROM (SELECT * FROM BOARD\r\n" + 
				"      ORDER BY BOARD_REF DESC, BOARD_REPLY_REF DESC, BOARD_REPLY_LEV ASC, BOARD_REPLY_SEQ ASC))\r\n" + 
				"WHERE RNUM >= 11 AND RNUM <= 20;";
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}
