package test.object.method;

public class TestObjectMethod {

	public static void main(String[] args) {
		// java.lang.Object 클래스는 모든 자바 클래스의 조상
		// Object 클래스의 모든 메소드는
		// 자바로 만든클래스들이 자신의 메소드처럼 사용할 수 있다.
		
		Member m = new Member();
		
		System.out.println("m -> "+ m.hashCode());
		System.out.println("m : "+m.toString());
		
		Member m2 = m; //주소복사
		
		System.out.println(m2.hashCode());
		System.out.println("주소가 같으냐? "+m.equals(m2));
		System.out.println(m==m2);
		
		
	}

}
