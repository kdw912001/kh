package test.list;

import java.util.*;

public class TestPersonArrayList2 {

	public static void main(String[] args) {
		// Generic 사용 테스트
		ArrayList<Person> list;		
		
		list = addMethod();
		printList(list);
	}
	
	public static ArrayList<Person> addMethod() {
		ArrayList<Person> list = 
			new ArrayList<Person>();
		
		list.add(new Person("홍길동", 25, 1537.5));
		list.add(new Person("이순신", 49, 15789.0));
		list.add(new Person("신사임당", 55, 34567.4));
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
		
		System.out.println("포인트총합 : "
				+ totalPoint);
	}

}




