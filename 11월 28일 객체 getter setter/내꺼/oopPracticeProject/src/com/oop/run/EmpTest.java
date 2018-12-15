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
			System.out.print("******* ��� ���� ���� ���α׷� ************\r\n" + 
					"\r\n" + 
					"	1. �� ��� ���� �Է�  => empInput() �޼ҵ� ����\r\n" + 
					"	2. ��� ���� ���� => �θ޴� ��Ÿ��\r\n" + 
					"	3. ��� ���� ����\r\n" + 
					"	4. ������� ��� =>  empOutput() �޼ҵ� ����\r\n" + 
					"	9. ������ \n �޴� ���� : ");
			Scanner sc = new Scanner(System.in);
			no=sc.nextInt();
			
			switch(no) {
			case 1: emp.empIntput(); break;
			case 2: modifyMenu(emp); break;
			case 3: emp.delete(); break;
			case 4: emp.empOutput(); break;
			case 9: System.out.println("����Ǿ����ϴ�.");return;
			default: System.out.println("�߸��Է��ϼ̽��ϴ�."); 
			}
		}while(no!=9);
	}
	public static void modifyMenu(Employee e) {
		int no;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.print("**** ��� ���� ���� �޴� *****\r\n" + 
					"	1. �̸� ���� => setEmpName()\r\n" + 
					"	2. �޿� ���� => setSalary()\r\n" + 
					"	3. �μ� ���� => setDept()\r\n" + 
					"	4. ���� ���� => setJob()\r\n" + 
					"	5. ���� �޴��� �̵�  \n �޴� ���� : ");
			no = new Scanner(System.in).nextInt();
			switch(no) {
			case 1: System.out.print("������ �̸� : ");
					String newName= sc.next();
					e.setEmpName(newName); break;
			case 2: System.out.print("������ �޿� : ");
					int newSalary = sc.nextInt();
					e.setSalary(newSalary);
					break;
			case 3: System.out.print("������ �μ� : ");
					String newDept = sc.next();
					e.setDept(newDept); 
					break;
			case 4: System.out.print("������ ���� : ");
					String newJob = sc.next();
					e.setJob(newJob);
					break;
			case 5:return;
			}
		}while(no!=5);
	}

}
