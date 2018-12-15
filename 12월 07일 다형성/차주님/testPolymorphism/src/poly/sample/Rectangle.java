package poly.sample;

public class Rectangle extends Shape{
	//Field
	private int width; //가로너비
	private int height; //세로높이
	
	//Constructor
	public Rectangle() {
		super();
	}
	
	public Rectangle(int x, int y, 
			int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	//Method
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
			+ this.width + ", "
			+ this.height;
	}

	@Override
	public int getArea() {
		// 사각형의 면적을 구해서 리턴
		return width * height;
	}

	@Override
	public int getPerimeter() {
		// 사각형의 둘레를 계산해서 리턴
		return 2 * (width + height);
	}
}






