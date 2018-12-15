package poly.sample;

public class Circle extends Shape{
	//Field
	private int radius; //���� ������
	
	//Constructor
	public Circle() {
		super();  //�θ��� �⺻������ ȣ�ⱸ����.
	}
	
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	//Method
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", "
				+ this.radius;
	}

	@Override
	public int getArea() {
		// ���� ������ ���ؼ� ����
		return (int)(Math.PI * Math.pow(radius, 2));
	}

	@Override
	public int getPerimeter() {
		// �� �ѷ����̸� ����ؼ� ����
		return (int)(2 * Math.PI * radius);
	}
}






