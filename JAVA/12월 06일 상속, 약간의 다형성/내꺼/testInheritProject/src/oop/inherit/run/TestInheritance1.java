package oop.inherit.run;

import java.util.Scanner;

import oop.inherit.sample.Student;

public class TestInheritance1 {

	public static void main(String[] args) {
		// ��� ����
		Student ss = new Student();
		Scanner sc = new Scanner(System.in);
		
		/*System.out.print("�л��̸� : ");
		ss.setName(sc.next());
		System.out.print("�б��̸� : ");
		sc.nextLine(); //nextLine()�� ���� ���� ����Ű�� ���ۿ��� ��������
		ss.setSchoolName(sc.nextLine());
		System.out.print("�г� : ");
		ss.setSchoolYear(sc.nextInt());
		System.out.print("���� : ");
		ss.setAge(sc.nextInt());
		System.out.print("����[��/��] : ");
		ss.setGender(sc.next().charAt(0));
		System.out.print("���� : ");
		ss.setMajor(sc.next());
		System.out.print("���� : ");
		ss.setScore(sc.nextDouble());*/
		
		System.out.println(ss.information());
		System.out.println(ss.hashCode());
		System.out.println(ss.toString());
		
		Student st = ss;
		System.out.println(ss.equals(st));
	}

}
