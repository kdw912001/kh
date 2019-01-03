package test.generic;

import java.util.*;

public class TestMapGeneric {
	
	public HashMap<Integer, String> makeMap(){
		HashMap<Integer, String> hmap
			= new HashMap<Integer, String>();
		
		hmap.put(new Integer(3), new String("java"));
		hmap.put(5, "Servlet");  //값 --> 객체
		//Wrapper 클래스에 의해 자동 Boxing 처리됨
		hmap.put(12, "JSP");
		
		return hmap;
	}

	public void printMap(HashMap<Integer, String> hmap) {
		
		Set<Integer> keys = hmap.keySet();
		Iterator<Integer> keyIter = keys.iterator();
		
		while(keyIter.hasNext()) {
			Integer key = keyIter.next();
			String value = hmap.get(key);
			System.out.println(key + "=" + value);
		}
	}
	
	public void printMap2(HashMap<Integer, String> hmap) {
		Set<Map.Entry<Integer, String>> entries = 
				hmap.entrySet();
		Iterator<Map.Entry<Integer, String>> entryIter 
			= entries.iterator();
		
		while(entryIter.hasNext()) {
			Map.Entry<Integer, String> entry
				= entryIter.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "=" + value);
		}
	}
	
	public static void main(String[] args) {
		// Map Generic test
		TestMapGeneric test = 
				new TestMapGeneric();
		HashMap<Integer, String> hm 
			= test.makeMap();
		//test.printMap(hm);
		test.printMap2(hm);
	}

}





