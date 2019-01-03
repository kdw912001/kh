package test.poly;

import poly.sample.*;

public class TestPoly2 {

	public static void main(String[] args) {
		// 추상메소드 오버라이딩 테스트
		Shape sp = null;
		
		sp = new Circle(100, 100, 150);
		//클래스 형변환이 발생함
		//상속관계에 있는 클래스끼리만 형변환 가능함
		//후손이 부모타입으로 바뀜 : UpCasting 이라고 함
		//자동으로 형변환됨
		System.out.println("반지름 : " + ((Circle)sp).getRadius());
		
		
		System.out.println("원 : " + sp.toString());
		System.out.println("원면적 : " + sp.getArea());
		System.out.println("원둘레 : " + sp.getPerimeter());
		
		sp = new Rectangle(10, 10, 120, 70);
		//자동 upcasting 됨
		//sp 로는 Shape 클래스 멤버만 사용할 수 있게 됨 
		//후손이 소유한 후손메소드를 사용하려면
		//후손클래스형으로 형변환하면 됨
		//부모레퍼런스를 후손타입으로 형변환함 : DownCasting
		//직접 명시해야함
		System.out.println("가로너비 : " + ((Rectangle)sp).getWidth());
		
		System.out.println("사각형 : " + sp.toString());
		System.out.println("사각형면적 : " + sp.getArea());
		System.out.println("사각형둘레 : " + sp.getPerimeter());

		sp = new Triangle(50, 50, 100, 120);
		System.out.println("삼각형 : " + sp.toString());
		System.out.println("삼각형면적 : " + sp.getArea());
		System.out.println("삼각형둘레 : " + sp.getPerimeter());
	}

}





