package common;
import java.sql.*;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "student");
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
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
}
