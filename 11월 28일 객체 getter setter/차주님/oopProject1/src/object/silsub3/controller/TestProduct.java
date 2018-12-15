package object.silsub3.controller;

import object.silsub3.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		/*1. �Ű����� �ִ� �����ڸ� ����ؼ� 3���� ��ü�� ������
		2. ��ü�� ���� �ʵ尪 ���Ȯ��
		<��¿�>
		ssgnote6	  �����ó�Ʈ6  ��⵵����  960000  10.0
		lgxnote5	  LG����Ʈ��5  ��⵵����  780000  0.7
		ktnorm3	  KT�Ϲ���3   ����ð���  25000  0.3*/
		Product p1 = new Product("ssgnote6", "�����ó�Ʈ6", "��⵵����", 960000, 10.0);
		Product p2 = new Product("lgxnote5", "LG����Ʈ��5", "��⵵����", 780000, 0.7);
		Product p3 = new Product("ktnorm3", "KT�Ϲ���3", "����ð���", 25000, 0.3);
		
		p1.information();
		p2.information();
		p3.information();
		
		/*1. �� ��ü�� ������ ��� 120�������� ������
		2. �� ��ü�� �ΰ������� ��� 0.5�� ������
		3. ��� Ȯ��*/
		p1.setPrice(1200000);
		p2.setPrice(1200000);
		p3.setPrice(1200000);
		
		p1.setTex(0.5);
		p2.setTex(0.5);
		p3.setTex(0.5);
		
		System.out.println();
		p1.information();
		p2.information();
		p3.information();
		
		/*1. �ΰ������� ��� 0.05�� ������
		2. �� ��ü�� ���ݿ� �ΰ������� ������ ���� ������ ����ؼ� �����
		���� ���� = ���� + (���� * �ΰ�����);

		<��°��>
		��ǰ�� : �����ó�Ʈ6
		�ΰ��� ���� ���� : 1260000 ��
		��ǰ�� : LG����Ʈ��5
		�ΰ��� ���� ���� : 1260000 ��
		��ǰ�� : KT�Ϲ���3
		�ΰ��� ���� ���� : 1260000 ��*/
		p1.setTex(0.05);
		p2.setTex(0.05);
		p3.setTex(0.05);
		
		int realPrice1 = p1.getPrice() + (int)(p1.getPrice() * p1.getTex());
		int realPrice2 = p2.getPrice() + (int)(p2.getPrice() * p2.getTex());
		int realPrice3 = p3.getPrice() + (int)(p3.getPrice() * p3.getTex());
		
		System.out.println("\n��ǰ�� : " + p1.getProductName());
		System.out.println("�ΰ��� ���� ���� : " + realPrice1 + "��");		
		System.out.println("��ǰ�� : " + p2.getProductName());
		System.out.println("�ΰ��� ���� ���� : " + realPrice2 + "��");
		System.out.println("��ǰ�� : " + p3.getProductName());
		System.out.println("�ΰ��� ���� ���� : " + realPrice3 + "��");
	}

}
