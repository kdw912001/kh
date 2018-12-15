package poly.sample;

public class Triangle extends Shape{
	//Field
	private int base;  //�غ�
	private int height; //����
	
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
	
	//�������� ���ϴ� �޼ҵ�
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
		// �ﰢ���� ���� ���ؼ� ����
		return (base * height) / 2;
	}

	@Override
	public int getPerimeter() {
		// �ﰢ���� �ѷ� ���ؼ� ����
		return base + height + getHypotenuse();
	}

}






