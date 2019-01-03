package loop.sample;

import java.util.Scanner;

public class ContinueSample {
	//1~100���� �������� ���� ���ؼ� ���
	//��, 3�� ����� �����ϰ� �����
	public void testContinue1() {
		int sum = 0;
		
		for(int k = 1; k < 101; k++) {
			if(k % 3 == 0)
				continue;  //�Ʒ��� ������ �������� ���� ���������� ����.
			
			System.out.print(k + "+");
			sum += k;
		}
		
		System.out.println("\n1~100���� "
				+ "3�� ����� ������ �������� �հ� : "
				+ sum);
	}
	
	public void testContinue11() {
		int sum = 0;
		
		int k = 0;
		while(++k < 101) {
			if(k % 3 == 0)
				continue;  //�Ʒ��� ������ �������� ���� ���������� ����.
			
			System.out.print(k + "+");
			sum += k;
		}
		
		System.out.println("\n1~100���� "
				+ "3�� ����� ������ �������� �հ� : "
				+ sum);
	}
	
	public void testContinue12() {
		int sum = 0;
		
		int k = 0;
		do {
			//++k;
			if(++k == 101)
				break;
			
			if(k % 3 == 0)
				continue;  //�Ʒ��� ������ �������� ���� ���������� ����.
			
			System.out.print(k + "+");
			sum += k;
		//}while(k < 100);
		}while(true);
		
		System.out.println("\n1~100���� "
				+ "3�� ����� ������ �������� �հ� : "
				+ sum);
	}
	
	//�������� �ܼ� �Է¹޾�
	//�ش� ���� ������ ���
	//������ ���ϱ� ���� �Է¹޾�
	//�����ϰ� ��� ó��
	//�ܼ� : 3
	//������ ���ϱ� �� : 5
	//������ �׸� : 3 * 5 = 15
	public void testContinue2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ܼ� : ");
		int dan = sc.nextInt();
		System.out.print("������ ���ϱ� �� : ");
		int su = sc.nextInt();
		
		for(int k = 1; k < 10; k++) {
			if(k == su)
				continue;
			
			System.out.println(dan + " * " 
				+ k + " = " + (dan * k));
		}
	}
}






