package logic.home.model;

import java.util.Scanner;

public class IfSample {
	private Scanner sc = new Scanner(System.in);
	int num1,num2,num3;
	public void maxNumber(){
		System.out.println("�� ���� ū �� ����ϱ�");
		System.out.print("���� �ϳ� �Է� : ");
		num1 = sc.nextInt();
		System.out.print("�ٸ� ���� �Է� : ");
		num2 = sc.nextInt();
		if(num1>num2)
			System.out.println("�� �� �� ū �� : "+num1);
		else if(num1<num2)
			System.out.println("�� �� �� ū �� : "+num2);
		else
			System.out.println("���� ���� �Է��ϼ̽��ϴ�.");
		
	}
	public void minNumber() {
		System.out.println("�� ���� ���� �� ����ϱ�");
		System.out.print("���� �ϳ� �Է� : ");
		num1 = sc.nextInt();
		System.out.print("�ٸ� ���� �Է� : ");
		num2 = sc.nextInt();
		
		if(num1<num2)
			System.out.println("�� �� �� ���� �� : "+num1);
		else if(num1>num2)
			System.out.println("�� �� �� ���� �� : "+num2);
		else
			System.out.println("���� ���� �Է��ϼ̽��ϴ�.");
		
	}
	public void ThreeMaxMin() {
		System.out.println("�� ���� ���� ū ���� ���� ���� �� ����ϱ�");
		
		System.out.print("ù��° ���� �Է� : ");
		num1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		num2 = sc.nextInt();
		System.out.print("����° ���� �Է� : ");
		num3 = sc.nextInt();
		if(num1>num2&&num1>num3)
			System.out.println("���� ū ��: "+num1);
		if(num2>num1&&num2>num3)
			System.out.println("���� ū �� : "+num2);
		if(num3>num1&&num3>num2)
			System.out.println("���� ū �� : "+num3);
		if(num1<num2&&num1<num3)
			System.out.println("���� ���� ��: "+num1);
		if(num2<num1&&num2<num3)
			System.out.println("���� ���� �� : "+num2);
		if(num3<num1&&num3<num2)
			System.out.println("���� ���� �� : "+num3);
		
	}
	public void checkEven() {
		System.out.println("���� �Է� : ");
		num1 = sc.nextInt();
		if(num1%2==1)
			System.out.println("Ȧ��");
		else
			System.out.println("¦��");
	}
	public void isPassFail() {
		System.out.println("����� 60�� �̻��� ��� �հ�");
		System.out.print("���� ���� �Է� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int eng = sc.nextInt();
		System.out.print("���� ���� �Է� : ");
		int mat = sc.nextInt();
		
		if((kor+eng+mat)/3 >=60)
			System.out.println("�հ�");
		else
			System.out.println("���հ�");
	}
	public void scoreGrade() {
		
	}
	public void checkPlusMinusZero() {}
	public void whatCaracter() {}
	
}
