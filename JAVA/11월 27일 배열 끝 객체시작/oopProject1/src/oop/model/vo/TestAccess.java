package oop.model.vo;

import java.util.Scanner;

public class TestAccess {
	public void test() {
		Person p = new Person();
		/*Scanner sc = new Scanner(System.in);
		//p.name = "ȫ�浿";
		
		System.out.print("�̸� : ");
		p.name = sc.next();*/
		
		p.inputName();
		p.printPerson();
	}
}
