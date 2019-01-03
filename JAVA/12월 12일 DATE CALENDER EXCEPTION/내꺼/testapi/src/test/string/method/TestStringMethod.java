package test.string.method;

public class TestStringMethod {

	/*public static void main(String[] args) {
		// java.lang.String Ŭ������ �����ϴ�
		//�޼ҵ� ��� �׽�Ʈ
		String s = "";
		//�ʱⰪ���� �� ����ǥ (empty string) ��밡��
		System.out.println("���� ���� : " + s.length()); // 0
		//�� ����ǥ�� ���� ������ 0��
		//Nullescape ������ ī��Ʈ �ϹǷ� 0��
		//nullescape�� c���� ��޵ǰ� �ڹٿ��� �ڵ����� ó���ϱ� ������ ��� ����
		
		//char ch = ''; //����
		//���ڴ� �� ����ǥ ��� �� ��.->���鹮�ڷ� ��� 
		//���鹮�ڵ� �����ڵ带 ���� �ϳ��� ����
		
		String s1 = null; //�Ϲ������� null�� �ʱ�ȭ
		if(s1 != null && s1.length() >0) //���ڰ� �־���Ѵٴ� ����
			System.out.println(s1.length()); //���ǽ� ���� ����ϸ� 
						//null.length()�̹Ƿ� ����
						//�������� : java.lang.NullPointerException
		//���ڿ����� NullPointerException ���� �߻�
		else
			System.out.println("���ڿ����� �ʿ��մϴ�.");
		
		s1 = "apple";
		System.out.println(s1.length());

	}*/
	/*String ������ 
	 * public static void main(String[]args) {
		String s1 = "apple";
		String s2 = new String("banana");
		
		byte[] bar = {74, 65, 86 ,65}; 
		//������ ���ڿ��� ������ѷ��� �����ڵ� �̿�
		// J A V A
		String s3 = new String(bar);
		//API String Ŭ������ �����ڸ� Ȯ���غ���
		//String(byte[] bytes)
		char[] car = {'o','r','a','c','l','e'};
		String s4 = new String(car);
		//String(char[] value)
		
		int[] iar = {74, 65, 86 ,65};
		String s5 = new String(iar, 0 ,iar.length);
		//API���� String Ŭ������ �����ڸ� Ȯ���غ���
		//String(int[] codePoints, int offset(������), int count(������)
		
		StringBuilder sb = new StringBuilder("html5 & css3");
		String s6 = new String(sb);
		////String(StringBuilder builder)
		
		System.out.println("s1 : "+s1.toString());
		//ObjectŬ������ toString�޼ҵ带 �������̵��Ǿ� �־� ���ڿ��� ���
		//return : the string itself. 
		//��±������� ���۷����� �ᵵ �ڵ����� toString ��.
		System.out.println("s2 : "+s2);
		System.out.println("s3 : "+s3);
		System.out.println("s4 : "+s4);
		System.out.println("s5 : "+s5);
		System.out.println("s6 : "+s6);
		
	}*/
	
	//String �޼ҵ� ->�ϱ��Ϸ� �������� API�� ���鼭 ĸ��ȭ�� �����Ͽ� ����
	public static void main(String[] args) {
		/*charAt�޼ҵ�
		 * char charAt(int index)
		 * ������ ��ġ(index)�� �ִ� ���ڸ� �˷��ش�(index�� 0���� ����)
		 * String s = "Hello";
		String n= "0123456";
		char c = s.charAt(1);
		char c2 = n.charAt(1);
		
		System.out.println("c = "+c);
		System.out.println("c = "+c2);*/
		
		/*concat �޼ҵ�
		 * String concat(String str)
		 * ���ڿ�(str)�� �ڿ� �����δ�
		 * String s = "Hello";
		String s2 = s.concat(" World");
		System.out.println("s2 = "+s2);*/
		
		/*contains �޼ҵ�
		 * boolean contains(CharSequence s)
		 * ������ ���ڿ�(s)�� ���ԵǾ����� �˻��Ѵ�.
		 * String s = "abcdfg";
		boolean b = s.contains("bc");
		System.out.println("b = "+b);*/
		
		/*endWith �޼ҵ�
		 * boolean endsWith(String suffix)
		 * ������ ���ڿ�(suffix)�� �������� �˻��Ѵ�.
		 * String file = "Hello.txt";
		boolean b = file.endsWith("txt");
		System.out.println("b = "+b);*/
		
		/*equals �޼ҵ�
		 * boolean equals(Object obj)
		 * �Ű������� ���� ���ڿ�(obj)�� String �ν��Ͻ��� ���ڿ��� ���Ѵ�.
		 * obj�� String�� �ƴϰų� ���ڿ��� �ٸ��� false�� ��ȯ�Ѵ�.
		 * String s= "Hello";
		boolean b = s.equals("Hello");
		boolean b2 = s.equals("hello");
		
		System.out.println("b = "+b);//true
		System.out.println("b2 = "+b2);//false
*/		
		/*equalsIgnoreCase �޼ҵ�
	 * 	boolean equalsIgnoreCase(String str)
	 * 	���ڿ��� String �ν��ϵ��� ���ڿ��� ��ҹ��� ���о��� ���Ѵ�.
	 * 	String s = "Hello";
		boolean b= s.equalsIgnoreCase("HELLO");
		boolean b2 = s.equalsIgnoreCase("heLLo");
		
		System.out.println("b = "+b); //true
		System.out.println("b2 = "+b2); //true
*/		
		/*indexof �޼ҵ�
		 * int indexOf(int ch)
		 * �־��� ����(ch)�� ���ڿ��� �����ϴ��� Ȯ���Ͽ� ��ġ(index)�� �˷��ش�.
		 * �� ã���� -1�� ��ȯ�Ѵ�(index�� 0���� ����)
		 * String s = "Hello";
		int idx1 = s.indexOf('o');
		int idx2 = s.indexOf('k');
		
		System.out.println("idx1 = "+idx1); //4
		System.out.println("idx2 = "+idx2);//'k'�� �����Ƿ� -1�� ����
*/	
		
		/*int indexOf(String str)
		 * �־��� ���ڿ��� �����ϴ� Ȯ���Ͽ� �� ��ġ(index)�� �˷��ش�.
		 * ������ -1�� ��ȯ
		 * String s = "ABCDEFG";
		int idx = s.indexOf("CD");  //2
		System.out.println("idx = "+idx);*/
		
		/*String intern()
		 * ���ڿ��� constant pool�� ����Ѵ�.
		 * �̹� constant pool�� ���� ������ ���ڿ��� ���� ���
		 * �� ���ڿ��� �ּҰ��� ��ȯ
		 * String s= new String("abc");
		String s2 = new String("abc");
		boolean b = (s==s2);
		boolean b2 = (s.equals(s2));
		boolean b3 = s.intern()==s2.intern();
		
		System.out.println("b = "+b); //false
		System.out.println("b2 = "+b2); //true
		System.out.println("b3 = "+b3); //true
		*/
		
		/*int lastIndexOf(int ch)
		 * ������ ���� �Ǵ� �����ڵ带 ���ڿ��� ������ ���������� ã�Ƽ� ��ġ(index)�� �˷��ش�.
		 * �� ã���� -1�� ��ȯ�Ѵ�.
		 * String s = "java.lang.Object";
		int idx1 = s.lastIndexOf('.');
		int idx2 = s.indexOf('.');
		
		System.out.println("idx1 = "+idx1); //9
		System.out.println("idx2 = "+idx2); //4
*/		
		/*int lastIndexOf(String str)
		 * ������ ���ڿ��� �ν��Ͻ��� ���ڿ� ���������� ã�Ƽ� ��ġ(index)�� �˷��ش�.
		 * ��ã���� -1�� ��ȯ�Ѵ�.
		String s = "java.lang.java";
		int idx1 = s.lastIndexOf("java");
		int idx2 = s.indexOf("java");
		
		System.out.println("idx1 = "+idx1);//10
		System.out.println("idx2 = "+idx2);//0
*/	
		/*int length();
		���ڿ��� ���̸� �˷��ش�.
		String s = "Hello";
		int length = s.length();
		System.out.println(length);//5
*/	
		/*String replace(char old, char nw)
		 * ���ڿ� ���� ����(old)�� ���ο� ����(nw)�� �ٲ� ���ڿ��� ��ȯ�Ѵ�.
		 * String s = "Hello";
		String s1 = s.replace('H', 'C');
		System.out.println("s1 = "+s1);*/
		
		/*String replace(CharSequence old, CharSequence nw)
		 * ���ڿ� ���� ���ڿ�(old)�� ���ο� ���ڿ�(nw)�� ��� �ٲ� ���ڿ��� ��ȯ�Ѵ�.
		 * String s = "Hellollo";
		String s1 = s.replace("ll", "LL");
		
		System.out.println("s1 = "+s1);*/
		
		/*String replaceALL(String regex, String replacement)
		���ڿ� �߿��� ������ ���ڿ�(regex)�� ��ġ�ϴ� ���� 
		���ο� ���ڿ�(replacement)�� ��� �����Ѵ�.
		String ab = "AABBAABB";
		String r = ab.replaceAll("BB", "bb");
		System.out.println("r = "+r);*/
		
		/*String replaceFirst(String regex, String replacement)
		���ڿ� �߿��� ������ ���ڿ�(regex)�� ��ġ�ϴ� �� ��,
		ù ��° �͸� ���ο� ���ڿ�(replacement)�� �����Ѵ�.
		String ab = "AABBAABB";
		String r = ab.replaceFirst("BB", "bb");
		System.out.println("r = "+r);  //AAbbAABB
*/		
		
		/*String[] split(String regex)
		���ڿ��� ������ �и���(regex)�� ������ ���ڿ� �迭�� ��� ��ȯ
		String animals = "dog, cat, bear";
		String[] arr = animals.split(", ");
		
		for(int i=0; i<arr.length;i++) {
			System.out.println("arr["+i+"] = "+arr[i]);
		}//dog, cat, bear
*/	
		/*String animals = "dob, cat, bear";
		String[] arr = animals.split(", ",2);
		System.out.println(arr[0]); //dog 
		System.out.println(arr[1]); //cat,bear
*/		
		/*String s = "java.lang.Object";
		boolean b = s.startsWith("java");
		boolean b2 = s.startsWith("lang");
		System.out.println(b);//true
		System.out.println(b2);//false
*/		
		/*String s = "java.lang.Object";
		String c = s.substring(10);
		String p = s.substring(5, 9);
		System.out.println(c);//Object
		System.out.println(p);//lang
*/		
		/*String s = "Hello";
		String s1 = s.toLowerCase();
		System.out.println(s1); //hello
*/		
		/*String s = "Hello";
		String s1 = s.toUpperCase();
		System.out.println(s1);//HELLO
*/		
		/*String s = "Hello";
		String s1 = s.toString();
		System.out.println(s1); //Hello
*/		
		/*String s = "    Hello World  ";
		String s1 = s.trim();
		System.out.println(s1);//Hello World 
		//���� ���� ������ �� ���� ����
*/		
		//static String valueof()
		//������ ���� ���ڿ��� ��ȯ�Ͽ� ��ȯ�Ѵ�.
	}
	

}
