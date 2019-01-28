package book.mvc.model.dao;

import static common.JDBCTemp.*;

import java.io.*;
import java.sql.*;
import java.util.*;

import book.exception.BookException;
import book.mvc.model.vo.Book;

public class BookDao {
	Properties prop = new Properties();
	public BookDao() {
		try {
			prop.load(new FileReader("properties/query.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertBook(Book b, Connection conn) throws BookException {
		int result = 0;
		PreparedStatement pstmt = null;
		//Statement stmt = null;
		
		//String query = "insert into book values (seq_bid.nextval, ?, ?, ?, ?, ?)";
		String query = prop.getProperty("insert");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPublisher());
			pstmt.setDate(4, b.getPublishDate());
			pstmt.setInt(5, b.getPrice());
			result = pstmt.executeUpdate();	
			if(result <= 0) {
				rollback(conn);
				throw new BookException("새 도서정보 등록 실패!");
			}
		} catch (Exception e) {
			rollback(conn);
			throw new BookException(e.getMessage());
		} finally {
			close(pstmt);			
		}
		
		return result;
	}

	public int updateBook(Book b, Connection conn) throws BookException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		//String query = "update book set price = ? where title = ?";
		String query = prop.getProperty("updateb");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getPrice());
			pstmt.setString(2, b.getTitle());
			result = pstmt.executeUpdate();		
			if(result <= 0) {
				rollback(conn);
				throw new BookException(b.getTitle() + " 도서의 가격 수정 실패!");
			}
		} catch (Exception e) {
			rollback(conn);
			throw new BookException(e.getMessage());
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBook(int bookId, Connection conn) throws BookException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		//String query = "delete from book where book_id = ?";
		String query = prop.getProperty("deleteb");
		try {			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			result = pstmt.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new BookException(bookId + " 도서 정보 삭제 실패");
			}
		} catch (Exception e) {
			rollback(conn);
			throw new BookException(e.getMessage());
		} finally {
			close(pstmt);
		}		
		return result;
	}

	public Book selectBook(int bookId, Connection conn) throws BookException {
		Book b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//String query = "select * from book where book_id = ?";
		String query = prop.getProperty("selectb");
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
			if(b == null)
				throw new BookException("조회된 정보가 존재하지 않습니다.");
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}

	public HashMap<Integer, Book> selectBookTitle(String bookTitle, Connection conn) throws BookException {
		HashMap<Integer, Book> bookMap = new HashMap<>();	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//String query = "select * from book where title like '%'||?||'%'";
		//String query = "select * from book where title like ?";
		String query = prop.getProperty("selectbt");
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
				bookMap.put(b.getBookId(), b);		
			}
			if(bookMap.size() == 0)
				throw new BookException(bookTitle + " 제목을 가진 도서가 존재하지 않습니다.");
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);			
		}		
		return bookMap;
	}

	public HashMap<Integer, Book> selectAllBooks(Connection conn) throws BookException {
		HashMap<Integer, Book> bookMap = new HashMap<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//String query = "select * from book";
		String query = prop.getProperty("selectall");
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
				bookMap.put(b.getBookId(), b);
			}
			if(bookMap.size() == 0)
				throw new BookException("도서 정보가 존재하지 않습니다.");
		} catch (Exception e) {
			throw new BookException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return bookMap;
	}
}
