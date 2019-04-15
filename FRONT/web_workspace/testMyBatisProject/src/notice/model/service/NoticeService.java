package notice.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.SearchDate;

import static common.SqlSessionTemplate.getSession;

public class NoticeService {
	private NoticeDao ndao = new NoticeDao();
	
	public NoticeService() {}
	
	/*private SqlSession getSession() {
		SqlSession mybatis = null;
		try {
			mybatis = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/mybatis-config.xml")).openSession(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mybatis;
	}*/
	
	public HashMap<Integer, Notice> selectMap(){
		SqlSession session = getSession();
		HashMap<Integer, Notice> list = ndao.selectMap(session);
		session.close();
		return list;
	}
	
	public Notice selectOne(int noticeNo) {
		SqlSession session = getSession();
		Notice notice = ndao.selectOne(session, noticeNo);
		session.close();
		return notice;
	}
	
	public int insertNotice(Notice notice) {
		SqlSession session = getSession();
		int result = ndao.insertNotice(session, notice);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}
	
	public int updateNotice(Notice notice) {
		SqlSession session = getSession();
		int result = ndao.updateNotice(session, notice);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}
	
	public int deleteNotice(int noticeNo) {
		SqlSession session = getSession();
		int result = ndao.deleteNotice(session, noticeNo);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public HashMap<Integer, Notice> selectSearchTitle(String noticeTitle) {
		SqlSession session = getSession();
		HashMap<Integer, Notice> map = ndao.selectSearchTitle(session, noticeTitle);
		session.close();
		return map;
	}

	public HashMap<Integer, Notice> selectSearchWriter(
			String noticeWriter) {
		SqlSession session = getSession();
		HashMap<Integer, Notice> map = ndao.selectSearchWriter(session, noticeWriter);
		session.close();
		return map;
	}

	public HashMap<Integer, Notice> selectSearchDate(SearchDate date) {
		SqlSession session = getSession();
		HashMap<Integer, Notice> map = ndao.selectSearchDate(session, date);
		session.close();
		return map;
	}

	public ArrayList<Notice> selectTop5Write() {
		SqlSession session = getSession();
		ArrayList<Notice> list = ndao.selectTop5Write(session);
		session.close();
		return list;
	}
}











