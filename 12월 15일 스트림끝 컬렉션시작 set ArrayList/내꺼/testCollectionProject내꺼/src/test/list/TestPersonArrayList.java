package test.list;

import java.util.*;
import test.list.Person;
public class TestPersonArrayList {

	public static void main(String[] args) {
		// Person 저장용 ArrayList 사용
		ArrayList list = new ArrayList();
		//list list = new ArrayList()도 가능 (다형성 이용)
		list.add(new Person("홍길동", 25, 1537.5));
		list.add(new Person("이순신", 49, 15789.9));
		list.add(new Person("신사임당", 55, 34567.4));
		
		System.out.println(list);//toString 메소드 오버라이딩
		
		for(Object obj : list) {//꺼내면 기본 타입이 obj 실제론 Person
			System.out.println(obj);
		}
		
		//각 객체가 가진 포인트 값의 합계를 구함
		double totalPoint = 0;
		for(int i=0; i<list.size();i++) {
			Person p = (Person)(list.get(i));
			totalPoint +=p.getPoint();
			//get이 반납하는 타입이 Object인데 사용해야할 메소드는 
			//Person 클래스 안에 있는 getPoint()이므로 형변환 해야 함.
		}
		System.out.println("포인트 총합 : "+totalPoint);
	}
}
