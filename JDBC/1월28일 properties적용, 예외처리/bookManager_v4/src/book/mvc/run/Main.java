package book.mvc.run;

import book.mvc.view.BookMenu;

public class Main {
	public static void main(String[] args) {
		new BookMenu().displayMenu();
		System.out.println("프로그램 종료!");
	}
}
