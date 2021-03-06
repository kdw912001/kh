package logic.home.model;

import java.util.Scanner;

public class SwitchSample {
	private Scanner sc = new Scanner(System.in);
	public void calculator() {
		System.out.print("정수 입력 : ");
		int num1=sc.nextInt();
		System.out.print("다른 정수 입력 : ");
		int num2=sc.nextInt();
		System.out.print("연산할 계산기호를 입력 : ");
		char ch = sc.next().charAt(0);
		int result = 0;
		switch(ch) {
		case '+': System.out.println(num1+""+ch+""+num2+"="+(num1+num2)); break;
		case '-': System.out.println(num1+""+ch+""+num2+"="+(num1-num2)); break;
		case '*': System.out.println(num1+""+ch+""+num2+"="+(num1*num2)); break;
		case '/': 
			if(num2==0) {
				System.out.println("부모에 0을 넣을 수 없습니다.");
				break;
			}
			else
				System.out.println(num1+""+ch+""+num2+"="+(num1/num2));; break;
		case '%':
			if(num2==0) {
				System.out.println("부모에 0을 넣을 수 없습니다.");
				break;
			}
			else System.out.println(num1+""+ch+""+num2+"="+(num1%num2));; break;
		default: System.out.println("사칙연산과 나머지 계산만 입력해주세요.");
				
		}
	}
	public void fruitPrice() {
		System.out.print("사과,감,귤,딸기,배 중에 선택");
		String fruit = new Scanner(System.in).next();
		switch(fruit) {
		case "사과": System.out.println("선택한 과일 : "+fruit+"가격 : 500원"); break;
		case "감": System.out.println("선택한 과일 : "+fruit+"가격 : 600원"); break;
		case "귤": System.out.println("선택한 과일 : "+fruit+"가격 : 700원"); break;
		case "딸기": System.out.println("선택한 과일 : "+fruit+"가격 : 800원"); break;
		case "배": System.out.println("선택한 과일 : "+fruit+"가격 : 900원"); break;
		default : System.out.println("사과,감,귤,딸기,배 중에 선택해야합니다.");
		}
		
	}
	
}
