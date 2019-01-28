package book.mvc.controller;

import java.util.HashMap;
import java.util.List;

import book.mvc.model.service.BookService;
import book.mvc.model.vo.Book;
import book.mvc.view.BookMenu;

public class BookController {
	
	//BookDao bdao = new BookDao();
	private BookService bservice = new BookService();
	public BookController() {}
	
	public void insertBook(Book b) {
		int result = bservice.insertBook(b);
		if(result > 0 ) {
			System.out.println("\n새 도서정보 등록 성공!");
		}else {
			System.out.println("\n새 도서정보 등록 실패!\n확인하고 다시 시도 하십시오.");
			
		}
		System.out.println("result chect : "+result);
		return;
		
	}
	public void updateBook(Book b) {
		int result = bservice.updateBook(b);
		if(result > 0) {
			System.out.println("\n 도서정보 수정 완료!");
		}else {
			System.out.println("\n도서정보 수정 실패!");
			System.out.println("확인하고 다시 시도 하십시오.");
		}
		return;
		
	}
	public void deleteBook(int bookId) {
		int result = bservice.deleteBook(bookId);
		if(result > 0) {
			System.out.println("\n 도서정보 삭제 완료!");
		}else {
			System.out.println("\n도서정보 삭제 실패!");
			System.out.println("확인하고 다시 시도하십시오.");
		}
		return;
		
	}
	public Book searchBook(int bookId) {
		Book b = bservice.selectBook(bookId);
		if(b == null) {
			System.out.println(bookId + " 도서정보가 존재하지 않습니다.");
			new BookMenu().displayMenu();
		}
		return b;
	}
	public HashMap<Integer, Book> searchBookTitle(String bookTitle) {
		HashMap<Integer, Book> bookMap = bservice.selectBookTitle(bookTitle);
		if(bookMap == null) {
			System.out.println(bookTitle + " 의 책이 존재하지 않습니다.");
			new BookMenu().displayMenu();
		}
		return bookMap;
	}
	public HashMap<Integer, Book> selectAll() {
		HashMap<Integer, Book> bookMap = bservice.selectAllBooks();
		if(bookMap.size() == 0 || bookMap == null) {
			System.out.println("도서 정보가 없습니다.");
			new BookMenu().displayMenu();
		}
		
		return bookMap;
	}
	
}
