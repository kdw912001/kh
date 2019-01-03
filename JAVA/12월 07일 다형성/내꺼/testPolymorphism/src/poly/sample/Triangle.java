package poly.sample;

public class Triangle extends Shape{
	private int base;
	private int height;
	
	public Triangle() {}
	public Triangle(int x, int y, int base, int height) {
		super(x,y);
		this.base=base;
		this.height=height;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	//빗변길이 구하는 메소드
	public int getHypotenuse() {
		return (int)Math.sqrt(Math.pow(base, 2)+Math.pow(height, 2)); 
		//Math.sqrt는 제곱근 구하기 위한 메소드
	}
	
	public String toString() {
		return super.toString()+ ", "+this.base+", "+this.height;
	}
	
	@Override
	public int getArea() {
		// 삼각형의 면적 구해서 리턴
		return (base*height)/2;
	}
	@Override
	public int getPerimeter() {
		
		return base+height+getHypotenuse();
	}
	
	
	
}
