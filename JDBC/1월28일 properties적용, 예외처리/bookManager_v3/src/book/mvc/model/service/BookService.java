package book.mvc.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;

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

	public HashMap<Integer, Book> selectBookTitle(String bookTitle) {
		Connection conn = getConnection();
		HashMap<Integer, Book> bookMap = bdao.selectBookTitle(bookTitle, conn);
		close(conn);
		return bookMap;
	}

	public HashMap<Integer, Book> selectAllBooks() {
		Connection conn = getConnection();
		HashMap<Integer, Book> bookMap = bdao.selectAllBooks(conn);
		close(conn);
		return bookMap;
	}
}
