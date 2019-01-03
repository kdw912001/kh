package test.map;

import java.util.*;
import java.util.Map.Entry;

public class TestHashMap3 {

	public static void main(String[] args) {
		// HashMap 실습
		HashMap hmap = new HashMap();
		
		for(int k=1; k<=5;k++) {
			//1~100 사이의 임의의 정수가 키
			//0.0 부터 1.0 미만의 임의의 실수값을 값(value)
			hmap.put(new Random().nextInt(100)+1, Math.random());
			//Auto Boxing 처리 됨
		}
		System.out.println(hmap);
		
		//맵에 기록된 객체 정보 연속 처리
		//첫번째, 키들을 Set으로 Set을 목록으로 바꾸어 처리
		Set keys = hmap.keySet();
		Iterator itKey = keys.iterator();
		while(itKey.hasNext()) {
			System.out.println(itKey.next());
		}
		
		//두번째, 값들을 Collection으로 Collection을 목록으로 처리
		Collection values = hmap.values();
		Iterator itValue = values.iterator();
		while(itValue.hasNext()) {
			System.out.println(itValue.next());
		}
		
		//세번째, Collection을 객체배열
		Object[] hobj = values.toArray();
		for(Object o:hobj) {
			System.out.println(o);
		}
		
		System.out.println("---------");
		//네번째, Map.Entry 들을 Set으로 그 후 목록으로 바꾸어서 처리
		// Map.Entry entry = (Map.Entry) hmap.entrySet();
		Set set = hmap.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
