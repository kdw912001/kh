package logic.home.model;

import java.util.Scanner;

public class ForSample {
	private Scanner sc = new Scanner(System.in);
	public void sum1To10() {
		int sum=0;
		for(int i=1;i<=10;i++) {
			sum+=i;
		}
		System.out.println("1~10������ �� : "+sum);
		
	}

	public void sumEven1To100() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%2==0)
				sum+=i;
		}
		System.out.println("1~100������ ¦�� �� : "+sum);
		
	}

	public void oneGugudan() {
		System.out.println("�Է��� ������ �������� ����մϴ�. �����Է� : ");
		int dan = sc.nextInt();
		for(int i=1;i<=9;i++) {
			System.out.println(dan+"x"+i+"="+(dan*i));
		}
		
	}

	public void sumMinToMax() {
		System.out.print("���� �ϳ� �Է� : ");
		int num1=sc.nextInt();
		System.out.print("�ٸ� ���� �Է� : ");
		int num2=sc.nextInt();
		int max,min;
		int sum=0;
		if(num1>num2) {
			max=num1;
			min=num2;
		}else {
			max=num2;
			min=num1;
		}
		
		for(int i=min;i<=max;i++) {
			sum+=i;
		}
		System.out.println(min+"~"+max+"�� �� : "+sum);
	}

	public void printStar() {
		System.out.print("ĭ�� �Է� : ");
		int row = sc.nextInt();
		System.out.print("�ټ� �Է� : ");
		int line = sc.nextInt();
		for(int i=1;i<=line;i++) {
			for(int j=1;j<=row;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println(); //�θ޴��� ���� �ϱ� ���� println
	}

	public void printNumberStar() {
		for(int i=1;i<=7;i++) {
			for(int j=1;j<=7;j++) {
				if(i==j)
					System.out.print(i);
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println(); //�θ޴��� ���� �ϱ� ���� println
	}

	public void printTriangleStar() {//�����ð��� �ߴ� �ٰ� ĭ�� if������ ��
		System.out.print("�� �� �Է� : ");
		int line = sc.nextInt();
		if(line>0) {
			for(int i=1;i<=line;i++) {
				for(int j=1;j<=i;j++) {
					System.out.print("*");
					if(i==j)
						System.out.println();
				}
			}
		}
		else if(line<0) {
			line=-line;
			for(int i=1;i<=line;i++) {
				for(int j=1;j<=line;j++) {
					if(i>j)
						System.out.print(" ");
					else
						System.out.print("* ");
				}
				System.out.println();
			}
		}
		else System.out.println("0�� �Է��ϸ� �� �˴ϴ�.");
		
		System.out.println();//�θ޴��� �����ϱ� ���� �ۼ� �� �ķ� ���� �ּ� ����
		
	}

	public void guguDan() {
		for(int i=2;i<=9;i++) {
			System.out.println(i+"��");
			for(int j=1;j<=9;j++) {
				System.out.println(i+"x"+j+"="+(j*i));
			}
			System.out.println("------------");//�� ����
		}
		
	}
	

}
