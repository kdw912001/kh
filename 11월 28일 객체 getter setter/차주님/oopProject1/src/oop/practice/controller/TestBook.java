package oop.practice.controller;

import oop.practice.model.Book;

public class TestBook {

	public static void main(String[] args) {
		/*1. Book 클래스에 대한 객체를 디폴트 생성자를 사용해서 생성함
		2. 매개변수 있는 생성자를 사용해서 두번째 객체 생성함
		3. 2개의 객체가 가진 정보를 화면출력함
		<출력예>
		null	0	0.0	null
		뇌를 자극하는 JAVA	20000	0.2	김윤영*/

		Book b1 = new Book();
		Book b2 = new Book("뇌를 자극하는 JAVA", 20000, 0.2, "김윤영");
		
		b1.bookInfomation();
		b2.bookInfomation();

		/*1. 첫번째 객체가 가진 값을 setter 를 사용해서 수정
		2. 출력확인함
		<출력예>
		null	0	0.0	null
		뇌를 자극하는 JAVA	20000	0.2	김윤영

		수정된 결과확인
		자바의 정석     35000  0.1   윤상섭*/
		b1.setTitle("자바의 정석");
		b1.setPrice(35000);
		b1.setDiscountRate(0.1);
		b1.setAuthor("윤상섭");
		
		System.out.println("\n수정된 결과 확인");
		b1.bookInfomation();
		
		/*1. 두 객체 각각 할인율을 적용한 책 가격을 계산해서 출력함
		할인된 가격 = 가격 - (가격 * 할인율);

		<출력결과>
		도서명 : 자바의 정석
		할인된 가격 : 31500 원
		도서명 : 뇌를 자극하는 자바
		할인된 가격 : 16000 원*/
		int discountPrice1 = b1.getPrice() - (int)(b1.getPrice() * b1.getDiscountRate()); 
		int discountPrice2 = b2.getPrice() - (int)(b2.getPrice() * b2.getDiscountRate());
		
		System.out.println("\n도서명 : " + b1.getTitle());
		System.out.println("할인된 가격 : " + discountPrice1 + "원");
		System.out.println("도서명 : " + b2.getTitle());
		System.out.println("할인된 가격 : " + discountPrice2 + "원");
	}

}
