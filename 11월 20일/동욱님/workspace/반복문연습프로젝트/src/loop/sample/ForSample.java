package loop.sample;

import java.util.Random;
import java.util.Scanner;

public class ForSample {
	public void forTest1() {
		//1부터 100까지 정수들의 합계
		//더하기가 100번 연산이 되어야 함.
		int sum = 0; //더하기 누적이면 0으로 초기화
						//곱하기 누적이면 1로 초기화
		for(int su = 1; su<=100; su++ ) {
			System.out.print(su + "+");
			sum += su;
		}//for
		System.out.println();
		System.out.println("더하기 결과 : " +sum);
	}
	
	
	//정수 두 개를 입력받아 
	//두 수 중 작은값에서 큰값까지의 정수들의 합
	//을 구해서 출력
	public void testFor2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int first = sc.nextInt();
		System.out.print("다른 정수 입력 : ");
		int second = sc.nextInt();
		int sum = 0;
		/*if(first<second) {
				for(int i = first; i<=second;i++) {
					sum+=i;
				}
		}
		else if(first>second) {
			for(int i=second; i<=first;i++) {
				sum+=i;
			}
		}
		else
			sum=first; // 입력한 두 수가 같습니다.
			
		
*/		
		int max, min;
		if(first > second) {
			max = first;
			min = second;
		}
		else {
			max = second;
			min = first;
		}
		
		
		for(int k = min; k<=max; k++) {
			System.out.print(k + "+");
			sum +=k;
		}
		System.out.println();
		System.out.println(min + "~"+max+"까지의 합계 : "+sum);
				
	}
	
	//1~100 사이의 난수 발생시킴
	//1부터 난수까지의 합계를 구하여 출력
	public void testFor3() {
		int rnum = (int)(Math.random()*100)+1;
		System.out.println("종료값 : "+rnum);
		
		int sum = 0;
		
		for(int i=1; i<=rnum; i++) {
			if(i == rnum) //마지막에 +가 출력되지 않기 위해 작성
				System.out.println(i);
			else
				System.out.print(i+"+");
			sum+=i;
		}
		System.out.println();
		System.out.println("1~"+rnum+"까지의 합 : "+sum);
	}
	
	
	//구구단의 단수를 입력받아
	//해당 구구단을 출력
	public void testFor4() {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		for(int i=1;i<=9;i++) {
			System.out.println(num1 + "x" + i + " = " + num1*i);
		}
	}
}
