package poly.sample;

public abstract class Shape/* extends AbstClass*/ 
implements IShape {
	//Field
	private int x;	//x좌표
	private int y;	//y좌표
	
	//초기화블럭 : 인스턴스변수 초기값 처리
	{
		x = y = 10;
	}
	
	//Constructor
	public Shape() {
		super();
	}
	
	public Shape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	//Method
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public String toString() {
		//return "클래스명@16진수해시코드";
		return this.x + ", " + this.y;
	}

	/*@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}*/
}





