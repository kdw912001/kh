package test.set;
import java.util.*;

/*API HashSet 클래스
 * public class HashSet<E>
extends AbstractSet<E>
implements Set<E>, Cloneable, Serializable
 * 					복사 가능, 직렬화-객체스트림 가능
 * 
 * Constructor and Description
HashSet()
Constructs a new, empty set; the backing HashMap instance has default initial capacity (16) and load factor (0.75).
기본 capacity가 16, 용량이 초과되면 0.75배 만큼 용량 늘릴 수 있음(load factor)
HashSet(Collection<? extends E> c)
Constructs a new set containing the elements in the specified collection.
HashSet(int initialCapacity)//저장용량 값을 정하면서 생성자 생성, 기본 load factor는 0.75
Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and default load factor (0.75).
HashSet(int initialCapacity, float loadFactor)//저장용량과 loadfactor를 직접 정함
Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and the specified load factor.
 */
public class TestHashSet {

	public static void main(String[] args) {
		// HashSet test
		HashSet hset = new HashSet();
		
		System.out.println(hset.isEmpty());//현재 비어있으니 true
		System.out.println(hset.size()); //없으니 0
		
		//객체만 저장할 수 있음
		hset.add(new String("apple"));
		hset.add("banana"); 
		//문자열 값 자체가 문자열 저장소를 가르키는 주소 발생시킴 
		//new String이 원칙이나 이렇게도 가능
		hset.add(new Integer(123));
		//data(값)--> instance(객체) : Boxing
		//Wrapper 클래스 사용(Boxing사용할 때)
		hset.add(456); //Auto Boxing 처리됨
		//Collection 은 객체만 넣는게 맞지만 Auto Boxing처리 되서 new Integer로 바꿈
		hset.add(new Double(54.7));//Boxing 처리
		hset.add(3.15); //AutoBoxing
		//기본자료형 값에 대해서는
		//컬렉션에 저장시 자동 boxing처리됨
		
		//부모클래스에 toString() 오버라이딩되어 있음
		System.out.println(hset/*.toString()*/);
		//저장순서가 유지 안 됨(set의 특징)
		//중복 허용 안 함
		hset.add("apple"); //같은 값을 넣어도 알아서 중복검사를 함
		hset.add("banana");
		System.out.println(hset);//[banana, apple, 54.7, 456, 3.15, 123]
		System.out.println(hset.size());//6
		
		
		if(hset.contains("apple")) {
			hset.remove("apple");
		}
		//"apple" 객체를 포함하고 있으면 삭제, 삭제 후 출력 및 사이즈 확인
		System.out.println(hset);//[banana, 54.7, 456, 3.15, 123]
		System.out.println(hset.size());//5
		
		/*hset.clear(); //전부 다 지워버림
		System.out.println(hset.isEmpty());//안이 비었으니 true*/
	
		//저장된 객체 정보를 하나씩 꺼내서 사용하는 방법
		//set은 하나를 꺼낼 수 있는 메서드가 없음
		//첫번째 : 저장된 객체의 목록 만들기
		//목록 : iterator  라고 함
		System.out.println("1 ------------------");
		Iterator iter = hset.iterator(); 
		//set에 저장된 객체들을 목록화 하여 iter가 가지고 있음
		//Iterator 인터페이스 내에 hasNext()와 next() 이용
		while(iter.hasNext()) {
			Object obj = iter.next();//리턴 값이 Object
			System.out.println(obj);
		}
		
		//두번째 : Object[] 로 바꾸어 꺼내기
		System.out.println("2 --------------------");
		Object[] objArr = hset.toArray();//객체배열로 바꿈
		for(int i=0; i<objArr.length;i++) {
			System.out.println(objArr[i]);
		}
		
		//세번째 : toArray(T[] a) 사용하는 방법
		System.out.println("3 --------------------");
		//Object[] objArr2 = hset.toArray(objArr);
		Object[] objArr2 = new Object[hset.size()];
		hset.toArray(objArr2);
		for(Object o: objArr2) {//objArr2를 꺼내면 Object
			System.out.println(o);
		}
	}
}
