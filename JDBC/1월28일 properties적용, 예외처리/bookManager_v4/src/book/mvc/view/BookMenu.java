package book.mvc.view;


import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import book.mvc.controller.BookController;
import book.mvc.model.vo.Book;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	BookController bc = new BookController();
	public void displayMenu() {
		while(true) {
			System.out.print("*** 도서 관리 프로그램 ***\r\n" + 
					"\r\n" + 
					"	1. 도서 추가	\n" + 
					"	2. 도서 정보 수정	\n" + 
					"	3. 도서 삭제	\n" + 
					"	4. 도서 아이디로 조회 \n" + 
					"	5. 도서 제목으로 조회 \n" + 
					"	6. 도서 목록 전체 조회 \n" + 
					"	9. 끝내기\r\n" + 
					"	번호 선택 : ");
			switch(sc.nextInt()) {
			case 1: bc.insertBook(inputBook());break;
			case 2: bc.updateBook(inputBook(new Book()));break;
			case 3: bc.deleteBook(inputBookId());break;
			case 4: displayBook(bc.searchBook(inputBookId()));break;
			case 5: displayBooks(bc.searchBookTitle(inputBookTitle()));break;
			case 6: displayBooks(bc.selectAll());break;
			case 9: System.out.print("프로그램을 종료하시겠습니까? [y:종료,n:취소] : ");
					if(sc.next().toUpperCase().charAt(0)=='Y'){
						return;
					}else
						break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public Book inputBook() {
		Book b = new Book();
		System.out.print("책제목 입력 : ");
		b.setTitle(sc.next());
		System.out.print("저자명 입력 : ");
		b.setAuthor(sc.next());
		System.out.print("출판사 입력 : ");
		b.setPublisher(sc.next());
		System.out.print("출판날짜 입력[yyyy-MM-dd] : ");
		b.setPublishDate(Date.valueOf(sc.next()));
		System.out.print("가격 입력 : ");
		b.setPrice(sc.nextInt());
		return b;
	}
	public Book inputBook(Book b) {
		System.out.print("책 제목 입력 : ");
		b.setTitle(sc.next());
		System.out.print("변경할 가격 입력 : ");
		b.setPrice(sc.nextInt());
		return b;
	}
	public int inputBookId() {
		System.out.print("책 ID 입력 : ");
		return sc.nextInt();
	}
	public String inputBookTitle() {
		System.out.print("책 제목 입력 : ");
		return sc.next();
	}
	public void displayBooks(HashMap<Integer, Book> bookMap) {
		System.out.println("총 "+bookMap.size()+" 권의 책이 있습니다.");
		Set<Integer> keys = bookMap.keySet();
		Iterator<Integer> keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			System.out.println(bookMap.get(keyIter.next()));
		}
	}
	public void displayBook(Book b) {
		System.out.println(b.toString());
	}
	
	public void displayError(String message) {
		System.out.println("\n프로그램 작동에 문제 발생");
		System.out.println("시스템 관리자에게 문의하여 주십시오.");
		System.out.println("점검사항 : " + message);
	}
}
