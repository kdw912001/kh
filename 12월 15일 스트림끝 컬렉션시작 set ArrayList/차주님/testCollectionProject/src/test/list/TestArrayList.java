package test.list;

import java.util.*;

public class TestArrayList {

	public static void main(String[] args) {
		// ArrayList test
		ArrayList alist = new ArrayList();
		
		//저장순서가 index 로 매겨짐
		//객체 중복 저장 가능함
		alist.add("java");
		alist.add("oracle");
		alist.add("jdbc");
		alist.add("java");
		
		System.out.println(alist);
		System.out.println("저장 객체수 : "
				+ alist.size());
		
		for(int i = 0; i < alist.size(); i++) {
			System.out.println(i + " : " + 
					alist.get(i));
		}
		
		//저장순번이 있는 배열이나 리스트는
		//for each 문 사용 가능함
		for(Object obj : alist) {
			System.out.println(obj);
		}

		//add(순번, 객체)
		alist.add(1, "html5");
		System.out.println(alist);
		
		//set(index, 변경할 객체)
		alist.set(3, "css3");
		System.out.println(alist);
		
		//remove(삭제할 객체) 
		//Set 계열 메소드와 동일함
		alist.remove("java");
		System.out.println(alist);
		
		//remove(index)
		alist.remove(2);
		System.out.println(alist);
	}

}




