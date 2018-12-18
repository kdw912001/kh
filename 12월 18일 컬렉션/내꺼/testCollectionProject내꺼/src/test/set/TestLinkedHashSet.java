package test.set;

import java.util.*;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		// LinkedHashSet test
		//저장 순서가 유지되는 Set
		//중복 허용 안 함
		
		LinkedHashSet lset = new LinkedHashSet();
		
		lset.add("apple");
		lset.add("banana");
		lset.add(123);
		lset.add(54.7);
		lset.add("apple");
		
		System.out.println(lset);
		
		System.out.println("1-----------------");
		//첫번째 : 저장된 객체 목록 만들어 하나씩 꺼내기
		
		Iterator it = lset.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		

		//두번째 : Object[] 배열로 바꾸어 하나씩 꺼내기
		System.out.println("2-------------------");
		Object[] objArr = lset.toArray();
		for(int i=0; i<objArr.length;i++)
			System.out.println(objArr[i]);
		
		//세번째 : toArray(T[] a) 사용
		System.out.println("3----------------");
		Object[] objArr2 = new Object[lset.size()];
		lset.toArray(objArr2);
		for(Object o:objArr2)
			System.out.println(o);
		
		
	}

}
