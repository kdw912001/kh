package common;

import java.sql.*;
import java.util.*;
import java.io.*;

public class JDBCTemp {
	
	private JDBCTemp(){}
	
	public static Connection getConnection()
	{
		Connection conn = null;
		Properties prop = new Properties();
		
		String driver = null;
		String url = null;
		String user = null;
		String passwd = null;
		
		try {
			prop.load(new FileReader("properties/dbserver.properties"));
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			passwd = prop.getProperty("pwd");
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, passwd);
			
		}catch(ClassNotFoundException e){
			System.out.println("driver 클래스 찾기 실패...");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("connect 실패...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("dbserver.properties 파일 로딩 실패...");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection con)
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt)
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs)
	{
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con)
	{
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con)
	{
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
