package test.map;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestHashMap {

	public static void main(String[] args) {
		// HashMap test
		HashMap hmap = new HashMap();
		//Map hm = new HashMap();
		
		//키 객체와 값 객체 쌍으로 저장함
		hmap.put("one", 
			new Person("홍길동", 27, 1530.5));
		hmap.put("23", new Book("23", 1, "해리포터5", "조앨롤링"));
		//key 는 Set 방식으로 저장
		//키는 중복되면 안 됨
		//value 는 List 방식으로 저장됨
		//값은 중복 저장됨
		
		
		System.out.println("저장된 객체 수 : "
				+ hmap.size());
		System.out.println(hmap/*.toString()*/);
	
		hmap.put("one", "java programming");
		System.out.println(hmap);
		hmap.put("two", new Book("23", 1, "해리포터5", "조앨롤링"));
		System.out.println(hmap);
		
		//맵에 저장된 값 객체 조회시
		Object value = hmap.get("23");
		System.out.println(value);
		if(value instanceof Book) {
			Book b = (Book)value;
			System.out.println(b.getTitle());
			System.out.println(((Book)value).getAuthor());
		}
	}

}






