package board.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;

public class BoardService {
	private BoardDao bdao = new BoardDao();
	
	public BoardService() {}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = bdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectList(conn, currentPage, limit);
		close(conn);
		return list;
	}

	public void addReadCount(int boardNum) {
		Connection conn = getConnection();
		int result = bdao.addReadCount(conn, boardNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}

	public Board selectBoard(int boardNum) {
		Connection conn = getConnection();
		Board board = bdao.selectBoard(conn, boardNum);
		close(conn);
		return board;
	}

	public int insertBoard(Board board) {
		Connection conn = getConnection();
		int result = bdao.insertBoard(conn, board);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public void updateReplySeq(Board replyBoard) {
		Connection conn = getConnection();
		int result = bdao.updateReplySeq(conn, replyBoard);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return;
	}

	public int insertReply(Board replyBoard) {
		Connection conn = getConnection();
		int result = bdao.insertReply(conn, replyBoard);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateReply(Board board) {
		Connection conn = getConnection();
		int result = bdao.updateReply(conn, board);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateBoard(Board board) {
		Connection conn = getConnection();
		int result = bdao.updateBoard(conn, board);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteBoard(int boardNum) {
		Connection conn = getConnection();
		int result = bdao.deleteBoard(conn, boardNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public ArrayList<Board> boardSearchTitle(String title, int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectTitleList(conn, title, currentPage, limit);
		close(conn);
		return list;
	}
	
	public ArrayList<Board> boardSearchWriter(String writer, int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectWriterList(conn, writer, currentPage, limit);
		close(conn);
		return list;
	}
	
	public ArrayList<Board> boardSearchDate(Date begin, Date end, int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectDateList(conn, begin, end, currentPage, limit);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectReadCountTop5() {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectReadCountTop5(conn);
		close(conn);
		return list;
	}
	
}





