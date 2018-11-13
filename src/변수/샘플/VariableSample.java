package 변수.샘플;
import java.util.*;

public class VariableSample {
	
	public void varMethod1() { 

		//지역변수 선언시 사용할 수 있는 예약어
		//final 하나임.
		final double pi = 3.14159;
		//변수방에 기록된 초기값 변경 불가능
		
		System.out.println("pi : " + pi);
		//pi = 56.789; //error
		
		
	}
	
	public void varMethod2() {
		//1.변수 선언, 초기화 가능함
			
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		char gender;
		double score;
		
		//2. 변수공간에 값 기록 처리
		//키보드로 입력받은 값 기록 처리
		System.out.print("이름 입력 : ");
		name = sc.nextLine();   //nextLine() : 공백도 입력 가능 
									   //next() : 공백 입력 불가
		System.out.print("나이 입력 : ");
		age = sc.nextInt();
		System.out.print("성별 입력(남/여) :");
		gender = sc.next().charAt(0);    //입력 시 글자 뒤에 입력해면 정상 출력 됨. 
												// 글자 앞에 입력될 시에 오류날 확률 있음.
		System.out.print("성적 입력(소수점 아래 첫째자리까지 :");
		score = sc.nextDouble();
		
		//3. 변수에 기록된 값 계산처리
		
		//4. 결과에 대한 처리 : 화면(콘솔) 출력
		System.out.println(name + ", "+age +"세,"+gender+"자, "+score+"점");
		
	}
	
	public void varPractice() {
		//변수 연습문제
		//원의 반지름(double) 값을 입력 받아
		//원의 면적과 둘레를 출력 처리
		//면적 = 원주율*반지름*반지름
		//둘레 = 2*원주율*반지름
		
		final double PI = Math.PI;   //public static이 붙은 클래스는 
										//new선언 할 필요없이 바로 사용가능
		//System.out.println("원주율 : "+PI);
		//Scanner sc=new Scanner(System.in);
		System.out.print("원의 반지름 입력 : ");
		//double r = sc.nextDouble();
		double r = new Scanner(System.in).nextDouble();
		
		double a = PI*r*r; //면적
		double b = 2*PI*r; //둘레
		
		System.out.println("원의 면적 : "+a);
		System.out.println("원의 둘레 : "+b);
		
		System.out.printf("면적 : %g\n",a);
		System.out.printf("둘레 :%A\n",b);
		
		System.out.printf("면적 : %.3f\n", a);
		System.out.printf("둘레 : |%-10.2f| \n", b);
	}
	
	public void testFormat() {
		int num = 100;
		System.out.printf("num : %d, %o, %x\n", num, num, num); //정수 16진수 8진수
		
		String str = "java";
		System.out.printf("str : %s\n" , str);
		
		char ch = 'A';
		System.out.printf("ch : %c, %d\n", ch, (int)ch);
		
	}
}
