package test.generic;

import java.util.*;

public class TestSetGeneric {

	public HashSet<String> makeSet() {
		HashSet<String> hset = new HashSet<String>();

		hset.add("java8");
		hset.add("oracle 11g");
		hset.add("html5");
		hset.add("css3");
		// hset.add(new Date());
		// 제네릭에 String으로 제한을 뒀으니 String클래스 외 다른 클래스 사용 불가

		return hset;
	}

	public void printSet(HashSet<String> hset) {
		Iterator<String> iter = hset.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			//원래 next()의 반환형은 Object지만 제네릭 명시 했으니 String이므로
			//형변환 할 필요가 없음
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		// Set Generic test
		TestSetGeneric test = new TestSetGeneric();
		HashSet<String> hs =  test.makeSet();
		test.printSet(hs);
	}
}
