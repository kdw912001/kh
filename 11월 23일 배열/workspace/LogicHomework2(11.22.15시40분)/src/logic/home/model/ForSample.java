package logic.home.model;

import java.util.Scanner;

public class ForSample {
	private Scanner sc = new Scanner(System.in);
	public void sum1To10() {
		int sum=0;
		for(int i=1;i<=10;i++) {
			sum+=i;
		}
		System.out.println("1~10까지의 합 : "+sum);
		
	}

	public void sumEven1To100() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%2==0)
				sum+=i;
		}
		System.out.println("1~100까지의 짝수 합 : "+sum);
		
	}

	public void oneGugudan() {
		System.out.println("입력한 정수의 구구단을 출력합니다. 정수입력 : ");
		int dan = sc.nextInt();
		for(int i=1;i<=9;i++) {
			System.out.println(dan+"x"+i+"="+(dan*i));
		}
		
	}

	public void sumMinToMax() {
		System.out.print("정수 하나 입력 : ");
		int num1=sc.nextInt();
		System.out.print("다른 정수 입력 : ");
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
		System.out.println(min+"~"+max+"의 합 : "+sum);
	}

	public void printStar() {
		System.out.print("칸수 입력 : ");
		int row = sc.nextInt();
		System.out.print("줄수 입력 : ");
		int line = sc.nextInt();
		for(int i=1;i<=line;i++) {
			for(int j=1;j<=row;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println(); //부메뉴와 구분 하기 위한 println
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
		System.out.println(); //부메뉴와 구분 하기 위한 println
	}

	public void printTriangleStar() {//수업시간에 했던 줄과 칸을 if문으로 비교
		System.out.print("줄 수 입력 : ");
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
		else System.out.println("0을 입력하면 안 됩니다.");
		
		System.out.println();//부메뉴와 구분하기 위해 작성 이 후론 같은 주석 생략
		
	}

	public void guguDan() {
		for(int i=2;i<=9;i++) {
			System.out.println(i+"단");
			for(int j=1;j<=9;j++) {
				System.out.println(i+"x"+j+"="+(j*i));
			}
			System.out.println("------------");//단 구분
		}
		
	}
	

}
