package book.mvc.model.dao;

import static common.JDBCTemp.close;
import static common.JDBCTemp.rollback;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import book.exception.BookException;
import book.mvc.model.vo.Book;

public class BookDao {
	private Properties prop = new Properties();
	
	public BookDao() throws BookException {
		try {			
			prop.load(new FileReader(
					"properties/query.properties"));
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
	}
	
	public int insertBook(Connection conn, Book book) 
			throws BookException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insert");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setDate(4, book.getPublishDate());
			pstmt.setInt(5, book.getPrice());
			
			result = pstmt.executeUpdate();
			
			if(result <= 0) {
				rollback(conn);
				throw new BookException("새로운 도서정보 기록 실패!");
			}
			
		} catch (Exception e) {
			rollback(conn);
			throw new BookException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateBook(Connection conn, Book book) 
			throws BookException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("update");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, book.getPrice());
			pstmt.setInt(2, book.getBookId());
			
			result = pstmt.executeUpdate();
			
			if(result <= 0) {
				rollback(conn);
				throw new BookException(book.getBookId() + "번 도서정보 변경 실패!");
			}
			
		} catch (Exception e) {
			rollback(conn);
			throw new BookException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteBook(Connection conn, int bookId)
			throws BookException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("delete");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			result = pstmt.executeUpdate();
			
			if(result <= 0) {
				rollback(conn);
				throw new BookException(bookId + "번 도서정보 삭제 실패!");
			}
		} catch (Exception e) {
			rollback(conn);
			throw new BookException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Book> selectList(Connection conn)
			throws BookException {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Book b = new Book();
				
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublishDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				
				bookList.add(b);
			}
			
			if(bookList.size() == 0) {
				throw new BookException("조회된 도서정보가 없습니다.");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}finally {
			close(rset);
			close(stmt);
		}
		
		return bookList;
	}
	
	public HashMap<Integer, Book> selectMap(Connection conn) 
			throws BookException {
		HashMap<Integer, Book> bookMap = 
				new HashMap<Integer, Book>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Book b = new Book();
				
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublishDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				
				bookMap.put(b.getBookId(), b);
			}
			
			if(bookMap.size() == 0) {
				throw new BookException("조회된 도서정보가 없습니다.");
			}
			
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}finally {
			close(rset);
			close(stmt);
		}		
		
		return bookMap;
	}
	
	public ArrayList<Book> selectTitleList(
			Connection conn, String title) 
					throws BookException {
		ArrayList<Book> bookList = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectTitle");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + title + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book();
				
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublishDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				
				bookList.add(b);
			}
			
			if(bookList.size() == 0) {
				throw new BookException(title + 
						"과 일치하는 도서정보가 없습니다.");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return bookList;
	}
	
	public HashMap<Integer, Book> selectTitleMap(
			Connection conn, String title) 
					throws BookException {
		HashMap<Integer, Book> bookMap = 
				new HashMap<Integer, Book>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectTitle");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + title + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Book b = new Book();
				
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPublishDate(rset.getDate("publish_date"));
				b.setPrice(rset.getInt("price"));
				
				bookMap.put(b.getBookId(), b);
			}
			
			if(bookMap.size() == 0) {
				throw new BookException(title + 
						"과 일치하는 도서정보가 없습니다.");
			}
			
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}		
		
		return bookMap;
	}
	
	public Book selectBook(Connection conn, int bookId) 
			throws BookException {
		Book book = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				book = new Book();
				
				book.setBookId(rset.getInt("book_id"));
				book.setTitle(rset.getString("title"));
				book.setAuthor(rset.getString("author"));
				book.setPublisher(rset.getString("publisher"));
				book.setPublishDate(rset.getDate("publish_date"));
				book.setPrice(rset.getInt("price"));
				
			}
			
			if(book == null) {
				throw new BookException(bookId + 
						"번 도서정보가 없습니다.");
			}
			
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}finally {
			close(rset);
			close(pstmt);
		}		
		
		return book;
	}
}







