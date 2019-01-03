package com.practice2.controller;

import com.practice2.model.entity.*;

public class TestPolymorphism {

	public static void main(String[] args) {
		// 다형성 테스트
		//상속관계에 있는 클래스일 때
		//부모 클래스형 레퍼런스는
		//후손 객체의 주소를 받을 수 있음
		/*Circle cir = new Circle(10, 10, 50);
		Rectangle rec = 
			new Rectangle(50, 50, 100, 200);
		
		Point p = cir;		
		p = rec;*/
		
		Point p = new Circle(10, 10, 50);
		p.draw();
		
		p = new Rectangle(50, 50, 100, 200);
		p.draw();
		
		//후손 레퍼런스는 부모객체의 주소를
		//받을 수 없음
		//Circle cir = new Point(); //에러
	
		Object obj = new Point();
		obj = new Circle();
		obj = new Rectangle();
		obj = new String();
		obj = new java.util.ArrayList();
	}

}




