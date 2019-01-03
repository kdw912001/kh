package loop.sample;

import java.util.Scanner;

public class ForSample {
	public void testFor1() {
		//1부터 100까지 정수들의 합계
		//더하기가 100번 연산이 되어야 함
		int sum = 0;
		for(int su = 1; su <= 100; su++) {
			System.out.print(su + "+");
			sum += su;
		} //for
		
		System.out.println();
		System.out.println("더하기결과 : " + sum);
	}
	
	//정수 두 개를 입력받아
	//두수중 작은값에서 큰값까지의 정수들의 합
	//을 구해서 출력
	public void testFor2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int first = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int second = sc.nextInt();
		
		int max, min;
		if(first > second) {
			max = first;
			min = second;
		}else {
			max = second;
			min = first;
		}
		
		int sum = 0;
		for(int k = min; k <= max; k++) {
			System.out.print(k + "+");
			sum += k;
		}
		
		System.out.println();
		System.out.println(min + "~" + max
				+ "까지의 합계 : " + sum);
	}
	
	//1~100 사이의 난수 발생시킴
	//1부터 난수까지의 합계를 구하여 출력
	public void testFor3() {
		int limit = (int)(Math.random() * 100) + 1;
		System.out.println("종료값 : " + limit);
		
		int sum = 0;		
		for(int su = 1; su <= limit; su++) {
			if(su == limit)
				System.out.print(su);
			else
				System.out.print(su + "+");
			
			sum += su;
		}
		
		System.out.println("\n합계 : " + sum);
		
	}
	
	//구구단의 단수를 입력받아
	//해당 구구단을 출력
	public void testFor4() {
		System.out.print("단수 : ");
		int dan = new Scanner(System.in).nextInt();
		
		for(int su = 1; su <= 9; su++) {
			System.out.println(dan + " * "
				+ su + " = " + (dan * su));
		}
	}
}








