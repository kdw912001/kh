package test.object.method;

public class TestMember {

	public static void main(String[] args) {
		// �޼ҵ� �������̵� �׽�Ʈ
		Member m = new Member("ȫ�浿",27, 1530.5);
		System.out.println("m : "+m/*.toString()*/);//��½� toString()��������
		
		
		
		Member m2 = (Member)m.clone();
		//���ϵ� Object --> Member �� ����ȯ
		
		System.out.println("m2 : "+m2);
		
		System.out.println("m == m2 : " + (m == m2));
		
		System.out.println("m: "+m.hashCode());
		System.out.println("m2 : "+m2.hashCode());

	}

}
