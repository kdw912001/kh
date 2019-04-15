package common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSession() {
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
