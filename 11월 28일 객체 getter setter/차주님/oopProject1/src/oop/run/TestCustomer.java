package oop.run;

import java.util.Scanner;

import oop2.model.vo.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		// oop encapsulation test
		//클래스 사용
		//클래스명 레퍼런스변수;
		//레퍼런수(reference) : 참조
		//레퍼런스 = 객체의 주소 기록함.
		Customer cm;
		
		//레퍼런스변수 = new 생성자([초기값]);
		//생성자에 의해 힙메모리에 
		//해당 클래스에 대한 객체(인스턴스)를
		//할당하고, 그 주소를 레퍼런스에 기록
		cm = new Customer();
		
		//System.out.println("cm : " + cm.hashCode());
		
		//클래스가 가진 메소드 사용
		//[자료형 변수=]레퍼런스.메소드명([전달값]);
		cm.printCustomer();
		
		Customer cm2 = new Customer(123, "홍길순");
		//System.out.println("cm2 : " + cm2.hashCode());
		cm2.printCustomer();
		
		//cm 이 참조하는 객체의 필드값 변경
		cm.setId(33);
		cm.setName("박문수");
		cm.setAge(35);
		cm.setGender('남');
		cm.setPhone("010-1234-5678");
		cm.setAddress("경남 통영시");
		
		cm.printCustomer();
		
		//cm2가 참조하는 객체의 기본값 변경
		cm2.setAge(28);
		cm2.setGender('여');
		cm2.setPhone("010-7777-8888");
		cm2.setAddress("서울시 강남구 역삼동");
		cm2.setPoint(1257.5);
		
		cm2.printCustomer();
		
		//키보드로 입력받은 값으로 기록 처리
		/*Customer cm3 = new Customer();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		int id = sc.nextInt();
		cm3.setId(id);
		cm3.setId(sc.nextInt());
		System.out.print("이름 : ");
		String name = sc.next();
		cm3.setName(name);
		cm3.setName(sc.next());
		System.out.print("나이 : ");
		cm3.setAge(sc.nextInt());
		System.out.print("성별[남/여] : ");
		cm3.setGender(sc.next().charAt(0));
		System.out.print("전화번호 : ");
		cm3.setPhone(sc.next());
		System.out.print("주소 : ");
		sc.nextLine();
		cm3.setAddress(sc.nextLine());
		System.out.print("누적포인트 : ");
		cm3.setPoint(sc.nextDouble());
		
		cm3.printCustomer();*/
		
		//cm 이 참조하는 객체의 
		//이름, 나이, 포인트 조회
		String name = cm.getName();
		int age = cm.getAge();
		double point = cm.getPoint();
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("포인트 : " + point);
		
		//두 객체의 나이 평균 계산 출력
		int avg = (cm.getAge() + cm2.getAge()) / 2;
		System.out.println("나이 평균 : " + avg);
	}

}








