package oop.inherit.run;

import oop.inherit.sample.Member;
import oop.inherit.sample.Student;

public class TestInheritance2 {
	public static void main(String[] args) {
		Student ss = new Student();//부모생성자 실행->자손생성자 실행
		Member mm=new Member();//부모생성자 실행->자손생성자 실행
		
		System.out.println(ss.information());
		System.out.println(mm.information());
		
		Student ss1 = new Student("홍길동",27,'남',"강남대학교",2,3.8,"체육");
		Member mm1=new Member("김영희",28,'여',80.0, "kyh77", "1q2w3e**");
		
		System.out.println(ss1.information());
		System.out.println(mm1.information());
	}
}
