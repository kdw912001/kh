package loop.sample;

import java.util.Scanner;

public class ForSample {
	public void testFor1() {
		//1���� 100���� �������� �հ�
		//���ϱⰡ 100�� ������ �Ǿ�� ��
		int sum = 0;
		for(int su = 1; su <= 100; su++) {
			System.out.print(su + "+");
			sum += su;
		} //for
		
		System.out.println();
		System.out.println("���ϱ��� : " + sum);
	}
	
	//���� �� ���� �Է¹޾�
	//�μ��� ���������� ū�������� �������� ��
	//�� ���ؼ� ���
	public void testFor2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ���� : ");
		int first = sc.nextInt();
		System.out.print("�ι�° ���� : ");
		int second = sc.nextInt();
		
		int max, min;
		if(first > second) {
			max = first;
			min = second;
		}else {
			max = second;
			min = first;
		}
		
		int sum = 0;
		for(int k = min; k <= max; k++) {
			System.out.print(k + "+");
			sum += k;
		}
		
		System.out.println();
		System.out.println(min + "~" + max
				+ "������ �հ� : " + sum);
	}
	
	//1~100 ������ ���� �߻���Ŵ
	//1���� ���������� �հ踦 ���Ͽ� ���
	public void testFor3() {
		int limit = (int)(Math.random() * 100) + 1;
		System.out.println("���ᰪ : " + limit);
		
		int sum = 0;		
		for(int su = 1; su <= limit; su++) {
			if(su == limit)
				System.out.print(su);
			else
				System.out.print(su + "+");
			
			sum += su;
		}
		
		System.out.println("\n�հ� : " + sum);
		
	}
	
	//�������� �ܼ��� �Է¹޾�
	//�ش� �������� ���
	public void testFor4() {
		System.out.print("�ܼ� : ");
		int dan = new Scanner(System.in).nextInt();
		
		for(int su = 1; su <= 9; su++) {
			System.out.println(dan + " * "
				+ su + " = " + (dan * su));
		}
	}
}








