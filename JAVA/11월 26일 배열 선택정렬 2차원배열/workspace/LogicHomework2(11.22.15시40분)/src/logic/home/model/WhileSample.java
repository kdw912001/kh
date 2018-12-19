package logic.home.model;

import java.util.Scanner;

public class WhileSample {
	private Scanner sc = new Scanner(System.in);
	
	public void printUniCode() {
		char ch=' ';
		while(ch!='0') {
			System.out.print("문자 하나 입력 : ");
			ch = sc.next().charAt(0);
			System.out.println(ch+"의 유니코드"+(int)ch);
		}
		
	}
	public void sum1To100() {
		int no = 0;
		int sum =0;
		while(no<101) {
			sum+=no++;
					
		}
		System.out.println("1~100까지 정수들의 합 : "+sum);
	}
	public void numberGame() {
		int rnum = (int)(Math.random()*100)+1; 
		int num=0;
		while(rnum!=num) {
			System.out.print("1~100사이 정수 중 숫자를 맞춰 보세요. 정수 입력 : ");
			num=sc.nextInt();
			if(rnum<num) 
				System.out.println(num+"보다 작습니다.");
			else if(rnum>num)
				System.out.println(num+"보다 큽니다.");
			
		}
		System.out.println("정답입니다.");
		
	}
	public void countCharacter() {
		String str="";
		int count = 0;
		
		while(!str.equals("exit")) {
			System.out.print("문자열을 입력(exit 입력시 종료) : ");
			str = sc.next();
			System.out.println("글자 갯수 : "+str.length());
						
		}
		
	}
	public void countInChar() {
		String str="";
		char ch=' ';
		int count=0;
		while(!str.equals("exit")) {
			System.out.print("문자열 입력 : ");
			str = sc.next();
			System.out.print("문자 입력 : ");
			ch = sc.next().charAt(0);
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)==ch)
					count++;
			}
			System.out.println(str+"문자열 내에 "+ch+"갯수 : "+count);
			
			System.out.print("exit 입력 시 종료  (종료하지 않으면 반복됩니다): ");
			str=sc.next();
		}
	}
}
