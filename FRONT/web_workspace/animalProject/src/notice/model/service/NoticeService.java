package notice.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import static common.JDBCTemplate.*;

public class NoticeService {
	private NoticeDao ndao = new NoticeDao();
	
	public NoticeService() {}
	
	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectList(conn);
		System.out.println(list.size());
		close(conn);
		return list;
	}

	public int insertNotice(Notice notice) {
		Connection conn = getConnection();
		int result = ndao.insertNotice(conn, notice);
		System.out.println("서비스확인중1");
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Notice selectOne(int noticeNo) {
		Connection conn = getConnection();
		Notice notice = ndao.selectOne(conn, noticeNo);
		System.out.println("서비스확인중1");
		close(conn);
		
		return notice;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		int result = ndao.deleteNotice(conn, noticeNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Notice> selectSearchTitle(String noticeTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Notice> selectSearchDate(Date valueOf, Date valueOf2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addReadCount(int noticeNo) {
		Connection conn = getConnection();
		int result = ndao.addReadCount(conn, noticeNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}

}
