package faq.model.dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import faq.model.vo.Faq;

public class FaqDao {

	public ArrayList<Faq> selectList(Connection conn, int currentPage, int limit) {
		ArrayList<Faq> list = new ArrayList<Faq>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = "select * from (select rownum rnum, faq_no, faq_title, faq_content, faq_date, manager_id, faq_type "
				+ "from (select * from faq order by faq_type) order by faq_type asc) where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Faq faq = new Faq();
				
				faq.setFaqNo(rset.getInt("faq_no"));
				faq.setFaqTitle(rset.getString("faq_title"));
				faq.setFaqContent(rset.getString("faq_content"));
				faq.setFaqDate(rset.getDate("faq_date"));
				faq.setManagerId(rset.getString("manager_id"));
				faq.setFaqType(rset.getString("faq_type"));
				
				list.add(faq);
			}
			System.out.println("list");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int insertFaq(Connection conn, Faq faq) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into faq values((select max(faq_no) + 1 from faq), ?, ?, sysdate, 'adminmk', ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, faq.getFaqTitle());
			pstmt.setString(2, faq.getFaqContent());
			//pstmt.setString(3, faq.getManagerId());
			pstmt.setString(3, faq.getFaqType());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteFaq(Connection conn, int faqNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from faq where faq_no = ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, faqNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateFaq(Connection conn, Faq faq) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update faq set faq_title = ?, faq_content = ?, faq_type = ? where faq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, faq.getFaqTitle());
			pstmt.setString(2, faq.getFaqContent());
			pstmt.setString(3, faq.getFaqType());
			pstmt.setInt(4, faq.getFaqNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Faq> selectTitleList(Connection conn, String title, int currentPage, int limit) {
		ArrayList<Faq> list = new ArrayList<Faq>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String query = "select * from (select rownum rnum, faq_no, faq_title, faq_content, faq_date, manager_id, faq_type "
				+ "from (select * from faq where faq_title like? order by faq_type) order by faq_type asc) where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + title + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Faq faq = new Faq();
				
				faq.setFaqNo(rset.getInt("faq_no"));
				faq.setFaqTitle(rset.getString("faq_title"));
				faq.setFaqContent(rset.getString("faq_content"));
				faq.setFaqDate(rset.getDate("faq_date"));
				faq.setManagerId(rset.getString("manager_id"));
				faq.setFaqType(rset.getString("faq_type"));
				
				list.add(faq);
			}
			System.out.println("list");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from faq";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public Faq selectFaq(Connection conn, int faqNum) {
		Faq faq = null;
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		
		String query = "select * from faq where faq_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, faqNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				faq = new Faq();
				
				faq.setFaqNo(rset.getInt("faq_no"));
				faq.setFaqTitle(rset.getString("faq_title"));
				faq.setFaqContent(rset.getString("faq_content"));
				faq.setFaqDate(rset.getDate("faq_date"));
				faq.setManagerId(rset.getString("manager_id"));
				faq.setFaqType(rset.getString("faq_type"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return faq;
	}


}
