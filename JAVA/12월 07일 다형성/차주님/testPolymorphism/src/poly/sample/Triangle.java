package poly.sample;

public class Triangle extends Shape{
	//Field
	private int base;  //밑변
	private int height; //높이
	
	//Constructor
	public Triangle() {}
	
	public Triangle(int x, int y, 
			int base, int height) {
		super(x, y);
		this.base = base;
		this.height = height;
	}
	
	//Method
	public void setBase(int base) {
		this.base = base;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getBase() {
		return this.base;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	//빗변길이 구하는 메소드
	public int getHypotenuse() {
		return (int)(Math.sqrt(
				Math.pow(base, 2) + 
				Math.pow(height, 2)));
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
			+ this.base + ", "
			+ this.height;
	}	
	
	@Override
	public int getArea() {
		// 삼각형의 면적 구해서 리턴
		return (base * height) / 2;
	}

	@Override
	public int getPerimeter() {
		// 삼각형의 둘레 구해서 리턴
		return base + height + getHypotenuse();
	}

}






