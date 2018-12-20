package test.map;

import java.util.*;

public class TestHashMap2 {

	public static void main(String[] args) {
		// 맵에 저장된 객체정보 연속 처리
		HashMap hmap = new HashMap();
		
		hmap.put("one", new Integer(12345));
		hmap.put(2, "java");  //Auto Boxing
		hmap.put("two", "oracle");
		
		System.out.println(hmap);

		//Map 계열은 저장된 객체에 대한
		//연속 처리 기능 없음
		//연속 처리하려면
		//Map 을 Set 이나 Collection으로
		//바꾸고 나서 Iterator() 로 목록만들거나
		//Object[] 로 바꾸어 사용해야 함
		
		//첫번째, 키들을 Set으로 바꿈
		//키에 대한 목록을 만듦
		Set keys = hmap.keySet();
		System.out.println(keys);
		Iterator keyIter = keys.iterator();
		System.out.println("-----------");
		while(keyIter.hasNext()) {
			Object key = keyIter.next();
			Object value = hmap.get(key);
			System.out.println(key + " = "
					+ value);
		}
		System.out.println("----------------");
		
		//두번째, 값 객체들만 Collection 으로
		//바꾸고 나서, 목록이나 객체배열로 만듦
		Collection values = hmap.values();
		//1. 목록 만들기
		Iterator valueIter = values.iterator();
		while(valueIter.hasNext()) {
			System.out.println(valueIter.next());
		}
		System.out.println("-------------");
		
		//2. 객체배열만들기
		Object[] valueArr = values.toArray();
		for(Object obj : valueArr) {
			System.out.println(obj);
		}
		System.out.println("----------------");
		
		//세번째, entrySet() 사용
		//Map.Entry 들을 Set 으로 바꾸고
		//엔트리에 대한 목록을 만듦
		//Entry : 키와 값 한쌍
		Set entries = hmap.entrySet();
		Iterator entryIter = entries.iterator();
		while(entryIter.hasNext()) {
			Object obj = entryIter.next();
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey()
					+ "=" + entry.getValue());
		}
	}

}







