package test.string.method;

import java.util.*;

public class TestStringTokenizer {

	public static void main(String[] args) {
		// java.util.StringTokenizer test
		StringTokenizer st = new StringTokenizer("servlet jsp mybatis spring");
		//�⺻���� ���鹮�ڰ� ��ū ���й���
		System.out.println("�и��� ��ū�� : "+st.countTokens());
		
		while(st.hasMoreTokens()) {
			//index�� ���� ������ for������ while��
			//���̻� ��ū�� ���ٸ� false
			System.out.println(st.nextToken());
		}
		System.out.println("----------------");
		
		StringTokenizer st2 = new StringTokenizer("eclipse,editplus staruml&exerd", ",& ");
										//������ �ʿ���� ������ ���ڸ� �Է��ϸ� ��
		System.out.println("��ū�� : "+st2.countTokens());
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		//���߿� jsp�� �� StringTokenizer �����
	}
}
