package inherit.vo;

public class ObjectOverriding {
	public ObjectOverriding() {}
	
	public void testObjectMethod() {
		String s1 = "java";						//new �ڵ� �Ҵ�
		String s2 = new String("java");		//s1�� s2�� �ּҰ� �ٸ�
		//String s2 = "oracle";
		
		System.out.println(s1 == s2);				//false
		System.out.println(s1.hashCode() == s2.hashCode());		//true
		//s2�� �����ϴ� ���� ���ڿ��� ����� �ּ�(hashCode() �������̵�)
		System.out.println(s1.equals(s2));		
		
		System.out.println("s1 : "+s1.hashCode());
		System.out.println("s2 : "+s2.hashCode());
		System.out.println("toString() : "+s1.toString());
		System.out.println("toString() : "+s2.toString());
	}
}
