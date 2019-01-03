package test.map;

import java.util.*;

public class TestHashMap2 {

	public static void main(String[] args) {
		// 맵에 저장된 객체정보 연속 처리
		HashMap hmap = new HashMap();
		
		hmap.put("one", new Integer(12345));
		hmap.put(2, "java"); //Auto Boxing
		hmap.put("two","oracle");
		
		System.out.println(hmap);//{2=java, one=12345, two=oracle}
		
		//set은 iterator(), list은 index를 이용하여 연속처리 기능		
		//Map 계열은 저장된 객체에 대한 연속 처리 기능 없음
		//연속 처리하려면
		//Map을 Set이나 Collection으로 바꾸고 나서 Iterator()로 목록만들거나
		//Object[] 로 바꾸어 사용해야 함.
		
		//Map 클래스의 values() 메소드를 사용하면 컬렉션으로 바꿈
		/*Collection<V> values()
		 * Returns:
a collection view of the values contained in this map
			그 이후 value 객체만 컬렉션으로 바꾸고 toarray로 하거나 iterator로 함.
		아니면
		 public Set<K> keySet()
Returns:
a set view of the keys contained in this map

		아니면
		public Set<Map.Entry<K,V>> entrySet()
		Returns:
a set view of the mappings contained in this map
		entry는 key,value 쌍 묶음을 entry라고 하는게 이 한 쌍을 set으로 바꿈
		entry는 내부클래스 
		entry 내부 인터페이스(Map.entry)에서 getKey() , getValue() 사용
		*/
		
		//첫번째, 키들을 Set으로 바꿈
		//키에 대한 목록을 만듦
		Set keys = hmap.keySet(); //key만 Set으로 바꿈
		System.out.println(keys);//[2, one, two]
		Iterator keyIter = keys.iterator();
		System.out.println("---------------------");
		while(keyIter.hasNext()) {
			Object key = keyIter.next(); //next()의 리턴타입이 Object
			Object value = hmap.get(key); //key에 대한 value가 꺼내짐
			System.out.println(key + " = "+value);
		}
		
		System.out.println("목록만들기------------------------");
		//두번째, 값 객체들만 Collection으로 바꾸고 나서, 목록이나 객체배열로 만듦
		Collection values = hmap.values();
		//1. 목록 만들기(값만 처리)
		Iterator valueIter = values.iterator();//값에 대한 목록
		while(valueIter.hasNext()) {
			System.out.println(valueIter.next());
		}
		
		System.out.println("객체배열-------------------");
		//2. 객체배열만들기
		Object[] valueArr = values.toArray();
		for(Object o : valueArr) {
			System.out.println(o);
		}
		
		System.out.println("entrySet-------------");
		//세번째, entrySet() 사용
		//Map.Entry들을 Set으로 바꾸고 엔트리에 대한 목록을 만듦
		//Entry : 키와 값 한쌍
		Set entries = hmap.entrySet();//엔트리들을 set으로 바꿈
		Iterator entryIter = entries.iterator();//엔트리에 대한 목록을 만듦
		while(entryIter.hasNext()) {
			//엔트리는 키와 값을 가지고 있기 때문에 각각 출력가능
			Object obj = entryIter.next();
			Map.Entry entry = (Map.Entry)obj;//외부클래스명.내부클래스명 Map.Entry
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
}
