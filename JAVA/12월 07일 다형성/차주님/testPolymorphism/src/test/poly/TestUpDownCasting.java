package test.poly;

import poly.sample.*;

public class TestUpDownCasting {

	public void test1() {
		Shape s = null;
		
		s = new Circle(10, 10, 50);
		//UpCasting
		
		//후손타입으로 다운 캐스팅시에는
		//레퍼런스가 참조하는 
		//객체의 클래스형을 확인해야 함
		if(s instanceof Rectangle) {
			System.out.println("Rectangle 객체임.");
			((Rectangle)s).setWidth(50);
		}else if(s instanceof Circle) {
			System.out.println("Circle 객체임.");
			System.out.println("반지름 : " 
					+ ((Circle)s).getRadius());
		}else if(s instanceof Triangle) {
			System.out.println("Triangle 객체임.");
			System.out.println("빗변길이 : " + 
					((Triangle)s).getHypotenuse());
		}
		
	}
	
	
	public static void main(String[] args) {
		// 상속관계에 있는 부모, 자식클래스간
		//형변환 테스트
		TestUpDownCasting samp = 
				new TestUpDownCasting();
		samp.test1();

	}

}




