package test.poly;
import poly.sample.*;

public class TestAbstClass {

	public static void main(String[] args) {
		// abstract class
		//	미완성(추상)클래스는 객체 생성 못함
		//레퍼런스 변수는 선언 가능함
		AbstClass ref;
		//ref = new AbstClass(); //본인의 주소는 레퍼런스 선언 못하지만
		//ref = new Shape(15, 15);	//후손의 주소는 받을 수 있음 
		//abstract 클래스는 객체생성 못함
		System.out.println("ref : "+ref.toString());
		//AbsClass()에 toString()메소드가 없으므로 Object클래스의 toString 호출함.
		
		ref = new Circle();
		ref = new Rectangle();
	}

}
