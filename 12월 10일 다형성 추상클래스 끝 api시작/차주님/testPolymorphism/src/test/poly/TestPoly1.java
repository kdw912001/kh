package test.poly;

import poly.sample.*;

public class TestPoly1 {

	public static void main(String[] args) {
		// 상속받은 부모의 public 메소드는
		//후손이 자신의 것처럼 사용할 수 있다.
		Circle cir = new Circle(100, 100, 50);
		Rectangle rec = new Rectangle(20, 20, 150, 200);
		
		System.out.println("cir : " + cir/*.toString()*/);
		System.out.println("rec : " + rec.toString());

		//부모클래스형 레퍼런스가
		//후손 객체의 주소를 받을 수 있다.
		//다형성
		Shape sh = cir;
		System.out.println("sh : " + sh.toString());
		
		sh = rec;
		System.out.println("sh : " + sh.toString());
	
		Object obj = cir;
		System.out.println("obj : " + obj.toString());
		
		obj = rec;
		System.out.println("obj : " + obj.toString());
	}

}







