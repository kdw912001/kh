package test.map;

import java.util.*;
import practice2.Book;

public class TestMapGeneric {

	public static void main(String[] args) {
		// Map 계열의 제네릭 기능 사용	 
		
		 HashMap<String, Book> hmap = getInstance();
		 //printMap(hmap);
		 //printMap2(hmap);
		 printMap3(hmap);

	}
	
	public static HashMap<String, Book> getInstance(){
		HashMap<String, Book> hmap = 
				new HashMap<String, Book>();
		
		hmap.put("12", new Book("12", 1, "자바정복", "홍길동"));
		hmap.put("23", new Book("23", 2, "홍길동전", "허난설헌"));
		hmap.put("37", new Book("37", 4, "취미생활", "금성출판"));
		//hmap.put(77, "77");
		
		return hmap;
	}
	
	public static void printMap(HashMap<String, Book> hmap) {
		//첫번째, 키들을 Set 으로 바꿈
		Set<String> keys = hmap.keySet();
		//목록 만들기
		Iterator<String> keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			Book b = hmap.get(key);
			System.out.println(key + "=" + b);
		}
	}
	
	public static void printMap2(HashMap<String, Book> hmap) {
		//두번째, 값객체들을 Collection 으로 바꿈
		Collection<Book> values = hmap.values();
		//목록 만들기
		Iterator<Book> valueIter = values.iterator();
		while(valueIter.hasNext()) {
			Book b = valueIter.next();
			System.out.println(b);
		}
		System.out.println("--------------------");
		//배열로 바꾸기
		Book[] bar = new Book[values.size()];
		values.toArray(bar);
		for(Book b : bar) {
			System.out.println(b);
		}
	}
	
	public static void printMap3(HashMap<String, Book> hmap) {
		//첫번째, 키와 값을 묶은 엔트리들을
		//Set 으로 바꿈
		Set<Map.Entry<String, Book>> entries 
			= hmap.entrySet();
		//목록 만들기
		Iterator<Map.Entry<String, Book>> entryIter 
			= entries.iterator();
		while(entryIter.hasNext()) {
			Map.Entry<String, Book> entry 
				= entryIter.next();
			String key = entry.getKey();
			Book b = entry.getValue();
			System.out.println(key + "=" + b);
		}
	}

}




