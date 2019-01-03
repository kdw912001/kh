package test.string.method;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class TestImmutable {

	public static void main(String[] args) {
		// String is immutable.
		//���ڿ� ����ҿ� ��ϵ� ���ڿ�����
		//�����Ұ���
		String s = "java";
		String s2 = new String("java");
		
		System.out.println("s == s2 : "
				+ (s == s2));
		System.out.println("hashCode() �� : "
				+ (s.hashCode() == s2.hashCode()));
		
		//���ڿ�����Ҵ� �ѹ� ��ϵ� ���ڿ���
		//�� �� ������� �ʴ´�.
		//�̹� ��ϵ� ���ڿ����� ��ġ�� ������
		System.out.println("s : " + s.hashCode());
		System.out.println("s2 : " + s2.hashCode());
		
		//���ڿ�����ҿ� ��ϵ� ���ڿ�����
		//������� : immutable
		String s3 = s.toUpperCase();
		System.out.println("s : " + s);
		System.out.println("s3 : " + s3);
		System.out.println("s3 : " + s3.hashCode());
	}

}





