package common;

import java.sql.*;

public class JDBCTemp {
	public static Connection getConnection(){
		Connection con = null;
				
		return con;
	}
	
	public static void close(Connection con){}
	
	public static void close(Statement stmt){}
	
	public static void close(ResultSet rset){}
	
	public static void commit(Connection con){}
	
	public static void rollback(Connection con){}
}
