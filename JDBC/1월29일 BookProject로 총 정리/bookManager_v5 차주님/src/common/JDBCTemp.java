package common;

import java.sql.*;
import book.exception.*;
import java.util.*;
import java.io.*;

public class JDBCTemp {

	public static Connection getConnection() throws BookException {
		Connection conn = null;
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("properties/driver.properties"));

			/*
			 * String driver = prop.getProperty("driver"); String url =
			 * prop.getProperty("url"); String user = prop.getProperty("user"); String pwd =
			 * prop.getProperty("pwd");
			 * 
			 * Class.forName(driver); conn = DriverManager.getConnection(url, user, pwd);
			 */

			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("user"),
					prop.getProperty("pwd"));
			
			conn.setAutoCommit(false);			

		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}

		return conn;
	}

	public static void close(Connection conn) throws BookException {
		try {
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
	}

	public static void close(Statement stmt) throws BookException {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
	}

	public static void close(ResultSet rset) throws BookException {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
	}

	public static void commit(Connection conn) throws BookException {
		try {
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
	}

	public static void rollback(Connection conn) throws BookException {
		try {
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
	}
}
