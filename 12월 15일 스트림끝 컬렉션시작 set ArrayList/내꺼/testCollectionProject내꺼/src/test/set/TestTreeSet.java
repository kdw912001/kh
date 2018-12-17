package test.set;

import java.util.*;

public class TestTreeSet {

	public static void main(String[] args) {
		// TreeSet test
		//중복 허용 안 함
		//객체를 자동 오름차순 정렬하면서 저장함
		TreeSet tset = new TreeSet();
		//Set tset = new TreeSet(); 가능
		
		tset.add("orange");
		tset.add("banana");
		tset.add("apple");
		tset.add("grape");
		
		System.out.println(tset);
		
		//1. Iterator()
		System.out.println("1-----------------");
		Iterator it = tset.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		//2. toArray()
		System.out.println("2-----------------");
		Object[] objArr = tset.toArray();
		for(Object o: objArr)
			System.out.println(o);
		
		//3. 내림차순 정렬된 목록 만들기
		//descendingIterator()
		System.out.println("3---------------------");
		Iterator it2 = tset.descendingIterator();
		while(it2.hasNext())
			System.out.println(it2.next());
		
		//4. descendingSet()
		//내림차순 정렬된 Set 만들기
		System.out.println("4 ---------------");
		Set descSet = tset.descendingSet();
		System.out.println(descSet);
	}

}
