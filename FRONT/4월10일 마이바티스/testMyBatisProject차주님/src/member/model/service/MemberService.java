package member.model.service;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	private MemberDao mdao = new MemberDao();
		
	public MemberService() {}
	
	private SqlSession getSession() {
		SqlSession mybatis = null;
		try {
			/* 마이바티스 config 설정파일의 내용을 읽어서 
			 * db 연결하고 PreparedStatement 객체 생성과 
			 * 동일한 의미를 가진 코드임. */
			/*String resource = "mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			mybatis = sqlSessionFactory.openSession(false);*/
			mybatis = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mybatis;
	}

	public Member selectLogin(Member member) {
		SqlSession session = getSession();
		Member loginUser = 
				mdao.selectLogin(session, member);
		session.close();
		return loginUser;
	}

	public int selectCheckId(String userId) {
		
		int result = mdao.selectCheckId(conn, userId);
		close(conn);
		return result;
	}

	public int insertMember(Member member) {
		
		int result = mdao.insertMember(conn, member);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Member selectMember(String userId) {
		
		Member member = 
				mdao.selectMember(conn, userId);
		close(conn);
		return member;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = mdao.updateMember(conn, member);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = mdao.deleteMember(conn, userId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<Member> selectList() {
		Connection conn = getConnection();
		ArrayList<Member> list = mdao.selectList(conn);
		close(conn);
		return list;
	}
}









