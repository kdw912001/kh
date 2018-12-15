package poly.sample;

public class Rectangle extends Shape{
	//Field
	private int width; //���γʺ�
	private int height; //���γʺ�
	
	//Constructor
	public Rectangle() {
		super();
	}
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width=width;
		this.height=height;
	}
	
	public void setWidth(int width) {
		this.width=width;
	}
	public int getWidth() {
		return this.width;
	}
	public void setHeight(int height) {
		this.height=height;
	}
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public String toString() {
		return super.toString()+", "+this.width+ ", "+this.height;
	}

	@Override
	public int getArea() {
		// �簢���� ������ ���ؼ� ����
		return width * height;
	}

	@Override
	public int getPerimeter() {
		// �簢���� �ѷ��� ����ؼ� ����
		return 2*(width+height);
	}
}
