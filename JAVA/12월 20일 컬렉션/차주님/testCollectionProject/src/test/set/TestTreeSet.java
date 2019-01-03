package test.set;

import java.util.*;

public class TestTreeSet {

	public static void main(String[] args) {
		// TreeSet test
		// 중복 허용 안 함
		// 객체를 자동 오름차순정렬하면서 저장함
		TreeSet tset = new TreeSet();
		//Set tset = new TreeSet():
		
		tset.add("orange");
		tset.add("banana");
		tset.add("apple");
		tset.add("grape");
		
		System.out.println(tset);
		
		//1. iterator()
		System.out.println("1 ---------------");
		Iterator objIter = tset.iterator();
		while(objIter.hasNext()) {
			System.out.println(objIter.next());
		}
		
		//2. toArray()
		System.out.println("2 ---------------");
		Object[] objArr = tset.toArray();
		for(Object obj : objArr) {
			System.out.println(obj);
		}
		
		//3. 내림차순정렬된 목록 만들기
		//descendingIterator()
		System.out.println("3 ---------------");
		Iterator descIter = tset.descendingIterator();
		while(descIter.hasNext()) {
			System.out.println(descIter.next());
		}
		
		//4. descendingSet() 
		//내림차순정렬된 Set 만들기
		System.out.println("4 ----------");
		Set descSet = tset.descendingSet();
		System.out.println(descSet);
		
	}

}


