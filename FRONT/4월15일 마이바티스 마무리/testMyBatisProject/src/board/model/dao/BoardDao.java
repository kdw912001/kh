package board.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import board.model.vo.Board;
import notice.model.vo.SearchDate;

public class BoardDao {
	public BoardDao() {}

	public int getListCount(SqlSession session) {
		return session.selectOne("boardMapper.selectListCount");
	}

	public ArrayList<Board> selectList(
			SqlSession session, int currentPage, int limit) {
		RowBounds rowBounds = new RowBounds(
				currentPage, limit);
		List<Board> list = session.selectList(
				"boardMapper.selectList", rowBounds);		
		return (ArrayList<Board>)list;
	}

	public int addReadCount(SqlSession session, int bnum) {
		System.out.println(session + ", " + bnum);
		return session.selectOne("boardMapper.addReadCount", bnum);
	}

	public Board selectBoard(SqlSession session, int bnum) {
		return session.selectOne("boardMapper.selectBoard", bnum);
	}

	public int insertBoard(SqlSession session, Board board) {
		return session.insert("boardMapper.insertBoard", board);
	}

	public int insertReply1(SqlSession session, Board replyBoard) {
		return session.insert("boardMapper.insertReply1", replyBoard);
	}
	
	public int insertReply2(SqlSession session, Board replyBoard) {
		return session.insert("boardMapper.insertReply2", replyBoard);
	}

	public int updateReplySeq(SqlSession session, Board replyBoard) {
		return session.update("boardMapper.updateReplySeq", replyBoard);
	}

	public int updateReply(SqlSession session, Board reply) {
		return session.update("boardMapper.updateReply", reply);
	}

	public int updateBoard(SqlSession session, Board board) {
		return session.update("boardMapper.updateBoard", board);
	}

	public int deleteBoard(SqlSession session, int bnum) {
		return session.delete("boardMapper.deleteBoard", bnum);
	}

	public ArrayList<Board> selectDateList(
			SqlSession session, SearchDate date, int currentPage, int limit) {
		RowBounds rowBounds = new RowBounds(
				currentPage, limit);
		List<Board> list = session.selectList(
				"boardMapper.selectDateList", date, rowBounds);		
		return (ArrayList<Board>)list;
	}

	public ArrayList<Board> selectWriterList(
			SqlSession session, String writer, int currentPage, int limit) {
		RowBounds rowBounds = new RowBounds(
				currentPage, limit);
		List<Board> list = session.selectList(
				"boardMapper.selectWriterList", writer, rowBounds);		
		return (ArrayList<Board>)list;
	}

	public ArrayList<Board> selectTitleList(
			SqlSession session, String title, int currentPage, int limit) {
		RowBounds rowBounds = new RowBounds(
				currentPage, limit);
		List<Board> list = session.selectList(
				"boardMapper.selectTitleList", title, rowBounds);		
		return (ArrayList<Board>)list;
	}

	public ArrayList<Board> selectReadCountTop5(SqlSession session) {
		List<Board> list = session.selectList(
				"boardMapper.selectTop3");		
		return (ArrayList<Board>)list;
	}

	
}











