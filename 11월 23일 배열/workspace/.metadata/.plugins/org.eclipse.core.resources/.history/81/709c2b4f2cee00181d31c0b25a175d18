package logic.home.view;
import logic.home.model.*;
import java.util.*;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	public static void mainMenu() {
		int no; //메뉴번호
		 // 종료 확인 문자 y/n
		do {
			System.out.printf("***** 프로그래밍 기본 기능 테스트 프로그램 *****\r\n" + 
					"\r\n" + 
					"		1. 변수 테스트\r\n" + 
					"		2. 기본 자료형 테스트\r\n" + 
					"		3. if문 테스트\r\n" + 
					"		4. switch문 테스트\r\n" + 
					"		5. for문 테스트\r\n" + 
					"		6. while문 테스트\r\n" + 
					"		7. do~while문 테스트\r\n" + 
					"		8. break문 테스트\r\n" + 
					"		9. continue문 테스트\r\n" + 
					"		10. static 메소드 사용 테스트\r\n" + 
					"		11. non-static 메소드 사용 테스트\r\n" + 
					"		12. 프로그램 종료\r\n" + 
					"		메뉴 번호 입력 : ");
			no = sc.nextInt();
			switch(no)
			{
			case 1: subVarMenu(); break;
			case 2: subPTypeMenu(); break;
			case 3: subIfMenu(); break;
			case 4: subSwitchMenu(); break;
			case 5: subForMenu(); break;
			case 6: subWhileMenu(); break;
			case 7: subDoWhileMenu(); break;
			case 8: subBreakMenu(); break;
			case 9: subContinueMenu(); break;
			case 10: subStaticMethodMenu(); break;
			case 11: subNonStaticMethodMenu(); break;
			case 12: 
				System.out.print("정말로 종료하시겠습니까? (예:y/아니오:n:) "); 
				char ch = sc.next().toUpperCase().charAt(0);
				if(ch =='Y') 
					break;
				else 
					mainMenu();
			default:System.out.println("잘못 입력하셨습니다. 다시 입력바랍니다.");
			}
							
				 //프로그램 종료
			/*case 1:	subVarMenu();	break;
			....... 이하 생략
			case 12: 프로그램 종료에 대한 처리함
			default: 잘못된 번호가 입력되었을 때 메뉴 다시 출력되게 함*/
						
		}while(true);
	}
	public static void subVarMenu() {
		int no;
		
		do {
			System.out.printf("*** 변수 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. 내 신상정보 변수에 담아 출력하기\r\n" + 
					"	2. 사원정보를 키보드로 입력받아 출력하기\r\n" + 
					"	3. 기본 자료형 변수의 초기값 확인하기\r\n" + 
					"	4. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no = sc.nextInt();
			VariableSample samp = new VariableSample();
			switch(no)
			{
			
			case 1:  samp.myProfile(); break;
			case 2: samp.emplnformation(); break;
			case 3: samp.defaultValue(); break;
			case 4: System.out.println("메인 메뉴로 돌아갑니다."); break;
			default:System.out.println("잘못 입력하셨습니다. 다시 입력바랍니다.");
			}
			/*switch(no)
			{
			case 1:	VariableSample 클래스의 myProfile() 실행; break;
			case 2:	VariableSample 클래스의 empInformation() 실행; break;
			case 3:	VariableSample 클래스의 defaultValue() 실행; break;
			case 4:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:	잘못된 값 입력시 메뉴 다시 출력되게 처리
			}*/
		}while(no!=4);
	}
	
	public static void subPTypeMenu(){
		 int no;
		 do {
			 System.out.printf("*** 기본자료형 테스트 부메뉴 ***\r\n" + 
			 		"\r\n" + 
			 		"	1. 기본자료형 메모리 할당크기 확인하기\r\n" + 
			 		"	2. 기본자료형 값의 최소값, 최대값 출력하기\r\n" + 
			 		"	3. 기본자료형 비트갯수 확인하기\r\n" + 
			 		"	4. 이전 메뉴로 가기\r\n" + 
			 		"	메뉴 선택 : ");
			 no=sc.nextInt();
			 PrimitiveTypeSample samp = new PrimitiveTypeSample();
			 switch(no)
				{
				case 1:	samp.typeSize(); break;
				case 2:	samp.minMaxValue(); break;
				case 3:	samp.bitSize(); break;
				case 4:	System.out.println("메인 메뉴로 돌아갑니다."); break;
				default:System.out.println("잘못 입력하셨습니다. 다시 입력바랍니다.");	
				}
		 }while(no!=4);
	}
	public static void subIfMenu(){
		int no;
		do {
			System.out.print("*** if문 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. 두 개의 정수를 입력받아, 두 수중 큰 값 출력하기\r\n" + 
					"	2. 두 개의 정수를 입력받아, 두 수중 작은 값 출력하기\r\n" + 
					"	3. 세 개의 정수를 입력받아, 세 수중 가장 큰수와 가장 작은수 출력하기\r\n" + 
					"	4. 한 개의 정수를 입력받아, 짝수인지 홀수인지 출력하기\r\n" + 
					"	5. 국,영,수 세 과목의 점수를 입력받아, 합격/불합격 확인하기\r\n" + 
					"	6. 점수를 입력받아, 학점 확인하기\r\n" + 
					"	7. 한 개의 정수를 입력받아, 양수인지 0인지 음수인지 확인하기\r\n" + 
					"	8. 문자 하나를 입력받아, 영어대문자인지 소문자인지 숫자문자인지 기타문자인지 확인하기\r\n" + 
					"	9. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no=sc.nextInt();
			IfSample samp = new IfSample();
			
			switch(no)
			{
			case 1:	samp.maxNumber(); break;
			case 2:	samp.minNumber(); break;
			case 3:	samp.ThreeMaxMin(); break;
			case 4:	samp.checkEven(); break;
			case 5:	samp.isPassFail(); break;
			case 6:	samp.scoreGrade(); break;
			case 7:	samp.checkPlusMinusZero(); break;
			case 8:	samp.whatCaracter(); break;
			case 9:	System.out.println("메인 메뉴로 돌아갑니다.");break;	//이전 메뉴로 되돌아감.
			default:System.out.println("잘못 입력하셨습니다. 다시 입력바랍니다.");
			}
			
		}while(no!=9);
	}
	public static void subSwitchMenu(){
		int no;
		do {
			System.out.printf("*** switch문 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. 두 개의 정수와 한 개의 연산문자를 입력받아 계산한 결과 확인하기\r\n" + 
					"	2. 과일이름을 문자열로 입력받아, 그 과일의 가격 출력하기\r\n" + 
					"	3. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no = sc.nextInt();
			SwitchSample samp = new SwitchSample();
			
			switch(no)
			{
			case 1:	samp.calculator(); break;
			case 2:	samp.fruitPrice(); break;
			case 3:	System.out.println("메인 메뉴로 돌아갑니다."); break;	//이전 메뉴로 되돌아감.
			default:System.out.println("잘못 입력하셨습니다. 다시 입력바랍니다.");
			}
		}while(no!=3);
				
	}
	public static void subForMenu(){
		int no;
		do {
			System.out.print("*** for문 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. 1~10까지 정수들의 합계 구하기\r\n" + 
					"	2. 1~100사이의 짝수들의 합게 구하기\r\n" + 
					"	3. 정수 하나 입력받아, 그 수의 구구단 출력하기\r\n" + 
					"	4. 두 개의 정수를 입력받아, 두 수중 작은 값에서 큰 값까지의 합계 구하기\r\n" + 
					"	5. 줄수와 칸수 입력받아, 입력된 줄수/칸수만큼 별표문자 출력하기\r\n" + 
					"	6. 7줄에 7칸에 별표문자 출력하되, 각 줄에 줄번호와 같은 칸에 숫자 출력하기\r\n" + 
					"	7. 줄수를 입력받아, 삼각형 모양으로 별표문자 출력하기(양수:직각삼각형, 음수:역삼각형)\r\n" + 
					"	8. 구구단 2단부터 9단까지 출력하기\r\n" + 
					"	9. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no = sc.nextInt();
			ForSample fsamp = new ForSample();
			switch(no){
			case 1:	fsamp.sum1To10(); break;
			case 2:	fsamp.sumEven1To100(); break;
			case 3:	fsamp.oneGugudan(); break;
			case 4:	fsamp.sumMinToMax(); break;
			case 5:	fsamp.printStar(); break;
			case 6:	fsamp.printNumberStar(); break;
			case 7:	fsamp.printTriangleStar(); break;
			case 8:	fsamp.guguDan(); break;
			case 9:	System.out.println("메인 메뉴로 돌아갑니다.");break;				
			default:System.out.println("잘못 입력하셨습니다. 다시 입력바랍니다.");
			}
		}while(no!=9);
	}
	public static void subWhileMenu(){
		int no;
		do {
			System.out.printf("*** while문 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. 문자 하나 입력받아, 그 문자의 유니코드 출력 반복('0' 입력되면 반복종료)\r\n" + 
					"	2. 1~100까지 정수들의 합계 출력하기(while 문으로 작성)\r\n" + 
					"	3. 1~100사이의 임의의 정수를 발생시켜, 숫자 알아맞추기\r\n" + 
					"	4. 문자열을 입력받아, 글자 갯수 알아내어 출력하기\r\n" + 
					"	5. 문자열값과 문자 하나를 입력받아, 문자열에 문자가 몇 개 있는지 확인하기\r\n" + 
					"	6. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no = sc.nextInt();
			WhileSample samp = new WhileSample();
			switch(no)
			{
			case 1:	samp.printUniCode(); break;
			case 2:	samp.sum1To100(); break;
			case 3:	samp.numberGame(); break;
			case 4:	samp.countCharacter(); break;
			case 5:	samp.countInChar(); break;
			case 6:	System.out.println("메인 메뉴로 돌아갑니다.");	break;
			default: System.out.println("잘못 입력하셨습니다. 부메뉴로 돌아갑니다.");
			}
		}while(no!=6);
	}
	public static void subDoWhileMenu(){
		int no;
		do {
			System.out.printf("*** do~while문 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. 문자열값 입력받아, 문자 사이에 '-' 끼워넣어 출력하기\r\n" + 
					"	2. 버거킹 메뉴 주문 테스트\r\n" + 
					"	3. 문자열 입력받아, \"모든 글자 영문자다\"/\"영문자 아니다.\" 출력하기\r\n" + 
					"	4. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no = sc.nextInt();
			DoWhileSample samp = new DoWhileSample();
			switch(no)
			{
			case 1:	samp.addDashToken(); break;
			case 2:	samp.burgerKingMenu(); break;
			case 3:	samp.isStringAlphabet(); break;
			case 4:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default: System.out.println("잘못 입력하셨습니다. 부메뉴로 돌아갑니다."); continue;
			}
			
		}while(no!=4);
		
	}
	public static void subBreakMenu(){
		int no;
		do {
			System.out.print("*** break문 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. 1~100까지 정수들의 합계 출력하기(break문 사용)\r\n" + 
					"	2. 구구단 1단~9단까지 출력하되, * 5 계산에서 반복문 빠지기(break 이름 사용)\r\n" + 
					"	3. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no = sc.nextInt();
			BreakSample samp = new BreakSample();
			
		
			switch(no)
			{
			case 1:	samp.sumBreak(); break;
			case 2:	samp.guguDanBreak(); break;
			case 3:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default: System.out.println("잘못 입력하셨습니다. 부메뉴로 돌아갑니다."); continue;
			}
		}while(no!=3);
	}
	public static void subContinueMenu(){
		int no;
		do {
			System.out.print("*** continue문 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. 1~100까지의 정수 중 3의 배수를 뺀 정수들의 합계 출력하기\r\n" + 
					"	2. 3행 5열의 행열값 출력하되, 1행 3열부터 1행 5열까지 생략하고 출력하기\r\n" + 
					"	3. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no=sc.nextInt();
			ContinueSample samp = new ContinueSample();
			switch(no)
			{
			case 1:	samp.sumJumpThree(); break;
			case 2:	samp.rowColJump(); break;
			case 3:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default: System.out.println("잘못 입력하셨습니다. 부메뉴로 돌아갑니다."); continue;
			}
		}while(no!=3);
	}
	public static void subStaticMethodMenu(){
		int no;
		do {
			System.out.print("*** static 메소드 사용 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. Math 클래스의 랜덤값 구하는 메소드 : 1~45사이의 임의의 정수 출력\r\n" + 
					"	2. Math 클래스의 실수값에 대한 절대값 구하는 메소드 : -12.77 절대값 출력하기\r\n" + 
					"	3. Math 클래스의 두 정수중 큰값 구하는 메소드 : 120, 54 중 큰값 출력하기\r\n" + 
					"	4. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no = sc.nextInt();
			StaticMethodSample samp = new StaticMethodSample();
			
			switch(no)
			{
			case 1:	samp.testMathRandom(); break;
			case 2:	samp.testMathAbs(); break;
			case 3:	samp.testMathMax(); break;
			case 4:	System.out.println("메인 메뉴로 돌아갑니다.");
				return;	//이전 메뉴로 되돌아감.
			default:System.out.println("잘못 입력하셨습니다. 부메뉴로 돌아갑니다."); continue;
			}
		}while(no!=4);
	}
	public static void subNonStaticMethodMenu(){
		int no;
		do {
			System.out.print("*** non-static 메소드 사용 테스트 부메뉴 ***\r\n" + 
					"\r\n" + 
					"	1. Scanner 클래스 사용 : 자료형 종류별로 값 입력받아 출력하기\r\n" + 
					"	2. Date 클래스 사용 : 오늘 날짜, 현재 시간 정보 출력하기\r\n" + 
					"	3. Random 클래스 사용 : 정수와 실수에 대한 난수 출력하기\r\n" + 
					"	4. 이전 메뉴로 가기\r\n" + 
					"	메뉴 선택 : ");
			no = sc.nextInt();
			NonStaticMethodSample samp = new NonStaticMethodSample();
			switch(no)
			{
			case 1: samp.testScanner(); break;
			case 2: samp.testDate(); break;
			case 3: samp.testRandom(); break;
			case 4: System.out.println("메인 메뉴로 돌아갑니다.");
			       return; //이전 메뉴로 되돌아감.
			default: System.out.println("잘못 입력하셨습니다. 부메뉴로 돌아갑니다."); continue;
			}
		}while(no!=4);
	}
}
