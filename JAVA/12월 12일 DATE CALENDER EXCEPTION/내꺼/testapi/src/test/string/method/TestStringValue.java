package test.string.method;

public class TestStringValue {

	public static void stringToData() {
		//���ڿ��� => �⺻�ڷ��������� ����
		//�Ľ�(parsing)
		//Wrapper(����) Ŭ�������� �޼ҵ�� ����
		//�⺻�ڷ����� ���� Ŭ����
		String value = "12345";
		//String value = "apple"; //NumberFormatException
		int num = Integer.parseInt(value);
		System.out.println("num : "+num);
		
		int num2 = Integer.valueOf(value);
		//�� ������ �Ʒ��� ���� �Ʒ��� �� ������ �ڵ����� ó��
		//Auto UnBoxing ó���� �Ǿ���
		//��ü => ��
		/*Integer ref = Integer.valueOf(value);
		int num2 = ref.intValue();*/
	}
	//static �޼ҵ�� this���۷����� ���
	//Ŭ������.�޼ҵ�� ���
	public static void main(String[] args) {
		// ���ڿ��� <=>�⺻�ڷ����� ��ȯó��
		stringToData();
	}

}
