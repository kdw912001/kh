package test.object.method;

public class TestObjectMethod {

	public static void main(String[] args) {
		// java.lang.Object Ŭ������ ��� �ڹ� Ŭ������ ����
		// Object Ŭ������ ��� �޼ҵ��
		// �ڹٷ� ����Ŭ�������� �ڽ��� �޼ҵ�ó�� ����� �� �ִ�.
		
		Member m = new Member();
		
		System.out.println("m -> "+ m.hashCode());
		System.out.println("m : "+m.toString());
		
		Member m2 = m; //�ּҺ���
		
		System.out.println(m2.hashCode());
		System.out.println("�ּҰ� ������? "+m.equals(m2));
		System.out.println(m==m2);
		
		
	}

}
