package loop.sample;

import java.util.Scanner;

public class ContinueSample {
	//1~100까지 정수들의 합을 구해서 출력
	//단, 3의 배수는 제외하고 계산
	public void testContinue1() {
		int sum = 0;
		
		for(int k = 1; k<101; k++) {
			if(k%3==0)
				continue; //아래의 내용은 실행하지 말고 증감식으로 가라.
			
			System.out.print(k+"+");
			sum +=k;
			
		}
		System.out.println();
		System.out.println("1~100까지 3의 배수를 제외한 정수들의 합계 : "+sum);
	}
	
	public void testContinue11() {
		int sum = 0;
		
		int k=0;
		while(++k<101) {  //continue를 하면 바로 조건식으로 가기 때문에 k증감식 위치 변경
			if(k%3==0)
				continue;
			System.out.print(k+"+");
			sum +=k;
		}
		System.out.println();
		System.out.println("1~100까지 3의 배수를 제외한 정수들의 합계 : "+sum);
	}
	
	public void testContinue12() {
		int sum = 0;
		
		int k=0;
		do {
			//++k;
			if(++k == 101) //100이 되면 멈춤
				break;
			if(k%3==0)
				continue;
			System.out.print(k+"+");
			sum +=k;
		//}while(k<100);
		}while(true);
		
		System.out.println();
		System.out.println("1~100까지 3의 배수를 제외한 정수들의 합계 : "+sum);
	}
	
	//구구단의 단수 입력받아
	//해당 단의 구구단 출력
	//제외할곱하기 수를 입력받아
	//제외하고 출력
	//단수 : 3
	//제외할 곱하기 수 : 5
	//제외할 항목 : 3 * 5 =15
	public void testContinue2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("단수 입력 : "); 
		int num = sc.nextInt();
		System.out.print("제외할 곱하기 수 : ");
		int num2 = sc.nextInt();
		
		for(int i=1; i<=9;i++) {
			if(i==num2)
				continue;
			System.out.println(num+"*"+i+"="+(num*i));
				
		}
	}
}
