package test.poly;

import poly.sample.*;

public class TestPoly2 {

	public static void main(String[] args) {
		// �߻�޼ҵ� �������̵� �׽�Ʈ
		Shape sp = null;
		
		sp = new Circle(100, 100, 150);
		//Ŭ���� ����ȯ�� �߻���
		//��Ӱ��迡 �ִ� Ŭ���������� ����ȯ ������
		//�ļ��� �θ�Ÿ������ �ٲ� : UpCasting �̶�� ��
		//�ڵ����� ����ȯ��
		System.out.println("������ : " + ((Circle)sp).getRadius());
		
		
		System.out.println("�� : " + sp.toString());
		System.out.println("������ : " + sp.getArea());
		System.out.println("���ѷ� : " + sp.getPerimeter());
		
		sp = new Rectangle(10, 10, 120, 70);
		//�ڵ� upcasting ��
		//sp �δ� Shape Ŭ���� ����� ����� �� �ְ� �� 
		//�ļ��� ������ �ļո޼ҵ带 ����Ϸ���
		//�ļ�Ŭ���������� ����ȯ�ϸ� ��
		//�θ��۷����� �ļ�Ÿ������ ����ȯ�� : DownCasting
		//���� ����ؾ���
		System.out.println("���γʺ� : " + ((Rectangle)sp).getWidth());
		
		System.out.println("�簢�� : " + sp.toString());
		System.out.println("�簢������ : " + sp.getArea());
		System.out.println("�簢���ѷ� : " + sp.getPerimeter());

		sp = new Triangle(50, 50, 100, 120);
		System.out.println("�ﰢ�� : " + sp.toString());
		System.out.println("�ﰢ������ : " + sp.getArea());
		System.out.println("�ﰢ���ѷ� : " + sp.getPerimeter());
	}

}





