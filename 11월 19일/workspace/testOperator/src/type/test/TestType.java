package type.test;

public class TestType {

	public static void main(String[] args) {
		//�ڹٰ� byte �ڷ����� short �ڷ���
		//����� ����� int �ڷ������� 
		//������
		byte b =12;
		int result = b + b;
		byte result2 = (byte)(b + b); //������� int���̱� ������ byte����ȯ
		
		short s = 234;
		short result3 = (short)(s + s); //������� int���̱� ������ short����ȯ
		int result4 = s + s;
		
		int result5 = b + s; //�ڵ�����ȯ byte���� b->short ��� short+short=int��
		
	}

}
