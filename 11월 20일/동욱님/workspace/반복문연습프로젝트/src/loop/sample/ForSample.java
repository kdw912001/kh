package loop.sample;

import java.util.Random;
import java.util.Scanner;

public class ForSample {
	public void forTest1() {
		//1���� 100���� �������� �հ�
		//���ϱⰡ 100�� ������ �Ǿ�� ��.
		int sum = 0; //���ϱ� �����̸� 0���� �ʱ�ȭ
						//���ϱ� �����̸� 1�� �ʱ�ȭ
		for(int su = 1; su<=100; su++ ) {
			System.out.print(su + "+");
			sum += su;
		}//for
		System.out.println();
		System.out.println("���ϱ� ��� : " +sum);
	}
	
	
	//���� �� ���� �Է¹޾� 
	//�� �� �� ���������� ū�������� �������� ��
	//�� ���ؼ� ���
	public void testFor2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ� �Է� : ");
		int first = sc.nextInt();
		System.out.print("�ٸ� ���� �Է� : ");
		int second = sc.nextInt();
		int sum = 0;
		/*if(first<second) {
				for(int i = first; i<=second;i++) {
					sum+=i;
				}
		}
		else if(first>second) {
			for(int i=second; i<=first;i++) {
				sum+=i;
			}
		}
		else
			sum=first; // �Է��� �� ���� �����ϴ�.
			
		
*/		
		int max, min;
		if(first > second) {
			max = first;
			min = second;
		}
		else {
			max = second;
			min = first;
		}
		
		
		for(int k = min; k<=max; k++) {
			System.out.print(k + "+");
			sum +=k;
		}
		System.out.println();
		System.out.println(min + "~"+max+"������ �հ� : "+sum);
				
	}
	
	//1~100 ������ ���� �߻���Ŵ
	//1���� ���������� �հ踦 ���Ͽ� ���
	public void testFor3() {
		int rnum = (int)(Math.random()*100)+1;
		System.out.println("���ᰪ : "+rnum);
		
		int sum = 0;
		
		for(int i=1; i<=rnum; i++) {
			if(i == rnum) //�������� +�� ��µ��� �ʱ� ���� �ۼ�
				System.out.println(i);
			else
				System.out.print(i+"+");
			sum+=i;
		}
		System.out.println();
		System.out.println("1~"+rnum+"������ �� : "+sum);
	}
	
	
	//�������� �ܼ��� �Է¹޾�
	//�ش� �������� ���
	public void testFor4() {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		for(int i=1;i<=9;i++) {
			System.out.println(num1 + "x" + i + " = " + num1*i);
		}
	}
}
