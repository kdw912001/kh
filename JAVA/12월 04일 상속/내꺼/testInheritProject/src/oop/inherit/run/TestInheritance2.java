package oop.inherit.run;

import oop.inherit.sample.Member;
import oop.inherit.sample.Student;

public class TestInheritance2 {
	public static void main(String[] args) {
		Student ss = new Student();//�θ������ ����->�ڼջ����� ����
		Member mm=new Member();//�θ������ ����->�ڼջ����� ����
		
		System.out.println(ss.information());
		System.out.println(mm.information());
		
		Student ss1 = new Student("ȫ�浿",27,'��',"�������б�",2,3.8,"ü��");
		Member mm1=new Member("�迵��",28,'��',80.0, "kyh77", "1q2w3e**");
		
		System.out.println(ss1.information());
		System.out.println(mm1.information());
	}
}
