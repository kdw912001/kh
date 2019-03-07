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
}
