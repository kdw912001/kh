package com.oop.run;

import java.util.Scanner;

import com.oop.model.dto.Employee;

public class EmpTest {
	
	public static void main(String[] args) {
		mainMenu();
	}
	public static void mainMenu() {
		int no;
		Employee emp= new Employee();
		do {
			System.out.print("******* 사원 정보 관리 프로그램 ************\r\n" + 
					"\r\n" + 
					"	1. 새 사원 정보 입력  => empInput() 메소드 실행\r\n" + 
					"	2. 사원 정보 수정 => 부메뉴 나타남\r\n" + 
					"	3. 사원 정보 삭제\r\n" + 
					"	4. 사원정보 출력 =>  empOutput() 메소드 실행\r\n" + 
					"	9. 끝내기 \n 메뉴 선택 : ");
			Scanner sc = new Scanner(System.in);
			no=sc.nextInt();
			
			switch(no) {
			case 1: emp.empIntput(); break;
			case 2: modifyMenu(emp); break;
			case 3: emp.delete(); break;
			case 4: emp.empOutput(); break;
			case 9: System.out.println("종료되었습니다.");return;
			default: System.out.println("잘못입력하셨습니다."); 
			}
		}while(no!=9);
	}
	public static void modifyMenu(Employee e) {
		int no;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.print("**** 사원 정보 수정 메뉴 *****\r\n" + 
					"	1. 이름 변경 => setEmpName()\r\n" + 
					"	2. 급여 변경 => setSalary()\r\n" + 
					"	3. 부서 변경 => setDept()\r\n" + 
					"	4. 직급 변경 => setJob()\r\n" + 
					"	5. 이전 메뉴로 이동  \n 메뉴 선택 : ");
			no = new Scanner(System.in).nextInt();
			switch(no) {
			case 1: System.out.print("변경할 이름 : ");
					String newName= sc.next();
					e.setEmpName(newName); break;
			case 2: System.out.print("변경할 급여 : ");
					int newSalary = sc.nextInt();
					e.setSalary(newSalary);
					break;
			case 3: System.out.print("변경할 부서 : ");
					String newDept = sc.next();
					e.setDept(newDept); 
					break;
			case 4: System.out.print("변경할 직급 : ");
					String newJob = sc.next();
					e.setJob(newJob);
					break;
			case 5:return;
			}
		}while(no!=5);
	}

}
