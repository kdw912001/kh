package test.list;

import java.util.*;

public class TestPersonArrayList2 {

	public static void main(String[] args) {
		// Generic ��� �׽�Ʈ
		ArrayList<Person> list;		
		
		list = addMethod();
		printList(list);
		System.out.println("-------------");
		list.sort(new NameAscending());
		printList(list);
		System.out.println("------------");
		list.sort(new NameDescending());
		printList(list);
		
		System.out.println("------------");
		list.sort(new PointAscending());
		printList(list);
		System.out.println("------------");
		list.sort(new PointDescending());
		printList(list);
	}
	
	public static ArrayList<Person> addMethod() {
		ArrayList<Person> list = 
			new ArrayList<Person>();
		
		list.add(new Person("ȫ�浿", 25, 1537.5));
		list.add(new Person("�̼���", 49, 15789.0));
		list.add(new Person("�Ż��Ӵ�", 55, 34567.4));
		//list.add(new String("test"));
		
		return list;
	}
	
	public static void printList(
			ArrayList<Person> list) {
		double totalPoint = 0.;
		for(Person p : list) {
			System.out.println(p);
			totalPoint += p.getPoint();
		}
		
		System.out.println("����Ʈ���� : "
				+ totalPoint);
		
		
		
	}

}




