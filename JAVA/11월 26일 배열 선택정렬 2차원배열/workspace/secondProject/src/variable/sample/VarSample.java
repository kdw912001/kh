package variable.sample;

import java.util.*;
public class VarSample {
	public void testMethod1() {
		//1. 변수 선언
		// => 방 만들기
		//자료형 변수명;
		boolean flag; //1byte, true(참, 비트1), false(거짓, 비트0)
		byte bnum;   //1byte, 정수
		short snum;  //2byte, 정수
		int inum;      //4byte, 정수
		long lnum;   //8byte, 정수
		float fnum;   //4byte, 실수
		double dnum; //8byte, 실수
		char ch;	      //2byte, 문자하나
		
		//2, 변수방에 값 기록
		//변수명 = 값;
		
		flag = false;
		bnum = 127;
		snum = -32768;
		inum = 2147483647;
		lnum = 100L;
		fnum = 34.5f;
		dnum = 123.5;
		ch = 'A';
		
		//3. 변수의 사용 : 변수명 사용
		//변수방에 기록된 값을 읽어라.는 의미임
		
		System.out.println("flag : "+ flag);
		System.out.println("bnum : " + bnum);
		System.out.println("snum : "+ snum);
		System.out.println("inum : " + inum);
		System.out.println("lnum : " + lnum);
		System.out.println("fnum : "+ fnum);
		System.out.println("dnum : " + dnum);
		System.out.println("ch : " + ch);
	}
	
	public void testMethod2() {
		//변수의 초기화
		//자료형 변수명 = 초기값;
		boolean flag = true; //1byte, true(참, 비트1), false(거짓, 비트0)
		byte bnum = 12;   //1byte, 정수
		short snum = 230;  //2byte, 정수
		int inum = 345;      //4byte, 정수
		long lnum = 10L;   //8byte, 정수
		float fnum = 3.5f;   //4byte, 실수
		double dnum = 89.5; //8byte, 실수
		char ch = 'Y';	      //2byte, 문자하나
		
		//2, 변수방에 값 기록
		//변수명 = 값;
		
		
		
		//3. 변수의 사용 : 변수명 사용
		//변수방에 기록된 값을 읽어라.는 의미임
		
		System.out.println("flag : "+ flag);
		System.out.println("bnum : " + bnum);
		System.out.println("snum : "+ snum);
		System.out.println("inum : " + inum);
		System.out.println("lnum : " + lnum);
		System.out.println("fnum : "+ fnum);
		System.out.println("dnum : " + dnum);
		System.out.println("ch : " + ch);
	}
	
	public void example1() {
		//변수 연습문제1
		/*int a=23;
		int b =7;*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int a = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int b = sc.nextInt();
		
		System.out.println("첫번째 정수 : " + a);
		System.out.println("두번째 정수 : " + b);
		
		System.out.println("더하기 결과 : "+(a+b));
		System.out.println("빼기 결과 : "+ (a-b));
		System.out.println("곱하기 결과 : "+(a*b));
		System.out.println("나누기한 몫 : "+(a/b));
		System.out.println("나누기한 나머지 : "+ (a%b));
			    
	}
	
	public void example2() {
		//변수 연습문제2
		/*double a=13.5;
		double b=41.7;*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 : ");
		double a = sc.nextDouble();
		System.out.print("세로 : ");
		double b = sc.nextDouble();
		
		System.out.println("가로 : "+a);
		System.out.println("세로 : "+b);
		
		System.out.println("면적 : "+(a*b));
		System.out.println("둘레 : "+((a+b)*2));
		
	}
	
	public void testInput() {
		//클래스명 레퍼런스 변수 = new 생성자();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String name = sc.next();
		System.out.print("true/false 입력 : ");
		boolean flag = sc.nextBoolean();
		System.out.print("정수 입력 : ");
		int inum = sc.nextInt();
		System.out.print("실수 입력 :");
		double dnum = sc.nextDouble();
		System.out.print("찬성이면 Y/반대이면 N : ");
		/*String answer = sc.next(); //"Y", "N"
		char ans = answer.charAt(0);*/
		char ans = sc.next().charAt(0);
				
		System.out.println("name : "+name);
		System.out.println("flag : "+flag);
		System.out.println("inum : "+inum);
		System.out.println("dnum : "+dnum);
		System.out.println("투표결과 : " +ans);
		
	}


	public void inputProfile() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("성별 입력 남/여 : ");
		char sex = sc.next().charAt(0);
	    System.out.print("전화번호 입력 : ");
		String numb = sc.next();
		System.out.print("이메일 입력 : ");
		String email = sc.next();
		
		System.out.println("이름 : "+ name);
		System.out.println("나이 : "+ age);
		System.out.println("성별 : "+sex);
		System.out.println("전화번호 입력 : "+numb);
		System.out.println("이메일 입력 : "+email);
		
	}
}
