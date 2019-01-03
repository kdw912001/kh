package oop.inherit.run;

import oop.inherit.sample.Member;
import oop.inherit.sample.Student;

public class TestInheritance2 {
	public static void main(String[] args) {
		Student ss = new Student(
				"È«±æµ¿", 27, '³²', "°­³²´ëÇÐ±³", 
				2, 3.8, "Ã¼À°");
		Member mm = new Member(
				"±è¿µÈñ", 45, '¿©', 35000,
				"kyh77", "kyh77*");
		
		System.out.println(ss.information());
		System.out.println(mm.information());
	}
}
