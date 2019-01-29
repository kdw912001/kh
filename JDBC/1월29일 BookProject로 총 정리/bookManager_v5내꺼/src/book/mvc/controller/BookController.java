package book.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;

import book.exception.BookException;
import book.mvc.model.service.BookService;
import book.mvc.model.vo.Book;
import book.view.BookMenu;

public class BookController {
	private BookService bservice;

	// BookService에서 BookException을 넘기기 때문에 레퍼런스만 선언하고
	// 기본생성자에서 BOokException처리
	public BookController() {
		//지역변수에서 BookMenu를 선언하면 stackoverflow발생하므로
		//각 메소드에 선언
		try {
			bservice = new BookService();
		} catch (BookException e) {
			printError(e.getMessage());
		}
	}
	public void printError(String message) {
		System.out.println("\n프로그램 오류 발생!");
		System.out.println("시스템 관리자에게 문의하십시요.");
		System.out.println("오류 메세지 : " + message);
	}

	public void insertBook(Book book) {
		try {
			if(bservice.insertBook(book) > 0)
				System.out.println("새 도서 등록 성공!");
		} catch (BookException e) {
			printError(e.getMessage());
			new BookMenu().displayMenu();
		}
	}

	public void updateBook(Book book) {
		try {
			if(bservice.updateBook(book) > 0)
				System.out.println("도서 정보 변경 성공!");
		} catch (BookException e) {
			printError(e.getMessage());
			new BookMenu().displayMenu();
		}
	}

	public void deleteBook(int bookId) {
		try {
			if(bservice.deleteBook(bookId) > 0)
				System.out.println("도서 정보 삭제 성공!");
		} catch (BookException e) {
			printError(e.getMessage());
			new BookMenu().displayMenu();
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
			new BookMenu().displayMenu();
		}
	}

	public void searchBookList(String title) {
		try {
			ArrayList<Book> bookList = bservice.selectTitleList(title);
			new BookMenu().printList(bookList);
			if(bookList.size() > 0)
				System.out.println("제목으로 조회 성공!");
			
		} catch (BookException e) {
			printError(e.getMessage());
			new BookMenu().displayMenu();
		}
	}

	public void searchBookMap(String title) {
		try {
			HashMap<Integer, Book> bookMap = bservice.selectTitleMap(title);
			new BookMenu().printMap(bookMap);
			if(bookMap.size() > 0)
				System.out.println("제목으로 조회 성공!");
		} catch (BookException e) {
			printError(e.getMessage());
			new BookMenu().displayMenu();
		}
	}

	public void selectAllList() {
		try {
			new BookMenu().printList(bservice.selectList());
			//조회 성공 멘트 없어도 됨.
		} catch (BookException e) {
			printError(e.getMessage());
			new BookMenu().displayMenu();
		}
	}

	public void selectAllMap() {
		try {
			new BookMenu().printMap(bservice.selectMap());
		} catch (BookException e) {
			printError(e.getMessage());
			new BookMenu().displayMenu();
		}
	}

}
