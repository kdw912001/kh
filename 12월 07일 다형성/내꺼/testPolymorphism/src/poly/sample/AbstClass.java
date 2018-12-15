package poly.sample;

//미완성 된 클래스를 의미함 : 추상클래스
//객체 생성 못 하는 클래스임.
//레퍼런스 변수는 선언할 수 있음
public abstract class AbstClass { //abstract 없으면 에러
	//abstract 사용 이유
	//미완성된 메소드를 멤버변수로 갖고 있을 때
	
	//Constructor
	protected AbstClass() {}  
	//접근제어자 protected로 선언하면 후손클래스에서만 호출가능

	//Method
	//미완성(추상: abstract) 메소드
	public abstract int getArea();
	public abstract int getPerimeter();

}
