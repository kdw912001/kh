package test.poly;

import poly.sample.*;

public class TestPoly1 {

	public static void main(String[] args) {
		// ��ӹ��� �θ��� public �޼ҵ��
		//�ļ��� �ڽ��� ��ó�� ����� �� �ִ�.
		Circle cir = new Circle(100, 100, 50);
		Rectangle rec = new Rectangle(20, 20, 150, 200);
		
		System.out.println("cir : " + cir/*.toString()*/);
		System.out.println("rec : " + rec.toString());

		//�θ�Ŭ������ ���۷�����
		//�ļ� ��ü�� �ּҸ� ���� �� �ִ�.
		//������
		Shape sh = cir;
		System.out.println("sh : " + sh.toString());
		
		sh = rec;
		System.out.println("sh : " + sh.toString());
	
		Object obj = cir;
		System.out.println("obj : " + obj.toString());
		
		obj = rec;
		System.out.println("obj : " + obj.toString());
	}

}







