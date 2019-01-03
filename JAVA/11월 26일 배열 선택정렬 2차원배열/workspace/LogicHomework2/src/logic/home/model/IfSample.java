package logic.home.model;

import java.util.Scanner;

public class IfSample {
	private Scanner sc = new Scanner(System.in);
	int num1,num2,num3;
	public void maxNumber(){
		System.out.println("두 수중 큰 값 출력하기");
		System.out.print("정수 하나 입력 : ");
		num1 = sc.nextInt();
		System.out.print("다른 정수 입력 : ");
		num2 = sc.nextInt();
		if(num1>num2)
			System.out.println("두 수 중 큰 값 : "+num1);
		else if(num1<num2)
			System.out.println("두 수 중 큰 값 : "+num2);
		else
			System.out.println("같은 값을 입력하셨습니다.");
		
	}
	public void minNumber() {
		System.out.println("두 수중 작은 값 출력하기");
		System.out.print("정수 하나 입력 : ");
		num1 = sc.nextInt();
		System.out.print("다른 정수 입력 : ");
		num2 = sc.nextInt();
		
		if(num1<num2)
			System.out.println("두 수 중 작은 값 : "+num1);
		else if(num1>num2)
			System.out.println("두 수 중 작은 값 : "+num2);
		else
			System.out.println("같은 값을 입력하셨습니다.");
		
	}
	public void ThreeMaxMin() {
		System.out.println("세 수중 가장 큰 수와 가장 작은 수 출력하기");
		
		System.out.print("첫번째 정수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		num2 = sc.nextInt();
		System.out.print("세번째 정수 입력 : ");
		num3 = sc.nextInt();
		if(num1>num2&&num1>num3)
			System.out.println("가장 큰 수: "+num1);
		if(num2>num1&&num2>num3)
			System.out.println("가장 큰 수 : "+num2);
		if(num3>num1&&num3>num2)
			System.out.println("가장 큰 수 : "+num3);
		if(num1<num2&&num1<num3)
			System.out.println("가장 작은 수: "+num1);
		if(num2<num1&&num2<num3)
			System.out.println("가장 작은 수 : "+num2);
		if(num3<num1&&num3<num2)
			System.out.println("가장 작은 수 : "+num3);
		
	}
	public void checkEven() {
		System.out.println("정수 입력 : ");
		num1 = sc.nextInt();
		if(num1%2==1)
			System.out.println("홀수");
		else
			System.out.println("짝수");
	}
	public void isPassFail() {
		System.out.println("평균이 60점 이상일 경우 합격");
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int mat = sc.nextInt();
		
		if((kor+eng+mat)/3 >=60)
			System.out.println("합격");
		else
			System.out.println("불합격");
	}
	public void scoreGrade() {
		
	}
	public void checkPlusMinusZero() {}
	public void whatCaracter() {}
	
}
