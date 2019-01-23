package book.mvc.view;

import java.util.Scanner;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		while(true) {
			System.out.print("*** 도서 관리 프로그램 ***\r\n" + 
					"\r\n" + 
					"	1. 도서 추가	=> BookController 의 insertBook(Book객체) 호출\r\n" + 
					"	2. 도서 정보 수정	=> BookController 의 updateBook(Book객체) 호출\r\n" + 
					"	3. 도서 삭제	=> BookController 의 deleteBook(책아이디) 호출\r\n" + 
					"	4. 도서 아이디로 조회 => BookController 의 searchBook(아이디) 호출\r\n" + 
					"	5. 도서 제목으로 조회 => BookController 의 searchBookTitle(제목) 호출\r\n" + 
					"	6. 도서 목록 전체 조회 => BookController 의 selectAll() 호출\r\n" + 
					"	9. 끝내기\r\n" + 
					"	번호 선택 : ");
			switch(sc.nextInt()) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 9: break;
			default: break;
			}
		}
	}
	
	public Book inputBook() {}
	public Book inputBook(Book b) {}
	public int inputBookId() {}
	public String inputBookTitle() {}
	public void displayBooks(List<Book> list) {}
	public void displayBook(Book b) {}
	public void displayError(String message) {}
}
