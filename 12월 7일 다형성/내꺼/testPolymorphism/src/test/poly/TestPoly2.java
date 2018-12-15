package test.poly;

import poly.sample.*;

public class TestPoly2 {

	public static void main(String[] args) {
		// 추상메소드 오버라이딩 테스트
		Shape sp = null;
		
		sp = new Circle(100,100,150);
		//클래스 형변환이 발생함
		//상속관계에 있는 클래스끼리만 형변환 가능함.
		//후손이 부모타입으로 바뀜 : UpCasting 이라고 함.
		//자동으로 형변환됨
		System.out.println("반지름 : "+((Circle)sp).getRadius());
		//(Circle)형변환 연산자 : 2순위   sp. 에서 . 이 연산자 1순위라서
		//(Circle)sp.getRadius()를 쓰게되면 
		//getRadius()를 (Circle)형으로 변환하라는 얘기니 에러 발생
		//고로 ((Circle)sp).getRadius() 이렇게 작성해야 함.
		System.out.println("원 : "+sp.toString());
		System.out.println("원 면적 : "+sp.getArea());
		System.out.println("원둘레 : "+sp.getPerimeter());
		
		sp = new Rectangle(10,10,120,70);
		//자동 upcasting 됨.
		//sp로는 Shape 클래스 멤버만 사용할 수 있게 됨.
		//후손이 소유한 후소메소드를 사용하려면
		//후손클래스형으로 형변환하면 됨
		//부모레퍼런스를 후손타입으로 형변환함 : DownCasting
		//직접 명시해야 함.
		System.out.println("가로너비 : "+((
				Rectangle)(sp)).getWidth());
		
		System.out.println("사각형 : "+sp.toString());
		System.out.println("사각형 면적 : "+sp.getArea());
		System.out.println("사각형 둘레 : "+sp.getPerimeter());
		
		sp = new Triangle(50,50,100,120);
		System.out.println("삼각형 : "+sp.toString());
		System.out.println("삼각형 면적 : "+sp.getArea());
		System.out.println("삼각형 둘레 : "+sp.getPerimeter());
				
	}
}
