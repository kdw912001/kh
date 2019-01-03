package silsub.sample;
import java.util.Scanner;

public class Munjae {
	private Scanner sc = new Scanner(System.in);
	
	public void test1() {
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int math = sc.nextInt();
		int sum = kor+eng+math;
		double avg = (int)((sum/3)*100)/100.0;
		if(kor>=40&&eng>=40&&math>=40&&avg>=60) 
			System.out.println("합격");
		else
			System.out.println("불합격");
			
	}
	public void test2() {
		System.out.print("*** 초기 메뉴 ***\r\n" + 
				"		1. 입력\r\n" + 
				"		2. 수정\r\n" + 
				"		3. 조회\r\n" + 
				"		4. 삭제\r\n" + 
				"		7. 종료\r\n" + 
				"		메뉴번호 입력 :");
		int no = sc.nextInt();
		
		switch(no) {
		case 1: System.out.println("입력메뉴가 선택되었습니다."); break;
		case 2: System.out.println("수정메뉴가 선택되었습니다.");break;
		case 3: System.out.println("조회메뉴가 선택되었습니다.");break;
		case 4: System.out.println("삭제메뉴가 선택되었습니다.");break;
		case 7: System.out.println("프로그램이 종료되었습니다.");break;
		default : System.out.println("번호가 잘못 입력되었습니다.");
		           System.out.println("다시 입력하십시오.");
		           test2();
		           break;
		}
	}
	
	public void test3() {
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		if(num>0)
			System.out.println("양수다");
		else
			System.out.println("음수다");
	}
	
	public void test4() {
		System.out.print("정수 하나 입력: ");
		int num = sc.nextInt();
		String str = "";
		if(num>0) {
			if(num%2==0) {
				str = "짝수다";
			}
			else
				str = "홀수다";
		}
		System.out.println(str);
	}
	
	public void inputTest() {
		String name = sc.nextLine(); // 공백 입력 가능
		int age = sc.nextInt();
		double height = (int)(sc.nextDouble()*10)/10.0;
		if(name!=null && name.length()>0 && age>0 && height>0) {
			System.out.println("이름 : "+name);
			System.out.println("나이 : "+age);
			System.out.println("키 : "+height);
			System.out.println("확인 : "+name+"의 나이는 "+age+"세이고,"+"키는 "+height+" cm 이다.");
		}
	}
	
	public void test6() {
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		if(num1>0 && num2>0) {
			System.out.println(num1+" + "+num2+" = "+(num1+num2));
			System.out.println(num1+" - "+num2+" = "+(num1-num2));
			System.out.println(num1+" * "+num2+" = "+(num1*num2));
			System.out.println(num1+" / "+num2+" = "+(num1/num2));
			System.out.println(num1+" % "+num2+" = "+(num1%num2));
		}
	}
	
	public void test7() {
		System.out.print("점수 입력 : ");
		int score = sc.nextInt(); 
		char grade = ' ';
		if(score>=0) {
			if(score>=90)
				grade = 'A';
			else if(score>=80)
				grade = 'B';
			else if(score>=70)
				grade = 'C';
			else if(score>=60)
				grade = 'D';
			else
				grade = 'F';
		}	
		System.out.println("점수 : "+score);
		System.out.println("학점 : "+grade);
	}
}
