package test.list;

import java.util.*;

public class TestPersonArrayList2 {

	public static void main(String[] args) {
		// Generic 사용 테스트
		//Generic은 선언한 클래스 외의 다른 클래스 타입은 저장할 수 없음->에러
		//오직 제한한 클래스만 사용 가능
		ArrayList<Person> list; //Person만 저장할 수 있는 list
		/*list = new ArrayList<Person>(); */
		//한번 제네릭 붙으면 레퍼런스 변수 선언, 생성 모두 제네릭 타입 명시
		
		list = addMethod(/*list*/);
		printList(list);
	}
	
	public static ArrayList<Person> addMethod(/*ArrayList<Person> list*/) {//받아주는 매개변수도 제네릭 타입 명시
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("홍길동", 25, 1537.5));
		list.add(new Person("이순신", 49, 15789.9));
		list.add(new Person("신사임당", 55, 34567.4));
		//list.add(new String("신사임당"); Person 타입이 아니므로 에러
		
		return list;//메소드의 반환형에도 제네릭 명시 ArrayList<Person>
	}
	
	public static void printList(ArrayList<Person> list) {
		double totalPoint = 0.;
		for(Person p: list) {
			//제네릭이 선언되면 다운캐스팅이 필요 없고 
			//Object가 아닌 Person을 바로 꺼낼 수 있음.
			System.out.println(p);
			totalPoint += p.getPoint();
		}
	}
}
