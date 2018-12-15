package exception.silsub1;

import java.util.Scanner;

import exception.silsub2.NumberProcess;
import exception.silsub2.NumberRangeException;

public class TestSilsub {

	public static void main(String[] args) {
		TestSilsub test = new TestSilsub();
		test.silsub1();
		//test.silsub2();
		
	}
	public void silsub1() {
		Scanner sc = new Scanner(System.in);
		//CharacterProcess cp = new CharacterProcess();
		
		try {
			System.out.print("문자열을 입력 : ");
			int count = new CharacterProcess().countAlpha(sc.nextLine());
			System.out.println("포함된 알파벳 문자 갯수 : " +count);
			//System.out.println(cp.countAlpha(sc.nextLine()));
			//공백문자 엔터 체크하려면 nextLine()
		} catch (CharCheckException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void silsub2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int a = sc.nextInt();
		System.out.print("두번쨰 정수 입력 : "); 
		int b = sc.nextInt();
		//NumberProcess np = new NumberProcess();
		try {
			if(new NumberProcess().checkDouble(a, b))
				System.out.println(a+"는 "+b+"의 배수이다.");
			else
				System.out.println(a+"는 "+b+"의 배수가 아니다");
		} catch (NumberRangeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
