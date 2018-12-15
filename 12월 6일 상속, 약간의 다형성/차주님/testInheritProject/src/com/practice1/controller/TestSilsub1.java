package com.practice1.controller;

import com.practice1.model.vo.Book;

public class TestSilsub1 {

	public static void main(String[] args) {
		// 상속과 오버라이딩 테스트
		//실습문제 1
		Book b1 = new Book("자바정복", "홍길동", 28000);
		Book b2 = new Book("오라클11g", "김영희", 35000);
		
		System.out.println("b1 : " + b1/*.toString()*/);
		System.out.println("b2 : " + b2/*.toString()*/);
		System.out.println("b1.equals(b2) : " + b1.equals(b2));
		
		Book b3 = new Book("자바정복", "홍길동", 28000);
		System.out.println("b1.equals(b3) : " + b1.equals(b3));
		System.out.println("b1 == b3 : " + (b1 == b3));
		
		Book b4 = (Book)b1.clone();
		System.out.println("b4 : " + b4);
		System.out.println("b4 : " + b4.hashCode());
		System.out.println("b1 : " + b1.hashCode());
	}

}





