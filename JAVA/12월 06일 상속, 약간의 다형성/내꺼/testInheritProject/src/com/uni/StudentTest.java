package com.uni;

public class StudentTest {

	public static void main(String[] args) {
		Student[] s = new Student[3];
				/*{("ȫ�浿", 15, 171, 81, 201101, "����"),
				("�ѻ��",13,183,72,201102,"����"),("�Ӱ���",16,175,65,201103, "����")
		};*/
		
			s[0]=new Student("ȫ�浿", 15, 171, 81, "201101", "����");
			s[1]=new Student("�ѻ��",13,183,72,"201102","����");
			s[2]=new Student("�Ӱ���",16,175,65,"201103", "����");
		
			for(int i=0; i<s.length;i++) {
				System.out.println(s[i].printInformation());
			}
	}

}
