package test.string.method;

public class TestStringValue {

	public static void stringToData() {
		//���ڿ��� => �⺻�ڷ��������� ����
		//�Ľ�(parsing)
		//Wrapper(����) Ŭ�������� �޼ҵ�� ����
		//�⺻�ڷ����� ���� Ŭ���� : ����Ŭ����
		
		String value = "12345";
		//String value = "apple";
		int num = Integer.parseInt(value);
		System.out.println("num : " + num);
		
		int num2 = Integer.valueOf(value);
		//Auto UnBoxing ó���� �Ǿ���
		//��ü => ��
		/*Integer ref = Integer.valueOf(value);
		int num2 = ref.intValue();*/
	}
	
	public static void main(String[] args) {
		// ���ڿ��� <=> �⺻�ڷ����� ��ȯó��
		stringToData();
	}

}





