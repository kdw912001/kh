package test.set;

import java.util.*;

public class TestHashSet {

	public static void main(String[] args) {
		// HashSet test
		HashSet hset = new HashSet();
		
		System.out.println(hset.isEmpty());
		System.out.println(hset.size());
		
		//객체만 저장할 수 있음.
		hset.add(new String("apple"));
		hset.add("banana");
		hset.add(new Integer(123));
		//data(값) --> instance(객체) : Boxing
		//Wrapper 클래스 사용
		hset.add(456);  //Auto Boxing 처리됨
		hset.add(new Double(54.7)); //Boxing 처리
		hset.add(3.15);  //Auto Boxing 
		//기본자료형 값에 대해서는
		//컬렉션에 저장시 자동 boxing 처리됨
		
		//부모클래스에 toString() 오버라이딩되어 있음
		System.out.println(hset/*.toString()*/);
		//저장순서가 유지 안 됨 
		//중복 허용 안 함
		
		hset.add("apple");
		hset.add("banana");
		System.out.println(hset);
		System.out.println(hset.size());
		
		if(hset.contains("apple")) {
			hset.remove("apple");
		}
		
		System.out.println(hset);
		System.out.println(hset.size());
		
		/*hset.clear();
		System.out.println(hset.isEmpty());*/
		
		//저장된 객체 정보를 하나씩 꺼내서
		//사용하는 방법
		//첫번째 : 저장된 객체의 목록만들기
		//목록 : iterator 라고 함
		System.out.println("1 -------------");
		Iterator iter = hset.iterator();
		while(iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
		}
		
		//두번째 : Object[] 로 바꾸어 꺼내기
		System.out.println("2 ----------------");
		Object[] objArr = hset.toArray();
		for(int i = 0; i < objArr.length; i++) {
			System.out.println(objArr[i]);
		}
		
		//세번째, toArray(T[] a) 사용하는 방법
		Object[] objArr2 = new Object[hset.size()];
		hset.toArray(objArr2);
		System.out.println("3 -------------");
		for(Object o : objArr2) {
			System.out.println(o);
		}
	}

}





