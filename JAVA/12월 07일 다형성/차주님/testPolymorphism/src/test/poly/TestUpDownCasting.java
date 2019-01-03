package test.poly;

import poly.sample.*;

public class TestUpDownCasting {

	public void test1() {
		Shape s = null;
		
		s = new Circle(10, 10, 50);
		//UpCasting
		
		//�ļ�Ÿ������ �ٿ� ĳ���ýÿ���
		//���۷����� �����ϴ� 
		//��ü�� Ŭ�������� Ȯ���ؾ� ��
		if(s instanceof Rectangle) {
			System.out.println("Rectangle ��ü��.");
			((Rectangle)s).setWidth(50);
		}else if(s instanceof Circle) {
			System.out.println("Circle ��ü��.");
			System.out.println("������ : " 
					+ ((Circle)s).getRadius());
		}else if(s instanceof Triangle) {
			System.out.println("Triangle ��ü��.");
			System.out.println("�������� : " + 
					((Triangle)s).getHypotenuse());
		}
		
	}
	
	
	public static void main(String[] args) {
		// ��Ӱ��迡 �ִ� �θ�, �ڽ�Ŭ������
		//����ȯ �׽�Ʈ
		TestUpDownCasting samp = 
				new TestUpDownCasting();
		samp.test1();

	}

}




