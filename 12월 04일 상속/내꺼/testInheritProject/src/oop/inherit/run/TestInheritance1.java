package oop.inherit.run;

import java.util.Scanner;

import oop.inherit.sample.Student;

public class TestInheritance1 {

	public static void main(String[] args) {
		// 상속 연습
		Student ss = new Student();
		Scanner sc = new Scanner(System.in);
		
		/*System.out.print("학생이름 : ");
		ss.setName(sc.next());
		System.out.print("학교이름 : ");
		sc.nextLine(); //nextLine()을 쓰기 위해 엔터키를 버퍼에서 지워버림
		ss.setSchoolName(sc.nextLine());
		System.out.print("학년 : ");
		ss.setSchoolYear(sc.nextInt());
		System.out.print("나이 : ");
		ss.setAge(sc.nextInt());
		System.out.print("성별[남/여] : ");
		ss.setGender(sc.next().charAt(0));
		System.out.print("전공 : ");
		ss.setMajor(sc.next());
		System.out.print("학점 : ");
		ss.setScore(sc.nextDouble());*/
		
		System.out.println(ss.information());
		System.out.println(ss.hashCode());
		System.out.println(ss.toString());
		
		Student st = ss;
		System.out.println(ss.equals(st));
	}

}
