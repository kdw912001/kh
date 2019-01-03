package test.object.method;

public class TestMember {

	public static void main(String[] args) {
		// 메소드 오버라이딩 테스트
		Member m = new Member("홍길동",27, 1530.5);
		System.out.println("m : "+m/*.toString()*/);//출력시 toString()생략가능
		
		
		
		Member m2 = (Member)m.clone();
		//리턴된 Object --> Member 로 형변환
		
		System.out.println("m2 : "+m2);
		
		System.out.println("m == m2 : " + (m == m2));
		
		System.out.println("m: "+m.hashCode());
		System.out.println("m2 : "+m2.hashCode());

	}

}
