package oop.staticmethod;

public class TestStatic {

	public static void main(String[] args) {
		// static test
		//System.out.println(StaticMethod.value);
		System.out.println("value : " 
				+ StaticMethod.getValue());
		
		//�ʵ尪 ����
		StaticMethod.setValue("static method test");
		System.out.println("value : " 
				+ StaticMethod.getValue());
		
		//�빮�ڷ� ����
		StaticMethod.toUpper();
		System.out.println("value : " 
				+ StaticMethod.getValue());
		
		//���ڰ��� Ȯ��
		System.out.println("���ڰ��� : " 
				+ StaticMethod.valueLength());
		
		//���ں���
		StaticMethod.setChar(6, '-');
		System.out.println("value : " 
				+ StaticMethod.getValue());
		
		//���ڿ� ��ġ��
		String result = 
			StaticMethod.valueConcat("�ǽ�����");
		System.out.println("result : " + result);
		
	}

}
