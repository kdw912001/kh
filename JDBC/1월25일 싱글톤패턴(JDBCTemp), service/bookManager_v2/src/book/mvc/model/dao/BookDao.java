package book.mvc.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import book.mvc.model.vo.Book;
import static common.JDBCTemp.*;

public class BookDao {
	public BookDao() {}

	public int insertBook(Book b, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		//Statement stmt = null;
		
		String query = "insert into book values (seq_bid.nextval, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPublisher());
			pstmt.setDate(4, b.getPublishDate());
			pstmt.setInt(5, b.getPrice());
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);			
		}
		
		return result;
	}

	public int updateBook(Book b, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update book set price = ? where title = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getPrice());
			pstmt.setString(2, b.getTitle());
			result = pstmt.executeUpdate();				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBook(int bookId, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from book where book_id = ?";
		
		try {			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		return result;
	}

	public Book selectBook(int bookId, Connection conn) {
		Book b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from book where book_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Book();
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublishDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}

	public ArrayList<Book> selectBookTitle(String bookTitle, Connection conn) {
		ArrayList<Book> list = new ArrayList<>();	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//String query = "select * from book where title like '%'||?||'%'";
		String query = "select * from book where title like ?";
		try {			
			pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, bookTitle);
			pstmt.setString(1, "%"+bookTitle+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book b = new Book();
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublishDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				list.add(b);
				System.out.println(list.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);			
		}		
		return list;
	}

	public List<Book> selectAllBooks(Connection conn) {
		List<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from book";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book b = new Book();
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublishDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
}
