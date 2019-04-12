package notice.model.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;
import notice.model.vo.SearchDate;

public class NoticeDao {
	public NoticeDao() {	}

	public HashMap<Integer, Notice> selectMap(SqlSession session) {
		/*HashMap<Integer, Notice> list = new HashMap<Integer, Notice>();
		session.selectMap("noticeMapper.selectMap",list);*/
		Map<Integer, Notice> list = session.selectMap("noticeMapper.selectMap", "noticeNo");
		return (HashMap<Integer,Notice>)list;
	}

	public Notice selectOne(SqlSession session, int noticeNo) {
		return session.selectOne("noticeMapper.selectOne", noticeNo);
	}

	public int insertNotice(SqlSession session, Notice notice) {
		return session.insert("noticeMapper.insertNotice", notice);
	}

	public int updateNotice(SqlSession session, Notice notice) {
		return session.update("noticeMapper.updateNotice", notice);
	}

	public int deleteNotice(SqlSession session, int noticeNo) {
		return session.delete("noticeMapper.deleteNotice", noticeNo);
	}

	public HashMap<Integer, Notice> selectSearchTitle(SqlSession session, String noticeTitle) {
		Map<Integer, Notice> list = session.selectMap("noticeMapper.selectSearchTitle", noticeTitle, "noticeNo");
		
		return (HashMap<Integer, Notice>)list;
	}

	public HashMap<Integer, Notice> selectSearchWriter(SqlSession session, String noticeWriter) {
		Map<Integer, Notice> list = session.selectMap("noticeMapper.selectSearchWriter", noticeWriter, "noticeNo");		
		
		return (HashMap<Integer, Notice>)list;
	}

	public HashMap<Integer, Notice> selectSearchDate(SqlSession session, SearchDate date) {
		Map<Integer, Notice> list = session.selectMap("noticeMapper.selectSearchDate", date, "noticeNo");
		return (HashMap<Integer, Notice>)list;
	}

	public ArrayList<Notice> selectTop5Write(SqlSession session) {
		List<Notice> list = session.selectList("noticeMapper.selectTop5Write"); 		
		return (ArrayList<Notice>)list;
	}
}









