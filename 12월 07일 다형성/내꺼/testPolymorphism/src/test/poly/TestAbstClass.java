package test.poly;
import poly.sample.*;

public class TestAbstClass {

	public static void main(String[] args) {
		// abstract class
		//	�̿ϼ�(�߻�)Ŭ������ ��ü ���� ����
		//���۷��� ������ ���� ������
		AbstClass ref;
		//ref = new AbstClass(); //������ �ּҴ� ���۷��� ���� ��������
		//ref = new Shape(15, 15);	//�ļ��� �ּҴ� ���� �� ���� 
		//abstract Ŭ������ ��ü���� ����
		System.out.println("ref : "+ref.toString());
		//AbsClass()�� toString()�޼ҵ尡 �����Ƿ� ObjectŬ������ toString ȣ����.
		
		ref = new Circle();
		ref = new Rectangle();
	}

}
