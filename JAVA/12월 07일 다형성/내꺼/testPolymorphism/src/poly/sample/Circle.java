package poly.sample;

public class Circle extends Shape{
	//Field
	private int radius; //원의 반지름
	
	//Constructor
	public Circle() {
		super();//super(); //부모의 기본생성자 호출
	}

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public String toString() {
		return super.toString()+ ", "+this.radius;
	}

	@Override
	public int getArea() {
		// 원의 면적을 구해서 리턴
		return (int)(Math.PI*Math.pow(radius, 2)); 
		//Math.pow(a,b);a를b번 곱한다. 제곱 구할때 사용하는 메서드
	}

	@Override
	public int getPerimeter() {
		// 원 둘레 길이를 계산해서 리턴
		return (int)(2*Math.PI*radius);
	}
	
}
