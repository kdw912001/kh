package method.run;

import test.method.NonStaticSample;

public class TestNonStaticSample {

	public static void main(String[] args) {
		// non static method �ǽ�1
		NonStaticSample samp = 
				new NonStaticSample();

		//1. ��ȯ�� ���� �Ű����� ���� �޼ҵ�
		//samp.printLottoNumbers();
		
		//2. ��ȯ�� ���� �Ű����� �ִ� �޼ҵ�
		//�Ű�����(parameter) <-- ��������(argument)
		//�Ű������� �������ڴ� �ݵ��
		//�ڷ����� ������ ������ ��ġ���Ѿ� ��
		//samp.outputChar(10, '��');
		
		//3. ��ȯ�� �ְ� �Ű����� ���� �޼ҵ�
		/*char rc = samp.alphabette();
		System.out.println("���� : " + rc);*/
		//System.out.println((int)rc);
		/*System.out.println("���� : " 
				+ samp.alphabette());*/
		
		//4. ��ȯ�� �ְ� �Ű����� �ִ� �޼ҵ�
		/*String result = samp.mySubstring("java program", 2, 8);
		System.out.println("result : " + result);*/
		System.out.println("result : " + 
		samp.mySubstring("java oop program", 5, 12));
	}
	

	
}
