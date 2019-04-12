package board.model.service;


import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import notice.model.vo.SearchDate;

public class BoardService {
	private BoardDao bdao = new BoardDao();
	
	public BoardService() {}

	private SqlSession getSession() {
		SqlSession session = null;
		try {			
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return session;
	}
	
	public int getListCount() {
		SqlSession session = getSession();
		int listCount = bdao.getListCount(session);
		session.close();
		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		SqlSession session = getSession();
		ArrayList<Board> list = bdao.selectList(session, currentPage, limit);
		session.close();
		return list;
	}

	public void addReadCount(int boardNum) {
		SqlSession session = getSession();
		int result = bdao.addReadCount(session, boardNum);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
	}

	public Board selectBoard(int boardNum) {
		SqlSession session = getSession();
		Board board = bdao.selectBoard(session, boardNum);
		session.close();
		return board;
	}

	public int insertBoard(Board board) {
		SqlSession session = getSession();
		int result = bdao.insertBoard(session, board);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public void updateReplySeq(Board replyBoard) {
		SqlSession session = getSession();
		int result = bdao.updateReplySeq(session, replyBoard);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return;
	}

	public int insertReply(Board replyBoard) {
		SqlSession session = getSession();
		int result = bdao.insertReply(session, replyBoard);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public int updateReply(Board board) {
		SqlSession session = getSession();
		int result = bdao.updateReply(session, board);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public int updateBoard(Board board) {
		SqlSession session = getSession();
		int result = bdao.updateBoard(session, board);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public int deleteBoard(int boardNum) {
		SqlSession session = getSession();
		int result = bdao.deleteBoard(session, boardNum);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}
	
	public ArrayList<Board> boardSearchTitle(String title, int currentPage, int limit){
		SqlSession session = getSession();
		ArrayList<Board> list = bdao.selectTitleList(session, title, currentPage, limit);
		session.close();
		return list;
	}
	
	public ArrayList<Board> boardSearchWriter(String writer, int currentPage, int limit){
		SqlSession session = getSession();
		ArrayList<Board> list = bdao.selectWriterList(session, writer, currentPage, limit);
		session.close();
		return list;
	}
	
	public ArrayList<Board> boardSearchDate(SearchDate date, int currentPage, int limit){
		SqlSession session = getSession();
		ArrayList<Board> list = bdao.selectDateList(session, date, currentPage, limit);
		session.close();
		return list;
	}

	public ArrayList<Board> selectReadCountTop5() {
		SqlSession session = getSession();
		ArrayList<Board> list = bdao.selectReadCountTop5(session);
		session.close();
		return list;
	}
	
}





