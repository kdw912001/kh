package loop.sample;

import java.util.Scanner;

public class ContinueSample {
	//1~100까지 정수들의 합을 구해서 출력
	//단, 3의 배수는 제외하고 계산함
	public void testContinue1() {
		int sum = 0;
		
		for(int k = 1; k < 101; k++) {
			if(k % 3 == 0)
				continue;  //아래의 내용은 실행하지 말고 증감식으로 가라.
			
			System.out.print(k + "+");
			sum += k;
		}
		
		System.out.println("\n1~100까지 "
				+ "3의 배수를 제외한 정수들의 합계 : "
				+ sum);
	}
	
	public void testContinue11() {
		int sum = 0;
		
		int k = 0;
		while(++k < 101) {
			if(k % 3 == 0)
				continue;  //아래의 내용은 실행하지 말고 증감식으로 가라.
			
			System.out.print(k + "+");
			sum += k;
		}
		
		System.out.println("\n1~100까지 "
				+ "3의 배수를 제외한 정수들의 합계 : "
				+ sum);
	}
	
	public void testContinue12() {
		int sum = 0;
		
		int k = 0;
		do {
			//++k;
			if(++k == 101)
				break;
			
			if(k % 3 == 0)
				continue;  //아래의 내용은 실행하지 말고 증감식으로 가라.
			
			System.out.print(k + "+");
			sum += k;
		//}while(k < 100);
		}while(true);
		
		System.out.println("\n1~100까지 "
				+ "3의 배수를 제외한 정수들의 합계 : "
				+ sum);
	}
	
	//구구단의 단수 입력받아
	//해당 단의 구구단 출력
	//제외할 곱하기 수를 입력받아
	//제외하고 출력 처리
	//단수 : 3
	//제외할 곱하기 수 : 5
	//제외할 항목 : 3 * 5 = 15
	public void testContinue2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단수 : ");
		int dan = sc.nextInt();
		System.out.print("제외할 곱하기 수 : ");
		int su = sc.nextInt();
		
		for(int k = 1; k < 10; k++) {
			if(k == su)
				continue;
			
			System.out.println(dan + " * " 
				+ k + " = " + (dan * k));
		}
	}
}






