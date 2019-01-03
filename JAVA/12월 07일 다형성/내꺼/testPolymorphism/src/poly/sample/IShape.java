package poly.sample;

public interface IShape {
	//상수필드를 멤버로 가질 수도 있음
	public static final int DATA = 1;
	
	//추상메소드만 멤버로 가진 추상클래스 변형체
	/*public abstract */int getArea();
	/*public abstract*/ int getPerimeter();
	//인터페이스에서 메소드는 모두 추상메소드이기 때문에 public abstract 생략 가능

}
