package com.practice2.model.entity;

public class Circle extends Point{
	private int radius;
	
	public Circle() {}
	public Circle(int x, int y, int radius) {
		/*super.x=x;
		super.y=y;*/
		super(x,y);		//�θ��� �Ű����� �ִ� �����ڸ� ����Ϸ��� �̷� ������ �ۼ�
							//super�� �ݵ�� ù �ٿ� �ۼ�
							//ù �ٿ� �ִ� ���� : �θ� ���� ���� ��Ű�� �� ������ �ڼ�
							//�����Ű���� �ڹٿ��� ����.
		
		/*this.x=x;	//Point Ŭ������ x,y�� 
		 * this.y=y;*/  //protected�� ���� �Ǿ��ֱ� ������ this�ε� ����
		
		this.radius=radius;
	}
	
	@Override
	public void draw() {
		/*���� �Ѱ�
		 * System.out.println("�� ���� = "+(int)(Math.PI*100)/100.0+"X"+this.radius+"X"+this.radius+" = " + ((int)(((Math.PI*this.radius*this.radius)+0.05)*10)/10.0) );
		System.out.println("�� �ѷ� = " + ((int)(((2*Math.PI*this.radius)+0.05)*10)/10.0));
		*/
		double area = (int)(Math.PI*radius*radius*10)/10.0;
		double perimeter = (int)(2*Math.PI*radius*10) / 10.0;
		super.draw();	//�θ� Ŭ������ ���� �ִ� draw() ȣ��
		//this.draw(); ���ȣ��
		
		/*System.out.printf("�� ���� = %.1f \n",area);
		System.out.printf("�� �ѷ� : %1.f\n", perimeter);*/
		System.out.println("�� ���� : "+area);
		System.out.println("�� �ѷ� : "+perimeter);
	}
}
