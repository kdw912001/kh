package test.objarray;

import obj.array.sample.Book;

public class TestObjectArray {

	public static void testBookArray() {
		//객체 배열 선언
		Book[] bar;
		//배열공간 할당
		bar = new Book[3];
		//Book 클래스 객체의 주소보관용
		//레퍼런스변수방 3개를 배열로 할당함
		
		System.out.println("length : " 
				+ bar.length);
		
		for(int i = 0; i < bar.length; i++) {
			System.out.println(bar[i]);
		}
		
		//준비된 각 레퍼런스변수방에 주소 기록
		//객체 생성을 해서 주소 발생시킴
		bar[0] = new Book("자바정복", "홍길동", 28000, 0.1);
		bar[1] = new Book("Oracle 11g", "김철수", 35000, 0.05);
		bar[2] = new Book("JDBC", "이영희", 20000, 0.15);
		
		for(int i = 0; i < bar.length; i++) {
			System.out.println(i + " : " 
		                + bar[i].hashCode());
			System.out.println(bar[i].bookInfo());
		}
	}
	
	public static void testBookArray2() {
		//객체 배열의 초기화
		//초기값 : 객체 생성후 주소
		Book[] bar = new Book[]{
				new Book("자바정복", "홍길동", 28000, 0.1),
				new Book("Oracle 11g", "김철수", 35000, 0.05),
				new Book("JDBC", "이영희", 20000, 0.15)};
		
		int sum = 0;
		for(int i = 0; i < bar.length; i++) {
			sum += bar[i].getPrice();
			System.out.println(bar[i].bookInfo());
		}
		
		System.out.println("총합 : " + sum);
	}
	
	public static void testBookArray3() {
		//객체 배열의 초기화
		//초기값 : 객체 생성후 주소
		Book[] bar = new Book[]{
				new Book("자바정복", "홍길동", 28000, 0.1),
				new Book("Oracle 11g", "김철수", 35000, 0.05),
				new Book("JDBC", "이영희", 20000, 0.15)};
		
		//각 객체의 도서가격에 할인율 적용함
		//할인율이 적용된 도서 가격을 출력함
		
		//도서정보 출력하고,
		//할인율 적용 가격 : 000000 원
		for(int i = 0; i < bar.length; i++) {
			System.out.println(bar[i].bookInfo());
			int discountPrice = bar[i].getPrice() 
				- (int)(bar[i].getPrice() 
						* bar[i].getDiscountRate());
			System.out.println("할인율 적용 가격 : "
					+ discountPrice);
		}
	}
	
	public static void main(String[] args) {
		// 객체배열 테스트
		//testBookArray();
		//testBookArray2();
		testBookArray3();
	}

}
