package test.map;

import java.util.*;
import practice2.Book;
import test.list.Person;

public class TestHashMap {
	public static void main(String[]args) {
		//HashMap test
		HashMap hmap = new HashMap();
		//Map hm = new HashMap(); //다형성 이용
		
		/*값을 입력할 때 쓰틑 메서드
		 * public V put(K key,  V value)
		 * key와 value 모두 객체여야 함
		 * Returns:
the previous value associated with key, or null if there was no mapping for key
		 */
		
		//키 객체와 값 객체 쌍으로 저장함
		hmap.put(/*new String(*/"one"/*)*/, new Person("홍길동",27,1530.5));
		//굳이 new String 할 필요 없음
		hmap.put("23", new Book("23",1,"해리포터5","조앨롱링"));//도서번호를 Key로
		//key는 Set 방식으로 저장(순서 X,중복X)
		//키는 중복되면 안 됨.
		//value는 List 방식으로 저장됨.
		//값은 중복 저장됨.
		
		System.out.println("저장된 객체 수 : "+hmap.size());
		System.out.println(hmap/*.toString()*/);
		/*Abstract HashMap에서 toString() 메소드
		 * 중괄호 안에 Key = Value  형식으로 나옴
		 * public String toString()
Returns a string representation of this map. The string representation consists of a list of key-value mappings in the order returned by the map's entrySet view's iterator, 
enclosed in braces ("{}"). Adjacent mappings are separated by the characters ", " (comma and space). Each key-value mapping is rendered as the key followed by an equals sign ("=") followed by the associated value. Keys and values are converted to strings as by String.valueOf(Object).
		 */
		
		hmap.put("one", "java programming");
		System.out.println(hmap);//one에 value를 덮어씌움.->key 중복X
		
		hmap.put("two",new Book("23",1,"해리포터5","조앨롱링"));
		//value는 List 방식으로 저장 되기 때문에 중복 저장 가능
		System.out.println(hmap);
		
		//맵에 저장된 값 객체 조회시 
		Object value = hmap.get("23");//get()은 Object로 리턴
		System.out.println(value);
		//Object 타입으로는 Book객체의 메소드를 쓸 수 없으니 다운캐스팅
		if(value instanceof Book) {//꺼낸 객체가 Book 이면
			Book b = (Book)value;
			System.out.println(b.getTitle());
			System.out.println(((Book)value).getAuthor());//한 줄에 다운캐스팅
		}
		//Map은 저장 put, 조회 시 get
		
		
		//(중요!!)저장된 정보를 List처럼 연속으로 처리할 때 
	}
}
