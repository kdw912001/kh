package method.run;

import nonstatic.method.sample.MethodSample;

public class TestMethodSample {

	public static void main(String[] args) {
		// method test
		//non-static method ��� �׽�Ʈ
		MethodSample msamp = new MethodSample();
		
		//1. ��ȯ�� ���� �Ű����� ���� �޼ҵ� ���
		//���۷���.�޼ҵ�();
		msamp.printLotto();
		
		//2. ��ȯ�� ����, �Ű����� �ִ� �޼ҵ� ���
		//���۷���.�޼ҵ�(���ް�);
		msamp.printUnicode('K');
		
		//3. ��ȯ�� �ְ�, �Ű����� ���� �޼ҵ� ���
		//���ϰ� �޾��� ���� = ���۷���.�޼ҵ�();
		int value = msamp.random1to100();
		System.out.println("value : "+ value);
		
		//4. ��ȯ�� �ְ� �Ű����� �ִ� �޼ҵ� ���
		//���ϰ� �޾��� ���� = ���۷���.�޼ҵ�(�Ű��������� ������ ��);
		int result = msamp.randomInt(51, 70);
		System.out.println("result : "+result);
		
		//��ȯ���� �ִ� �޼ҵ� ���2
		//��ȯ���� ����ϴ� ��ġ�� �޼ҵ带 �ٷ� ����� �� ����
		System.out.println("���� ��� : " + msamp.random1to100());
		
		if(msamp.randomInt(1, 10) % 2 ==0) {
			System.out.println("���ϵ� ���� ¦����.");
		}else {
			System.out.println("Ȧ����.");
		}
	}

}
