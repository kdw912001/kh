package test.exception;

import java.io.FileNotFoundException;

public class TestThrows {

	public static void main(String[] args) throws FileNotFoundException {
		// throws test
		testA();
	}
	public static void testA() throws FileNotFoundException {
		testB();
	}
	
	public static void testB() throws FileNotFoundException {//testB�� ����ϴ� ��ġ�� ���ܸ� �ѱ�
		testC();
	}
	
	public static void testC() throws FileNotFoundException /*testC�� ����ϴ� ��ġ�� ���ܸ� �ѱ� B��*/{
		new java.io.FileInputStream("test.dat");//�⺻��ġ ������Ʈ ���� �ȿ��� �� ������ ã��
	}
}
