package board.model.service;

import java.sql.Connection;
import java.util.Map;

import board.exception.BoardException;
import board.model.dao.BoardDao;
import board.model.vo.Board;
import static common.JdbcTemplate.*;

public class BoardService {

	public Map<Integer, Board> selectList() throws BoardException{
		Connection con = getConnection();
		Map<Integer, Board> map = new BoardDao().selectList(con);
		close(con);
		return map;
	}

}
