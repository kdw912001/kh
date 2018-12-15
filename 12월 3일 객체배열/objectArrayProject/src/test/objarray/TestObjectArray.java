package test.objarray;

import obj.array.sample.Book;

public class TestObjectArray {

	public static void testBookArray() {
		//��ü �迭 ����
		Book[] bar;
		//�迭���� �Ҵ�
		bar = new Book[3];
		//Book Ŭ���� ��ü�� �ּҺ�����
		//���۷��������� 3���� �迭�� �Ҵ���
		
		System.out.println("length : " 
				+ bar.length);
		
		for(int i = 0; i < bar.length; i++) {
			System.out.println(bar[i]);
		}
		
		//�غ�� �� ���۷��������濡 �ּ� ���
		//��ü ������ �ؼ� �ּ� �߻���Ŵ
		bar[0] = new Book("�ڹ�����", "ȫ�浿", 28000, 0.1);
		bar[1] = new Book("Oracle 11g", "��ö��", 35000, 0.05);
		bar[2] = new Book("JDBC", "�̿���", 20000, 0.15);
		
		for(int i = 0; i < bar.length; i++) {
			System.out.println(i + " : " 
		                + bar[i].hashCode());
			System.out.println(bar[i].bookInfo());
		}
	}
	
	public static void testBookArray2() {
		//��ü �迭�� �ʱ�ȭ
		//�ʱⰪ : ��ü ������ �ּ�
		Book[] bar = new Book[]{
				new Book("�ڹ�����", "ȫ�浿", 28000, 0.1),
				new Book("Oracle 11g", "��ö��", 35000, 0.05),
				new Book("JDBC", "�̿���", 20000, 0.15)};
		
		int sum = 0;
		for(int i = 0; i < bar.length; i++) {
			sum += bar[i].getPrice();
			System.out.println(bar[i].bookInfo());
		}
		
		System.out.println("���� : " + sum);
	}
	
	public static void testBookArray3() {
		//��ü �迭�� �ʱ�ȭ
		//�ʱⰪ : ��ü ������ �ּ�
		Book[] bar = new Book[]{
				new Book("�ڹ�����", "ȫ�浿", 28000, 0.1),
				new Book("Oracle 11g", "��ö��", 35000, 0.05),
				new Book("JDBC", "�̿���", 20000, 0.15)};
		
		//�� ��ü�� �������ݿ� ������ ������
		//�������� ����� ���� ������ �����
		
		//�������� ����ϰ�,
		//������ ���� ���� : 000000 ��
		for(int i = 0; i < bar.length; i++) {
			System.out.println(bar[i].bookInfo());
			int discountPrice = bar[i].getPrice() 
				- (int)(bar[i].getPrice() 
						* bar[i].getDiscountRate());
			System.out.println("������ ���� ���� : "
					+ discountPrice);
		}
	}
	
	public static void main(String[] args) {
		// ��ü�迭 �׽�Ʈ
		//testBookArray();
		//testBookArray2();
		testBookArray3();
	}

}
