package board.model.service;

import board.model.dao.BoardDao;
import board.model.vo.Board;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
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
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
	}

	public Board selectBoard(int boardNum) {
		Connection conn= getConnection();
		Board board = bdao.selectBoard(conn, boardNum);
		close(conn);
		return board;
	}

	public int insertBoard(Board board) {
		Connection conn = getConnection();
		int result = bdao.insertBoard(conn, board);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public void updateReplySeq(Board replyBoard) {
		Connection conn = getConnection();
		int result = bdao.updateReplySeq(conn, replyBoard);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}

	public int insertReply(Board replyBoard) {
		Connection conn = getConnection();
		int result = bdao.insertReply(conn, replyBoard);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
}
