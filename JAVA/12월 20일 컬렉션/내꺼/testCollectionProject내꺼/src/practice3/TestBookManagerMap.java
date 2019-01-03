package practice3;

import java.util.Scanner;

import practice2.Book;
import practice3.BookManagerMap;

public class TestBookManagerMap {
	private static Scanner sc = new Scanner(System.in);
	public static void menu() {
		BookManagerMap bm = new BookManagerMap();
		do {
			int no;
			System.out.print("*** 도서 관리 프로그램 ***\r\n" + 
					"\r\n" + 
					"	1. 새 도서 추가	 실행\r\n" + 
					"	2. 도서정보 정렬후 출력  \r\n" + 
					"			\r\n" + 
					"	3. 도서 삭제	 \r\n" + 
					"	4. 도서 검색출력	  \r\n" + 
					"			\r\n" + 
					"	5. 전체 출력	//displayAll() 실행\r\n" + 
					"	6. 끝내기 \n 메뉴 선택 : ");
			no = sc.nextInt();
			switch(no) {
			case 1: bm.putBook(inputBook()); break;
			case 2: bm.printBokMap(bm.sortedBookMap()); break;
			case 3: bm.removeBook(bm.searchBook(inputBookTitle())); break;
			case 4: bm.printBook(bm.searchBook(inputBookTitle())); break;
			case 5: bm.displayAll(); break;
			case 6: System.out.println("종료하였습니다."); return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}while(true);
	}
	public static Book inputBook() {
		Book b = new Book();
		System.out.print("도서번호 입력 : ");
		b.setbNo(sc.next());
		System.out.print("도서분류코드(1.인문/2.자연과학/3.의료/4.기타)");
		b.setCategory(sc.nextInt());
		System.out.print("책제목 입력 : ");
		b.setTitle(sc.next());
		System.out.print("저자 입력 : ");
		b.setAuthor(sc.next());
		return b;
	}
	public static String inputBookTitle() {
		System.out.print("삭제, 또는 검색을 위한 도서 타이틀 입력 : ");
		return sc.next();
	}
	public static void main(String[] args) {
		menu();
	}
}