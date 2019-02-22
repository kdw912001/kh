package board.model.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import board.exception.BoardException;
import board.model.vo.Board;
import static common.JdbcTemplate.*;

public class BoardDao {

	public Map<Integer, Board> selectList(Connection con) throws BoardException{
		Map<Integer, Board> map = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from board";
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null){
				map = new HashMap<Integer, Board>();
				while(rset.next()){
					Board b = new Board();
					b.setBoardNum(rset.getInt("board_num"));
					b.setBoardTitle(rset.getString("board_title"));
					b.setBoardWriter(rset.getString("board_writer"));
					b.setBoardContent(rset.getString("board_content"));
					b.setBoardDate(rset.getDate("board_date"));
					b.setBoardOriginalFileName(rset.getString("board_original_filename"));
					b.setBoardRenameFileName(rset.getString("board_rename_filename"));
					b.setBoardReadCount(rset.getInt("board_readcount"));
					b.setBoardReplyRef(rset.getInt("board_reply_ref"));
					b.setBoardReplyLev(rset.getInt("board_reply_lev"));
					b.setBoardReplySeq(rset.getInt("board_reply_seq"));
					
					map.put(b.getBoardNum(), b);
				}
			}else
				throw new BoardException("게시글 전체조회가 실패하였습니다.");
		} catch (Exception e) {
			throw new BoardException(e.getMessage());
		}finally{
			close(rset);
			close(stmt);
		}
		
		return map;
	}

}
//페이징 처리용 쿼리
/*SELECT * FROM (
	    SELECT p.*, ROW_NUMBER() OVER(ORDER BY id DESC) AS RNUM
	    FROM page_table p
	)
	WHERE RNUM BETWEEN 1 AND 20;*/
//http://hunit.tistory.com/204
