package oop.model.vo;

import java.util.Scanner;

public class TestAccess {
	public void test() {
		Person p = new Person();
		/*Scanner sc = new Scanner(System.in);
		//p.name = "È«±æµ¿";
		
		System.out.print("ÀÌ¸§ : ");
		p.name = sc.next();*/
		
		p.inputName();
		p.printPerson();
	}
}
