package oop.inherit.run;

import oop.inherit.sample.Member;
import oop.inherit.sample.Student;

public class TestInheritance2 {
	public static void main(String[] args) {
		Student ss = new Student(
				"ȫ�浿", 27, '��', "�������б�", 
				2, 3.8, "ü��");
		Member mm = new Member(
				"�迵��", 45, '��', 35000,
				"kyh77", "kyh77*");
		
		System.out.println(ss.information());
		System.out.println(mm.information());
	}
}
