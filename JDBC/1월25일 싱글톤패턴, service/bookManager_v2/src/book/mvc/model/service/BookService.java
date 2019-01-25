package book.mvc.model.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import book.mvc.model.dao.*;
import book.mvc.model.vo.Book;

import static common.JDBCTemp.*;

public class BookService {
	private BookDao bdao = new BookDao();

	public int insertBook(Book b) {
		Connection conn = getConnection();
		int result = bdao.insertBook(b, conn);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateBook(Book b) {
		Connection conn = getConnection();
		int result = bdao.updateBook(b, conn);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteBook(int bookId) {
		Connection conn = getConnection();
		int result = bdao.deleteBook(bookId, conn);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Book selectBook(int bookId) {
		Connection conn = getConnection();
		Book b = bdao.selectBook(bookId, conn);
		close(conn);
		return b;
	}

	public ArrayList<Book> selectBookTitle(String bookTitle) {
		Connection conn = getConnection();
		ArrayList<Book> list = bdao.selectBookTitle(bookTitle, conn);
		close(conn);
		return list;
	}

	public List<Book> selectAllBooks() {
		Connection conn = getConnection();
		List<Book> bookList = bdao.selectAllBooks(conn);
		close(conn);
		return bookList;
	}
}
