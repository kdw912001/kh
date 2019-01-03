package test.set;

import java.util.*;

public class TestTreeSet {

	public static void main(String[] args) {
		// TreeSet test
		// �ߺ� ��� �� ��
		// ��ü�� �ڵ� �������������ϸ鼭 ������
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
		
		//3. �����������ĵ� ��� �����
		//descendingIterator()
		System.out.println("3 ---------------");
		Iterator descIter = tset.descendingIterator();
		while(descIter.hasNext()) {
			System.out.println(descIter.next());
		}
		
		//4. descendingSet() 
		//�����������ĵ� Set �����
		System.out.println("4 ----------");
		Set descSet = tset.descendingSet();
		System.out.println(descSet);
		
	}

}


