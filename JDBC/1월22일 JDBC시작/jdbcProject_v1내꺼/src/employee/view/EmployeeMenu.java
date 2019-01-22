package employee.view;

import java.util.Scanner;

import employee.controller.EmployeeController;

public class EmployeeMenu {
	//의존성 주입 (Dependancy Injection : DI)
	//다른 클래스의 기능을 사용하기 위해 
	//필드로 클래스 레퍼런스 선언과 객체 생성을 하는 것
	private Scanner sc = new Scanner(System.in);
	private EmployeeController econtroll = new EmployeeController();
	
	public EmployeeMenu() {}
	
	public void displayMenu() {
		int no;
		do {
			System.out.println("---------------------------");
			System.out.println("\n*** 직원 정보 관리 프로그램 ***");
			System.out.println();
			System.out.println("1. 전체 직원 조회");
			System.out.println("2. 사번으로 직원 한 사람 조회");
			System.out.println("3. 직급별로 조회");
			System.out.println("4. 부서별로 조회");
			System.out.println("5. 새 직원 등록");
			System.out.println("6. 직원 전화번호 수정");
			System.out.println("7. 직원 보너스포인트 수정");
			System.out.println("8. 사번으로 직원 삭제");
			System.out.println("9. 끝내기");
			System.out.print("번호 선택 : ");
			no = sc.nextInt();
			
			switch(no) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
			case 7: break;
			case 8: break;
			case 9: System.out.print("\n종료(y),취소(n) : ");
					if(sc.next().toUpperCase().charAt(0) == 'Y')
						return;
					else
						break;
			default : 	System.out.println("없는 번호입니다.");
						System.out.println("다시 입력하세요. \n");
			}
			
		}while(true);
	}
}
