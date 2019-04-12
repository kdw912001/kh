package board.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import board.model.vo.Board;

public class BoardDao {
	public BoardDao() {}

	public int getListCount(SqlSession session) {
		return session.selectOne("boardMapper.getListCount");
	}

	public ArrayList<Board> selectList(SqlSession session, int currentPage, int limit) {
		/*RowBounds rowBounds = new RowBounds(
				currentPage, limit);
		List<Board> list = session.selectList(
				"boardMapper.selectList", rowBounds);		
		return (ArrayList<Board>)list;*/
		
		RowBounds rowBounds = new RowBounds(currentPage, limit);
		List<Board> list = session.selectList("boardMapper.selectList", rowBounds);
		
		//해당 페이지에 출력할 목록의 시작행과 끝행 계산
		/*int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;*/
		
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
			pstmt = session.prepareStatement(query);
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
		
		return (ArrayList<Board>)list;
	}

	public int addReadCount(SqlSession session, int boardNum) {
		return session.update("boardMapper.addReadCount", boardNum);
	}

	public Board selectBoard(SqlSession session, int boardNum) {
		return session.selectOne("boardMapper.selectBoard", boardNum);
	}

	public int insertBoard(SqlSession session, Board board) {
		return session.insert("boardMapper.insertBoard", board);
	}

	public int insertReply(SqlSession session, Board replyBoard) {
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
			pstmt = session.prepareStatement(query);
			
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

	public int updateReplySeq(SqlSession session, Board replyBoard) {
		return session.update("boardMapper.updateReplySeq", replyBoard);
	}

	public int updateReply(SqlSession session, Board board) {
		return session.update("boardMapper.updateReply", board);
	}

	public int updateBoard(SqlSession session, Board board) {
		return session.update("boardMapper.updateBoard", board);
	}

	public int deleteBoard(SqlSession session, int boardNum) {
		return session.delete("boardMapper.deleteBoard", boardNum);
	}

	public ArrayList<Board> selectDateList(SqlSession session, Date begin, Date end, int currentPage, int limit) {
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
			pstmt = session.prepareStatement(query);
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

	public ArrayList<Board> selectWriterList(SqlSession session, String writer, int currentPage, int limit) {
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
			pstmt = session.prepareStatement(query);
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

	public ArrayList<Board> selectTitleList(SqlSession session, String title, int currentPage, int limit) {
		RowBounds rowBounds = new RowBounds(currentPage, limit);
		List<Board> list = session.selectList("boardMapper.selectTitleList", title, rowBounds);
		/*int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		*/
		return (ArrayList<Board>)list;
	}

	public ArrayList<Board> selectReadCountTop5(SqlSession session) {
		List<Board> list = session.selectList("boardMapper.selectReadCountTop5");		
		return (ArrayList<Board>)list;
	}

	
}











