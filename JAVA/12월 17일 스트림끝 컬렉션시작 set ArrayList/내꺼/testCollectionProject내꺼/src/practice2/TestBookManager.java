package practice2;

import java.util.Scanner;

public class TestBookManager {
	private static Scanner sc = new Scanner(System.in);
	public static void menu() {
		BookManager bm = new BookManager();
		do {
			int no;
			System.out.print("*** 도서 관리 프로그램 ***\r\n" + 
					"\r\n" + 
					"	1. 새 도서 추가	//addBook(inputBook() 이 리턴한 객체) 실행\r\n" + 
					"	2. 도서정보 정렬후 출력 //sortedBookList() 실행 \r\n" + 
					"			=> Book[] 리턴받아 printBookList(Book[]) 실행\r\n" + 
					"	3. 도서 삭제	//deleteBook(삭제할 인덱스) 실행\r\n" + 
					"	4. 도서 검색출력	//searchBook(검색할 도서명) 실행 \r\n" + 
					"			=> index 리턴받아 printBook(index) 실행\r\n" + 
					"	5. 전체 출력	//displayAll() 실행\r\n" + 
					"	6. 끝내기 \n 메뉴 선택 : ");
			no = sc.nextInt();
			switch(no) {
			case 1: 
			}
			
		}while(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
