package loop.sample;

import java.util.Scanner;

public class BreakSample {
	//1~10까지 정수들의 합계 출력
	public void testBreak1() {
		int sum = 0;
		
		int k = 1;
		for( ; ; ) {
			if(k == 11)
				break;
			
			System.out.print(k + "+");
			sum += k++;
			//k++;
		}
		
		System.out.println(" = " + sum);
	}
	
	//문자열 입력받고, 문자 하나 입력받아서
	//문자열 안에 문자가 몇개 포함되어 있는지
	//카운트해서 출력
	//단, 영문자가 아니면 "영문자가 아닙니다."
	//카운트 중지함
	public void testBreak2() {
		Scanner sc = new Scanner(System.in);
		int count = 0, i;
		
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		System.out.print("찾을 문자 : ");
		char ch = sc.next().charAt(0);
		
		for(i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			//영문자인지 확인
			if(Character.isLowerCase(c) 
				|| Character.isUpperCase(c)) {
				//문자가 입력문자와 일치하는지 확인
				if(c == ch)
					count++;
			}else {
				//영문자가 아니면
				System.out.println("영문자가 아닙니다.");
				break;  //for 문을 끝내라.
			}
		} //for
		
		//문자열안의 문자 검사가 성공적으로
		//끝났을 때, 카운트값 출력
		if(i == str.length()) {
			System.out.println("포함된 " + ch + "문자의 갯수 : " + count);
		}
	}
	
	public void testBreak22() {
		Scanner sc = new Scanner(System.in);
		int count = 0, i = 0;
		
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		System.out.print("찾을 문자 : ");
		char ch = sc.next().charAt(0);
		
		while(i < str.length()) {
			char c = str.charAt(i++);
			//영문자인지 확인
			if(Character.isLowerCase(c) 
				|| Character.isUpperCase(c)) {
				//문자가 입력문자와 일치하는지 확인
				if(c == ch)
					count++;
			}else {
				//영문자가 아니면
				System.out.println("영문자가 아닙니다.");
				break;  //for 문을 끝내라.
			} //else close
			//i++;
		} //while close
		
		//문자열안의 문자 검사가 성공적으로
		//끝났을 때, 카운트값 출력
		if(i == str.length()) {
			System.out.println("포함된 " 
					+ ch + "문자의 갯수 : "
					+ count);
		}
	}
	
	public void testBreak23() {
		Scanner sc = new Scanner(System.in);
		int count = 0, i = 0;
		
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		System.out.print("찾을 문자 : ");
		char ch = sc.next().charAt(0);
		
		do {
			if(i == str.length())
				break;
			
			char c = str.charAt(i++);
			//영문자인지 확인
			if(Character.isLowerCase(c) 
				|| Character.isUpperCase(c)) {
				//문자가 입력문자와 일치하는지 확인
				if(c == ch)
					count++;
			}else {
				//영문자가 아니면
				System.out.println("영문자가 아닙니다.");
				break;  //for 문을 끝내라.
			} //else close
			//i++;
		}while(true);
		
		//문자열안의 문자 검사가 성공적으로
		//끝났을 때, 카운트값 출력
		if(i == str.length()) {
			System.out.println("포함된 " 
					+ ch + "문자의 갯수 : "
					+ count);
		}
	}
}









