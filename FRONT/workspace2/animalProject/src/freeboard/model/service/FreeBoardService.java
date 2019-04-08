package freeboard.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import freeboard.model.dao.FreeBoardDao;
import freeboard.model.vo.FreeBoard;

public class FreeBoardService {
	private FreeBoardDao fdao = new FreeBoardDao();
	
	public FreeBoardService() {}
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = fdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	
	public ArrayList<FreeBoard> selectList() {
		Connection conn = getConnection();
		ArrayList<FreeBoard> list = fdao.selectList(conn);
		close(conn);
		return list;
	}

	
	public void addReadCount(int boardNum) {
		Connection conn = getConnection();
		int result = fdao.addReadCount(conn, boardNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}

	
	public FreeBoard selectFreeBoard(int freeboardNo) {
		Connection conn = getConnection();
	//	ArrayList<FreeBoard> list = new ArrayList<>();
		FreeBoard fboard = fdao.selectFreeBoard(conn, freeboardNo);
		
//		FreeBoard freeboard = fdao.selectBoard(conn, freeboardNo);
		close(conn);
		return fboard;
	}

	public int insertFreeBoard(FreeBoard freeBoard) {
		Connection conn = getConnection();
		int result = fdao.insertFreeBoard(conn, freeBoard);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}


	public int updateFreeBoard(FreeBoard freeboard) {
		Connection conn = getConnection();
		int result = fdao.updateFreeBoard(conn, freeboard);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	
	public int deleteFreeBoard(int boardNum) {
		Connection conn = getConnection();
		int result = fdao.deleteFreeBoard(conn, boardNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	
	
	public ArrayList<FreeBoard> boardSearchTitle (String title, int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<FreeBoard> list = fdao.selectTitleList(conn, title, currentPage, limit);
		close(conn);
		return list;
	}
	
	
	public ArrayList<FreeBoard> boardSearchWriter (String writer, int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<FreeBoard> list = fdao.selectWriterList(conn, writer, currentPage, limit);
		close(conn);
		return list;
	}
	
	
	public ArrayList<FreeBoard> boardSearchDate (Date begin, Date end, int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<FreeBoard> list = fdao.selectDateList(conn, begin, end, currentPage, limit);
		close(conn);
		return list;
	}

	
	
}

