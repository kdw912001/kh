package test.set;

import java.util.*;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		// LinkedHashSet test
		// 저장순서가 유지되는 Set
		// 중복 허용 안 함
		
		LinkedHashSet lset = 
				new LinkedHashSet();

		lset.add("apple");
		lset.add("banana");
		lset.add(123);
		lset.add(54.7);
		lset.add("apple");
		
		System.out.println(lset);
		
		System.out.println("1 -------------");
		//첫번째 : 저장된 객체 목록만들어
		//하나씩 꺼내기
		Iterator objIter = lset.iterator();
		while(objIter.hasNext()) {
			System.out.println(objIter.next());
		}
		
		System.out.println("2 -------------");
		//두번째 : Object[] 배열로 바꾸어
		//하나씩 꺼내기
		Object[] objArr = lset.toArray();
		for(Object obj : objArr) {
			System.out.println(obj);
		}
		
		System.out.println("3 ------------");
		Object[] objArr2 = new Object[lset.size()];
		lset.toArray(objArr2);
		for(int i = 0; i < objArr2.length; i++) {
			System.out.println(objArr2[i]);
		}
	}

}






