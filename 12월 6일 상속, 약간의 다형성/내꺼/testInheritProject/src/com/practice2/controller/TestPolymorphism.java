package com.practice2.controller;

import com.practice2.model.entity.*;

public class TestPolymorphism {

	public static void main(String[] args) {
		// 다형성 테스트
		// 상속관계에 있는 클래스일 때 
		// 부모 클래스형 레퍼런스는 
		// 후손 객체의 주소를 받을 수 있음
		/*Circle cir = new Circle(10, 10, 50);
		Rectangle rec = new Rectangle(50, 50, 100, 200);
		
		Point p = cir;
		p = rec;*/
		
		Point p = new Circle(10, 10, 50);
		p.draw();	//Circle 클래스의 draw()가 실행 ->동적 바인딩 개념
		p = new Rectangle(50, 50, 100, 200);
		p.draw();	//Rectangle 클래스의 draw()가 실행 ->동적 바인딩 개념
		
		//후손 레퍼런스는 부모객체의 주소를 받을 수 없음
		//Circle cir = new Point();  //에러
	
		//Object는 최상위 부모기 때문에 온갖 클래스를 다 받을 수 있음.
		//다양한 많은 클래스형을 부모 타입 한 개로 다룰 수 있다->다형성
		Object obj = new Point();    
		obj = new Circle();
		obj = new Rectangle();
		obj = new String();
		obj = new java.util.ArrayList();
	}

}
