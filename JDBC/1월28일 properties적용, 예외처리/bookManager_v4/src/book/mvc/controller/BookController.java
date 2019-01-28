package book.mvc.controller;

import java.util.HashMap;
import java.util.List;

import book.exception.BookException;
import book.mvc.model.service.BookService;
import book.mvc.model.vo.Book;
import book.mvc.view.BookMenu;

public class BookController {
	
	//BookDao bdao = new BookDao();
	private BookService bservice = new BookService();
	public BookController() {}
	
	public void insertBook(Book b) {
		 try {
			int result = bservice.insertBook(b);
			if(result > 0 )
				System.out.println("\n새 도서정보 등록 성공!");
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
			new BookMenu().displayMenu();			
		}			
		return;		
	}
	public void updateBook(Book b) {		
		try {
			int result = bservice.updateBook(b);
			if(result > 0) {
				System.out.println("\n 도서정보 수정 완료!");
			}
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
			new BookMenu().displayMenu();
		}		
		return;		
	}
	public void deleteBook(int bookId) {		
		try {
			int result = bservice.deleteBook(bookId);
			if(result > 0) {
				System.out.println("\n 도서정보 삭제 완료!");
			}
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
			new BookMenu().displayMenu();
		}		
		return;
		
	}
	public Book searchBook(int bookId) {
		Book b = null;
		try {
			b = bservice.selectBook(bookId);
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
			new BookMenu().displayMenu();
		}		
		return b;
	}
	public HashMap<Integer, Book> searchBookTitle(String bookTitle) {
		HashMap<Integer, Book> bookMap = null;
		try {
			bookMap = bservice.selectBookTitle(bookTitle);
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
			new BookMenu().displayMenu();
		}		
		return bookMap;
	}
	public HashMap<Integer, Book> selectAll() {
		HashMap<Integer, Book> bookMap = null;
		try {
			bookMap = bservice.selectAllBooks();
		} catch (BookException e) {
			new BookMenu().displayError(e.getMessage());
			new BookMenu().displayMenu();
		}
		return bookMap;
	}
}
