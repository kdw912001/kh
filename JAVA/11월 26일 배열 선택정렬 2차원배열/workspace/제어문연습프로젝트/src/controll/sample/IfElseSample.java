package controll.sample;

import java.util.Scanner;

public class IfElseSample {
	//Field
	private Scanner sc = new Scanner(System.in);
		
	//if~else 문 사용 연습
	/*키보드로 정수 두 개를 각각 입력받아서
	 * 첫번째 정수가 두번째 정수의 배수인지
	 * 확인하고, 맞으면 '배수다'출력
	 * 아니면 '배수가 아니다' 출력되게 작성
	 * */
	public void testIfElse1() {
		System.out.print("첫번쨰 정수 입력 : ");
		int first = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int second = sc.nextInt();
		if(first%second==0) 
			System.out.println("배수다");
		else
			System.out.println("배수가 아니다");
	}
	/* 첫번째 정수가 반드시 두번째 정수보다 
	 * 큰값인지 확인하고 맞으면
	 * 첫번째 정수가 두번째 정수의 배수인지 
	 * 확인하고 맞으면 '배수다' 출력하고
	 * 아니면 ' 배수가 아니다'
	 * 출력되게 작성
	 * 두번쨰 정수가 크면 아무것도 출력하지 않음
	 * 
	 */
	public void testIfElse2() {
		System.out.print("첫번째 정수 입력 : ");
		int first = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int second = sc.nextInt();
		if(first>second) {
			if(first%second==0)
				System.out.println("배수다");
			else
				System.out.println("배수가 아니다");
		}
	
	}
	/* 첫번째 정수가 반드시 두번째 정수보다 큰값
	 * 두 수 모두 양수
	 * 
	 * 
	 */
	public void testIfElse3() {
		System.out.print("첫번째 정수 입력 : ");
		int first = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int second = sc.nextInt();
		/*if(first>0 && second>0) {
			if(first>second) {
				if(first%second==0)
					System.out.println("배수다");
				else
					System.out.println("배수가 아니다");
			}
		}*/
		if(first > 0 && second > 0 && first > second) {
			if(first % second == 0)
				System.out.println("배수다");
			else 
				System.out.println("배수가 아니다");
		}
	}
	
	
}
