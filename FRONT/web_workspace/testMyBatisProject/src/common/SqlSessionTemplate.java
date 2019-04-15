package common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSession() {
		SqlSession mybatis = null;
		try {
			mybatis = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis/mybatis-config.xml")).openSession(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mybatis;
	}
}
