package com.practice1.controller;

import com.practice1.model.vo.Book;

public class TestSilsub1 {

	public static void main(String[] args) {
		// 상속과 오버라이딩 테스트
		// 실습문제 1
		Book b1 = new Book("자바정보","홍길동",28000);
		Book b2 = new Book("오라클11g","김영희", 35000);
		Book b3 = new Book("자바정보","홍길동",28000);
		
		System.out.println("b1 : "+b1/*.toString()*/);
		//출력 시에 레퍼런스명.toString()에서 .toString()생략 해도 자동으로 .toString() 붙음
		System.out.println("b2 : "+b2/*.toString()*/);
		System.out.println("b1.equals(b2) : " + b1.equals(b2));	//단순 필드값 비교 false
		System.out.println("b1.equals(b3) : " + b1.equals(b3));	//true
		
		System.out.println("b1==b3 : "+(b1 == b3)); //괄호 꼭 해야함
																	//서로 주소가 달라서 false
		
		Book b4 = (Book)b1.clone(); //부모는 후손껄 다 받을 수 있지만 
		System.out.println("b4 : " + b4);
		System.out.println("b1 : " + b1.hashCode()); 
		System.out.println("b4 : " + b4.hashCode()); 
		//b1,b4는 객체가 다르지만 clone을 써서 같은 값을 가짐. 
	}
}
