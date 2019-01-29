package product.model.dao;

import java.sql.*;
import java.util.*;
import java.io.*;

import product.model.vo.Product;
import static common.JDBCTemp.*;

public class ProductDao {
	private Properties prop;
	
	public ProductDao(){
		prop = new Properties();
		
		try {
			prop.load(new FileReader("properties/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> selectAll()
	{
		ArrayList<Product> alist = null;
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = prop.getProperty("selectall");
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			alist = new ArrayList<Product>();
			
			while(rs.next())
			{
				Product p = new Product();
				
				p.setProductID(rs.getString("product_id"));
				p.setpName(rs.getString("p_name"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("description"));
				
				alist.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(stmt);
			close(conn);
		}
		
		return alist;
	}
	
	public Product selectID(String productID)
	{
		Product p = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = prop.getProperty("selectpid");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productID);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				p = new Product();
				
				p.setProductID(rs.getString("product_id"));
				p.setpName(rs.getString("p_name"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("description"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		return p;
	}
	
	public ArrayList<Product> selectName(String pName)
	{
		ArrayList<Product> alist = null;		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = prop.getProperty("selectpname");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pName);
			
			rs = pstmt.executeQuery();
			
			alist = new ArrayList<Product>();
			
			if(rs.next())
			{
				Product p = new Product();
				
				p.setProductID(rs.getString("product_id"));
				p.setpName(rs.getString("p_name"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("description"));
			
				alist.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		return alist;
	}
	
	public int insertRow(Product p)
	{
		int result = 0;		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;		
		
		String query = prop.getProperty("insert");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getProductID());
			pstmt.setString(2, p.getpName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	
	public int updateRow(String productID, int price)
	{
		int result = 0;		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;		
		
		String query = prop.getProperty("update");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, price);
			pstmt.setString(2, productID);
						
			result = pstmt.executeUpdate();
			
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	
	public int deleteRow(String productID)
	{
		int result = 0;		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;		
		
		String query = prop.getProperty("delete");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productID);
						
			result = pstmt.executeUpdate();
			
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
}
