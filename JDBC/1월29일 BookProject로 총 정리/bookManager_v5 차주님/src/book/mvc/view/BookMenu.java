package book.mvc.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import book.mvc.controller.BookController;
import book.mvc.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bcontroll = new BookController();
	
	public BookMenu() {}
	
	public void displayMenu() {
		int no;
		
		do {
			System.out.println("\n***********************");
			System.out.println();
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 가격 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 아이디로 조회");
			System.out.println("5. 도서 제목으로 조회 : 리스트 사용");
			System.out.println("6. 도서 제목으로 조회 : 맵 사용");
			System.out.println("7. 도서 목록 전체 조회 : 리스트 사용");
			System.out.println("8. 도서 목록 전체 조회 : 맵 사용");
			System.out.println("9. 끝내기");
			System.out.print("번호 선택 : ");
			no = sc.nextInt();
			
			switch(no) {
			case 1: 	bcontroll.insertBook(inputBook());
					break;
			case 2:	bcontroll.updateBook(modifyBook());
					break;
			case 3:	bcontroll.deleteBook(inputBookId());
					break;
			case 4:	bcontroll.searchBook(inputBookId());
					break;
			case 5:	bcontroll.searchBookList(inputBookTitle());
					break;
			case 6:	bcontroll.searchBookMap(inputBookTitle());
					break;
			case 7:	bcontroll.selectAllList(); break;
			case 8:	bcontroll.selectAllMap(); break;
			case 9:	System.out.println("정말로 종료하시겠습니까?[y/n]");
					if(sc.next().toUpperCase().charAt(0) == 'Y')
						return;
			default: 	System.out.println("\n번호 잘못 선택.");
			        System.out.println("다시 입력하십시요.");
			}
			
		}while(true);
	}

	private String inputBookTitle() {
		System.out.print("검색할 도서제목 : ");
		sc.nextLine();  //입력 버퍼에 남은 엔터키 제거
		return sc.nextLine();
	}

	private int inputBookId() {
		System.out.print("검색할 도서번호 : ");
		return sc.nextInt();
	}

	private Book modifyBook() {
		Book book = new Book();
		System.out.print("수정 대상 도서번호 : ");
		book.setBookId(sc.nextInt());
		System.out.print("변경할 가격 : ");
		book.setPrice(sc.nextInt());
		return book;
	}

	private Book inputBook() {
		System.out.println("\n새로 등록할 도서정보를 입력하세요.");
		Book book = new Book();
		System.out.print("도서 제목 : ");
		sc.nextLine();
		book.setTitle(sc.nextLine());
		System.out.print("저자이름 : ");
		book.setAuthor(sc.next());
		System.out.print("출판사 : ");
		book.setPublisher(sc.next());
		System.out.print("출판날짜[yyyy-MM-dd] : ");
		book.setPublishDate(java.sql.Date.valueOf(sc.next()));
		System.out.print("가격 : ");
		book.setPrice(sc.nextInt());
		
		return book;
	}

	public void printError(String message) {
		// Controller 에서 넘어온 에러메세지 출력용
		System.out.println("\n프로그램 오류 발생!");
		System.out.println("시스템 관리자에게 문의하십시요.");
		System.out.println("오류 메세지 : " + message);
	}

	public void printBook(Book book) {
		System.out.println("\n조회된 도서 정보는 다음과 같습니다.");
		System.out.println(book);
		
	}
	
	public void printList(ArrayList<Book> bookList) {
		System.out.println("\n조회된 도서의 수 ; " + 
				bookList.size());
		for(Book book : bookList)
			System.out.println(book);
	}
	
	public void printMap(
			HashMap<Integer, Book> bookMap) {
		Iterator<Integer> keyIter = 
				bookMap.keySet().iterator();
		while(keyIter.hasNext()) {
			System.out.println(bookMap.get(keyIter.next()));
		}
	}
}









