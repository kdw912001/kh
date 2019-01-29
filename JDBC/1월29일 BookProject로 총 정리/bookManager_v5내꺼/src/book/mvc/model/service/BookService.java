package book.mvc.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import book.exception.BookException;
import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import static common.JDBCTemp.*;

public class BookService {
	private BookDao bdao;
	//bdao에서 BookException을 throws하기 때문에 레퍼런스 선언만 하고 
	//기본 생성자에서 BookExcpeion을 넘겨버림
	
	public BookService() throws BookException {
		bdao = new BookDao();
	}
	
	public int insertBook(Book book) throws BookException {
		Connection conn = getConnection();
		int result = bdao.insertBook(conn, book);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateBook(Book book) throws BookException {
		Connection conn = getConnection();
		int result = bdao.updateBook(conn, book);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteBook(int bookId) throws BookException {
		Connection conn = getConnection();
		int result = bdao.deleteBook(conn, bookId);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Book> selectList() throws BookException {
		Connection conn= getConnection();
		ArrayList<Book> bookList = bdao.selectList(conn);
		close(conn);
		return bookList;
	}
	
	public HashMap<Integer, Book> selectMap() throws BookException {
		Connection conn = getConnection();
		HashMap<Integer, Book> bookMap = bdao.selectMap(conn);
		close(conn);
		return bookMap;
	}
	
	public ArrayList<Book> selectTitleList(String title) throws BookException {
		Connection conn = getConnection();
		ArrayList<Book> bookList = bdao.selectTitleList(conn, title);
		close(conn);
		return bookList;
	}
	
	public HashMap<Integer, Book> selectTitleMap(String title) throws BookException {
		Connection conn = getConnection();
		HashMap<Integer, Book> bookMap = bdao.selectTitleMap(conn, title);
		close(conn);
		return bookMap;
	}
	
	public Book selectBook(int bookId) throws BookException {
		Connection conn = getConnection();
		Book book = bdao.selectBook(conn, bookId);
		close(conn);
		return book;
	}
	
}
