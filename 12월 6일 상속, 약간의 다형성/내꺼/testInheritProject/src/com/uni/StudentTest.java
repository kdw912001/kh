package com.uni;

public class StudentTest {

	public static void main(String[] args) {
		Student[] s = new Student[3];
				/*{("홍길동", 15, 171, 81, 201101, "영문"),
				("한사람",13,183,72,201102,"건축"),("임걱정",16,175,65,201103, "무영")
		};*/
		
			s[0]=new Student("홍길동", 15, 171, 81, "201101", "영문");
			s[1]=new Student("한사람",13,183,72,"201102","건축");
			s[2]=new Student("임걱정",16,175,65,"201103", "무영");
		
			for(int i=0; i<s.length;i++) {
				System.out.println(s[i].printInformation());
			}
	}

}
