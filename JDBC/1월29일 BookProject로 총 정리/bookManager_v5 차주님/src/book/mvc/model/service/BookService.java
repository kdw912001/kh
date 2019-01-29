package book.mvc.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import book.exception.BookException;
import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;

public class BookService {
	private BookDao bdao;	
	
	public BookService() throws BookException {
		bdao = new BookDao();
	}
	
	public int insert(Book book) 
			throws BookException {
		Connection conn = getConnection();
		int result = bdao.insertBook(conn, book);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}
	
	public int update(Book book) 
			throws BookException {
		Connection conn = getConnection();
		int result = bdao.updateBook(conn, book);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}
	
	public int delete(int bookId) 
			throws BookException  {
		Connection conn = getConnection();
		int result = bdao.deleteBook(conn, bookId);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}
	
	public ArrayList<Book> selectList() 
			throws BookException  {
		Connection conn = getConnection();
		ArrayList<Book> bookList = bdao.selectList(conn);
		close(conn);
		return bookList;
	}
	
	public HashMap<Integer, Book> selectMap() 
			throws BookException  {
		Connection conn = getConnection();
		HashMap<Integer, Book> bookMap = bdao.selectMap(conn);
		close(conn);
		return bookMap;
	}
	
	public ArrayList<Book> selectTitleList(String title) 
			throws BookException  {
		Connection conn = getConnection();
		ArrayList<Book> bookList = bdao.selectTitleList(conn, title);
		close(conn);
		return bookList;
	}
	
	public HashMap<Integer, Book> selectTitleMap(String title) 
			throws BookException  {
		Connection conn = getConnection();
		HashMap<Integer, Book> bookMap = bdao.selectTitleMap(conn, title);
		close(conn);
		return bookMap;
	}
	
	public Book selectBook(int bookId) 
			throws BookException  {
		Connection conn = getConnection();
		Book book = bdao.selectBook(conn, bookId);
		close(conn);
		return book;
	}
}









