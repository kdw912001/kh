package test.list;

import java.util.*;
/*list는 저장되는 순서가 유지
 * set과 달리 list를 get,sort 있음
 * 	set에서는 iterator를 이용했는데 get(int index)로 값을 얻음
 *  public void sort(Comparator<? super E> c)
 * 
 * set에서 없는 ListIterator가 있음. 
 * Interface ListIterator<E>
 * 메소드 중에 previous()가 있음 앞 뒤 왔다갔다 가능
 */
public class TestArrayList {

	public static void main(String[] args) {
		// ArrayList test
		ArrayList alist = new ArrayList();
		
		//저장 순서가 index 로 매겨짐
		//객체 중복 저장 가능함(set은 중복 허용 안함)
		alist.add("java");
		alist.add("oracle");
		alist.add("jdbc");
		alist.add("java");
		
		System.out.println(alist);//[java, oracle, jdbc, java]
		System.out.println("저장 객체 수 : "+alist.size());
		for(int i=0; i<alist.size();i++) {
			System.out.println(i + " : " + alist.get(i));
		}
		
		//저장순번이 있는 배열이나 리스트는 for each문 사용 가능함
		for(Object obj : alist) {//리스트의 반환형은 Object
			System.out.println(obj);
		}
		
		//add(순번, 객체)
		alist.add(1, "html5"); //1번 인덱스에 값 저장
		System.out.println(alist);//원래 값은 뒤로 밀림
		//[java, html5, oracle, jdbc, java]
	
		//set(index, 변경할 객체)
		alist.set(3, "css3");
		System.out.println(alist);//[java, html5, oracle, css3, java]
		
		//remove(삭제할 객체) : Set 계열 메소드와 동일함
		alist.remove("java");
		System.out.println(alist);//[html5, oracle, css3, java]
	
		//remove(index) set에는 없는 기능 list만의 기능
		alist.remove(2);
		System.out.println(alist);//[html5, oracle, java]
	
		
	}
}
