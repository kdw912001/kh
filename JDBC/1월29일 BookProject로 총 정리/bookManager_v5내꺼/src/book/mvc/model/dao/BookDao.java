package book.mvc.model.dao;

import static common.JDBCTemp.*;

import java.io.FileReader;
import java.sql.*;
import java.util.*;

import book.exception.BookException;
import book.mvc.model.vo.Book;

public class BookDao {
	private Properties prop = new Properties();
	
	public BookDao() throws BookException {
		try {			
			prop.load(new FileReader("properties/query.properties"));
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		}
	}
	
	public int insertBook(Connection conn, Book b) throws BookException{
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insert");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getBookId());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setDate(5, b.getPublishDate());
			pstmt.setInt(6, b.getPrice());
			result = pstmt.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new BookException("새 도서정보 등록 실패!");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateBook(Connection conn, Book b) throws BookException{
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("update");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getPrice());
			pstmt.setInt(2, b.getBookId());
			result = pstmt.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new BookException("가격 수정 실패");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteBook(Connection conn, int bookId) throws BookException{
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("delete");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			result = pstmt.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new BookException("도서 정보 삭제 실패!");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Book> selectList(Connection conn) throws BookException{
		ArrayList<Book> bookList = new ArrayList<>();
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
				rollback(conn);
				throw new BookException("도서 정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(rset);
			close(stmt);
		}
		return bookList;
	}
	
	public HashMap<Integer, Book> selectMap(Connection conn) throws BookException{
		HashMap<Integer, Book> bookMap = new HashMap<>();		
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
				rollback(conn);
				throw new BookException("도서 정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(rset);
			close(stmt);
		}
		return bookMap;
	}
	
	public ArrayList<Book> selectTitleList(Connection conn, String title) throws BookException{
		ArrayList<Book> bookList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTitle");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
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
				rollback(conn);
				throw new BookException(title+ " 제목의 도서정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return bookList;
	}
	
	public HashMap<Integer, Book> selectTitleMap(Connection conn, String title) throws BookException{
		HashMap<Integer, Book> bookMap = new HashMap<>();		 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTitle");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
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
				rollback(conn);
				throw new BookException(title + " 제목의 도서정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return bookMap;
	}
	
	public Book selectBook(Connection conn, int bookId) throws BookException{
		Book b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
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
			if(b == null) {
				rollback(conn);
				throw new BookException("아이디가 "+ bookId + " 인 도서정보가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}

	
}
