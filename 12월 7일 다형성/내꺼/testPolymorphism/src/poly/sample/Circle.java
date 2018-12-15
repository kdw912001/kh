package poly.sample;

public class Circle extends Shape{
	//Field
	private int radius; //���� ������
	
	//Constructor
	public Circle() {
		super();//super(); //�θ��� �⺻������ ȣ��
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
		// ���� ������ ���ؼ� ����
		return (int)(Math.PI*Math.pow(radius, 2)); 
		//Math.pow(a,b);a��b�� ���Ѵ�. ���� ���Ҷ� ����ϴ� �޼���
	}

	@Override
	public int getPerimeter() {
		// �� �ѷ� ���̸� ����ؼ� ����
		return (int)(2*Math.PI*radius);
	}
	
}
