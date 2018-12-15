package inherit.vo;

public class ObjectOverriding {
	public ObjectOverriding() {}
	
	public void testObjectMethod() {
		String s1 = "java";						//new 자동 할당
		String s2 = new String("java");		//s1과 s2는 주소가 다름
		//String s2 = "oracle";
		
		System.out.println(s1 == s2);				//false
		System.out.println(s1.hashCode() == s2.hashCode());		//true
		//s2가 참조하는 실제 문자열의 저장된 주소(hashCode() 오버라이딩)
		System.out.println(s1.equals(s2));		
		
		System.out.println("s1 : "+s1.hashCode());
		System.out.println("s2 : "+s2.hashCode());
		System.out.println("toString() : "+s1.toString());
		System.out.println("toString() : "+s2.toString());
	}
}
