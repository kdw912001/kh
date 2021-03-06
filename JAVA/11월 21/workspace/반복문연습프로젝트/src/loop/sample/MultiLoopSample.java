package loop.sample;

import java.util.Scanner;

public class MultiLoopSample {
	//A,B,C,D ... 영어대문자를 한글자씩 출력
	//반복실행 : 5번
	//단, E가 되면 끝남
	public void testDoubleFor1() {
		OUT:for(int k = 1; k<=5; k++) {
			for(int c = 65; c<91; c++) {
				if(c==69)
					//break;
					break OUT;
				System.out.print((char)c+ ", ");
			}
			System.out.println();
			System.out.println("안쪽 for문 빠져나옴...");
		}//바깥 for
		
		System.out.println("바깥 for문 빠져나옴...");
	}
	
	public void testDoubleFor2() {
		for(int n=1; n<=5; n++) {
					
			for(int k = 1; k<=10;k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public void testDoubleFor3() {
		for(int a=1;a<=5;a++) {
			for(int b= 1; b<=5; b++) {
				System.out.println(a+ ", "+b);
			}
			System.out.println("----------------");
		}
	}
	
	//구구단 2~9단까지 출력처리
	public void testDoubleFor4() {
		for(int i=2;i<=9;i++) {
			System.out.println(i+"단");
			for(int j=1;j<=9;j++) {
			System.out.println(i+"*"+j+"="+(i*j));
			}
			System.out.println("--------------");
		}
	}
	
	//구구단 2~9단까지 출력처리
	//단, 홀수단은 제외함
		public void testDoubleFor44() {
			for(int i=2;i<=9;i++) { //i+=2
				if( i%2==1)
					continue;
				
				System.out.println(i+"단");
				for(int j=1;j<=9;j++) {
				System.out.println(i+"*"+j+"="+(i*j));
				}
				System.out.println("--------------");
			}
			
		}
		
		public void printStar1() {
			System.out.print("정수 하나 입력 : ");
			int num = new Scanner(System.in).nextInt();
			if(num>0) { //강사님이랑 다르게 함 강사님 코드 참고
				for(int i=1;i<=num;i++) {
					for(int j=1;j<i;j++) {
						System.out.print("*");
					}
					System.out.println(i);
				}
			}
			else
				System.out.println("양수가 아닙니다.");
		}
		
		public void printStar2() {
			System.out.print("정수 입력 : ");
			int num = new Scanner(System.in).nextInt();
			if(num>0) {	//i->row ,j->line
				for(int i=1;i<=num;i++) {
					for(int j=1;j<=i;j++) {
						System.out.print("*");
					}
					System.out.println("");
				}
			}
			else if(num<0) {
				num=-num;
				for(int i=0;i<num;i++) {
					for(int j=0;j<num;j++) {
						if(i>j)
							System.out.print(" ");
						
						else
							System.out.print("*");
					}
					System.out.println();
				}
			}
			else
				System.out.println("출력 기능이 없습니다.");
		}

		/*12345
		 * 12345
		 * 12345
		 * 12345
		 * 12345
		 */
		public void printMultiNumber1() {
			for(int i=1; i<=5; i++) {
				for(int j=1;j<=5;j++) {
					System.out.print(j);
				}
				System.out.println();
			}	
		}
		/* 12345
		 * 23456
		 * 34567
		 * 45678
		 * 56789
		 */
		public void printMultiNumber2() {
			for(int i=1;i<=5;i++) {
				for(int j=i;j<i+5;j++) {
					System.out.print(j);
				}
				System.out.println();
			}
		}

}
