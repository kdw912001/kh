package test.string.method;

public class TestStringMethod {

	/*public static void main(String[] args) {
		// java.lang.String Ŭ������ �����ϴ�
		//�޼ҵ� ��� �׽�Ʈ
		String s = "";
		//�ʱⰪ���� �� ����ǥ�� ��밡��
		System.out.println("���� : " + s.length());
		
		//char ch = '';  //����
		//���ڴ� �� ����ǥ ��� �� ��
		
		String s1 = null;
		//s1 = "apple";
		if(s1 != null && s1.length() > 0)
			System.out.println(s1.length());
		else
			System.out.println("���ڿ����� �ʿ��մϴ�.");
		
		
	}*/
	
	/*public static void main(String[] args) {
		//String ������ ��� �׽�Ʈ 
		String s1 = "apple";
		String s2 = new String("banana");
		
		byte[] bar = {74, 65, 86, 65};
		String s3 = new String(bar);
		
		char[] car = {'o', 'r', 'a', 'c', 'l', 'e'};
		String s4 = new String(car);
		
		int[] iar = {74, 65, 86, 65};
		String s5 = new String(iar, 0, iar.length);
		
		StringBuilder sb = 
			new StringBuilder("html5 & css3");
		String s6 = new String(sb);
		
		System.out.println("s1 : " + s1.toString());
		System.out.println("s2 : " + s2);
		System.out.println("s3 : " + s3);
		System.out.println("s4 : " + s4);
		System.out.println("s5 : " + s5);
		System.out.println("s6 : " + s6);
	}*/
	
	public static void main(String[] args) {
		//String Ŭ���� �޼ҵ� ��� �׽�Ʈ
		String s = "Hello";
		String n = "0123456";
		
		char c = s.charAt(1);
		char c2 = n.charAt(1);
		
		System.out.println("c = " + c);
		System.out.println("c2 = " + c2);
	}

}







