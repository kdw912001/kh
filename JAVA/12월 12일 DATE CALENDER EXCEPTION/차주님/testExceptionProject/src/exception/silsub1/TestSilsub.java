package exception.silsub1;

import java.util.Scanner;

import exception.silsub2.NumberProcess;
import exception.silsub2.NumberRangeException;

public class TestSilsub {

	public static void main(String[] args) {
		// 예외처리 실습문제 테스트
		TestSilsub test = new TestSilsub();
		test.silsub1();
		//test.silsub2();
	}
	
	//실습문제 1
	public void silsub1(){
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("문자열 입력 : ");
			int count = new CharacterProcess().countAlpha(sc.nextLine());
			System.out.println("포함된 알파벳 문자 갯수 : " + count);
		} catch (CharCheckException e) {
			System.out.println(e.getMessage());
		}
	}

	//실습문제 2
	public void silsub2(){
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 : ");
		int first = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int second = sc.nextInt();
		
		try {
			if(new NumberProcess().checkDouble(first, second))
				System.out.println(first + "는 " + second + "의 배수이다.");
			else
				System.out.println(first + "는 " + second + "의 배수가 아니다.");
		} catch (NumberRangeException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
