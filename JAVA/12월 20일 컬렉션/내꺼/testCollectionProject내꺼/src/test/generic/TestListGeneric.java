package test.generic;

import java.util.*;

public class TestListGeneric {

	public ArrayList<String> makeList(){
		ArrayList<String> list;
		list = new ArrayList<String>();
		
		list.add("apple");
		list.add("banana");
		list.add("orange");
		list.add("melon");
		list.add("grape");
		
		
		return list;//list를 리턴한다면 메소드의 반환자료형에 제네릭 표시
	}
	
	public void printList(ArrayList<String> list) {//매개변수도 제네릭
		/*for(int i=0; i<list.size();i++) {
			String str = list.get(i);
			System.out.println(str);
			//제네릭 타입으로 안했다면 Object형이지만 제네릭 명시를 해놨으니 형변환이 필요없음.
		}*/
		//순번이 있는 List는 for each문 사용가능
		for(String s:list) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		// List Generic test
		TestListGeneric test = new TestListGeneric();
		ArrayList<String> list = test.makeList();
		//리턴값을 받아줄 때도 같은 자료형으로 받아주되 같은 제네릭 타입으로 받아줘야 함.
		test.printList(list);
		
	}

}
