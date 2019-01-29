package book.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;

import book.exception.BookException;
import book.mvc.model.service.BookService;
import book.mvc.model.vo.Book;
import book.mvc.view.BookMenu;

public class BookController {
	private BookService bservice;

	public BookController() {		
		try {
			bservice = new BookService();
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}

	private void printError(String message) {
		System.out.println("\n프로그램 오류 발생!");
		System.out.println("시스템 관리자에게 문의하십시요.");
		System.out.println("오류 메세지 : " + message);
	}

	public void insertBook(Book book) {
		
		try {
			if(bservice.insert(book) > 0)
				System.out.println("새 도서 등록 성공!");
				
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}

	public void updateBook(Book book) {
		
		try {
			if(bservice.update(book) > 0)
				System.out.println("도서 정보 변경 성공!");
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}

	public void deleteBook(int bookId) {
		
		try {
			if(bservice.delete(bookId) > 0)
				System.out.println("도서 정보 삭제 성공!");
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}

	public void searchBook(int bookId) {
		
		try {
			Book book = bservice.selectBook(bookId);
			new BookMenu().printBook(book);
			if(book != null)
				System.out.println("도서 정보 조회 성공!");
			
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}

	public void searchBookList(String title) {
		
		try {
			ArrayList<Book> bookList = 
					bservice.selectTitleList(title);
			new BookMenu().printList(bookList);
			
			if(bookList.size() > 0)
				System.out.println("\n제목으로 조회 성공!");
			
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}

	public void searchBookMap(String title) {
		
		try {
			HashMap<Integer, Book> bookMap = 
					bservice.selectTitleMap(title);
			new BookMenu().printMap(bookMap);
			
			if(bookMap.size() > 0)
				System.out.println("\n제목으로 조회 성공!");
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}

	public void selectAllList() {
		
		try {
			new BookMenu().printList(bservice.selectList());
			
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}

	public void selectAllMap() {		
		try {
			new BookMenu().printMap(bservice.selectMap());
			
		} catch (BookException e) {
			printError(e.getMessage());			
		}
	}
}
