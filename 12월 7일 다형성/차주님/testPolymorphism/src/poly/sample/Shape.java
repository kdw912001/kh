package poly.sample;

public abstract class Shape/* extends AbstClass*/ 
implements IShape {
	//Field
	private int x;	//x��ǥ
	private int y;	//y��ǥ
	
	//�ʱ�ȭ�� : �ν��Ͻ����� �ʱⰪ ó��
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
		//return "Ŭ������@16�����ؽ��ڵ�";
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





