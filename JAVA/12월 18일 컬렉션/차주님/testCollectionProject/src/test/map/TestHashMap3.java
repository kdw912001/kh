package test.map;

import java.util.*;

public class TestHashMap3 {

	public static void main(String[] args) {
		// HashMap 실습
		HashMap hmap = new HashMap();
		
		for(int k = 1; k <= 5; k++) {
			//1 ~ 100 사이의 임의의 정수가 키
			//0.0 부터 1.0 미만의 임의의 실수값을 값
			hmap.put(new Random().nextInt(100) + 1, 
					Math.random());
			//Auto Boxing 처리됨
		}
		
		System.out.println(hmap);

		//맵에 기록된 객체 정보 연속 처리
		//첫번째. 키들을 Set 으로
		//Set 을 목록으로 바꾸어 처리
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
		System.out.println("-----------");
		
		//두번째. 값들을 Collection으로
		//Collection을 목록으로 처리
		Collection values = hmap.values();
		Iterator valueIter = values.iterator();
		while(valueIter.hasNext()) {
			System.out.println(valueIter.next());
		}
		System.out.println("-----------");
		
		//세번째, Collection을 객체배열로
		Object[] valueArr = values.toArray();
		for(Object obj : valueArr) {
			System.out.println(obj);
		}
		System.out.println("-----------");
		
		//네번째, Map.Entry 들을 Set으로
		//목록으로 바꾸어 처리
		Set entries = hmap.entrySet();
		Iterator entryIter = entries.iterator();
		while(entryIter.hasNext()) {
			Object obj = entryIter.next();
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey()
					+ "=" + entry.getValue());
		}
		System.out.println("-----------");
	}

}
