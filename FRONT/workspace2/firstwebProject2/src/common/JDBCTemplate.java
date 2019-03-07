package common;

import java.sql.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//SingleTon design Pattern
public class JDBCTemplate {
	/*public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "student");
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}*/
	
	//톰캣(WAS:Web Application Server = 웹컨테이너)이 제공하는 DBCP(DataBase Connection Pool)를
	//이용해서 데이터베이스 연결 처리
	//web/META-INF/context.xml 파일에 설정됨
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			//context.xml에 설정된 <Resource> 엘리먼트의 
			//설정값을 읽어와서, DBCP 에서 Connection을 받음
			Context initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:comp/env/jdbc/oraDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
