package test.map;

import java.util.*;
import practice2.Book;

public class TestMapGeneric {

	public static void main(String[] args) {
		// Map 계열의 제네릭 기능 사용
		//HashMap<String, Book> hmap;
		
		HashMap<String, Book> hmap = getInstance();
		//printMap(hmap);
		//printMap2(hmap);
		printMap3(hmap);
	}
	
	public static HashMap<String, Book> getInstance(){
		HashMap<String, Book> hmap = new HashMap<String, Book>();
		
		
		hmap.put("12", new Book("12",1,"자바정복","홍길동"));
		hmap.put("23", new Book("23",2,"홍길동전","허난설현"));
		hmap.put("37", new Book("37",4,"취미생활","금성출판"));
		//hmap.put(77,"77");//지정된 타입이 아니면 에러
		
		return hmap;
	}
	public static void printMap(HashMap<String, Book> hmap) {
		//첫번째, 키들을 Set으로 바꿈
		Set<String>keys = hmap.keySet();
		//목록 만들기
		Iterator<String> keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			Book b =hmap.get(key);
			System.out.println(key + "=" + b);
			//제네릭을 선언하면 제한한 형태(현재는 String)
			//선언하지 않으면 Object
		}
	}

	public static void printMap2(HashMap<String, Book> hmap) {
		//두번째, 값 객체들을 Collection 으로 바꿈
		Collection<Book> values = hmap.values();
		//목록 만들기
		Iterator<Book> valueIter = values.iterator();
		while(valueIter.hasNext()) {
			Book b= valueIter.next(); //제네릭은 형변환할 필요가 없으
			System.out.println(b);
			//제네릭을 선언하면 제한한 형태(현재는 String)
			//선언하지 않으면 Object
		}
		System.out.println("------------");
		//배열로 바꾸기
		Book[] bar = new Book[values.size()];
		values.toArray(bar);
		for(Book b : bar) {
			System.out.println(b);
		}
	}
	public static void printMap3(HashMap<String, Book> hmap) {
		//첫번째, 키와 값을 묶어서 엔트리들을 Set으로 바꿈
		Set<Map.Entry<String,Book>> entries = hmap.entrySet();
		//Map.Entry를 set하고 Entry들의 제네릭 타입 명시
		
		//목록 만들기
		Iterator<Map.Entry<String, Book>> entryIter = entries.iterator();
		//Map.Entry 들의 Iterator이므로 제네릭도 동일하게 명시
		
		while(entryIter.hasNext()) {
			//엔트리는 키와 값이 있는데 
			Map.Entry<String, Book> entry = entryIter.next();
			String key = entry.getKey();
			Book b = entry.getValue();
			//제네릭 명시 했으니 형변환 필요 없음
			System.out.println(key+"="+b);
		}
		
	}
}
