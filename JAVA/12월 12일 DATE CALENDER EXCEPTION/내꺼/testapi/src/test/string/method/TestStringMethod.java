package test.string.method;

public class TestStringMethod {

	/*public static void main(String[] args) {
		// java.lang.String 클래스가 제공하는
		//메소드 사용 테스트
		String s = "";
		//초기값으로 빈 따옴표 (empty string) 사용가능
		System.out.println("글자 갯수 : " + s.length()); // 0
		//빈 따옴표의 문자 갯수는 0개
		//Nullescape 전까지 카운트 하므로 0개
		//nullescape은 c에서 언급되고 자바에선 자동으로 처리하기 때문에 언급 없음
		
		//char ch = ''; //에러
		//문자는 빈 따옴표 사용 못 함.->공백문자로 사용 
		//공백문자도 유니코드를 가진 하나의 문자
		
		String s1 = null; //일반적으로 null로 초기화
		if(s1 != null && s1.length() >0) //글자가 있어야한다는 조건
			System.out.println(s1.length()); //조건식 없이 사용하면 
						//null.length()이므로 에러
						//에러내용 : java.lang.NullPointerException
		//문자열에서 NullPointerException 자주 발생
		else
			System.out.println("문자열값이 필요합니다.");
		
		s1 = "apple";
		System.out.println(s1.length());

	}*/
	/*String 생성자 
	 * public static void main(String[]args) {
		String s1 = "apple";
		String s2 = new String("banana");
		
		byte[] bar = {74, 65, 86 ,65}; 
		//정수를 문자열로 연결시켜려면 유니코드 이용
		// J A V A
		String s3 = new String(bar);
		//API String 클래스의 생성자를 확인해보면
		//String(byte[] bytes)
		char[] car = {'o','r','a','c','l','e'};
		String s4 = new String(car);
		//String(char[] value)
		
		int[] iar = {74, 65, 86 ,65};
		String s5 = new String(iar, 0 ,iar.length);
		//API에서 String 클래스의 생성자를 확인해보면
		//String(int[] codePoints, int offset(시작점), int count(끝까지)
		
		StringBuilder sb = new StringBuilder("html5 & css3");
		String s6 = new String(sb);
		////String(StringBuilder builder)
		
		System.out.println("s1 : "+s1.toString());
		//Object클래스의 toString메소드를 오버라이딩되어 있어 문자열값 출력
		//return : the string itself. 
		//출력구문에서 레퍼런스만 써도 자동으로 toString 됨.
		System.out.println("s2 : "+s2);
		System.out.println("s3 : "+s3);
		System.out.println("s4 : "+s4);
		System.out.println("s5 : "+s5);
		System.out.println("s6 : "+s6);
		
	}*/
	
	//String 메소드 ->암기하려 하지말고 API를 보면서 캡슐화와 연결하여 공부
	public static void main(String[] args) {
		/*charAt메소드
		 * char charAt(int index)
		 * 지정된 위치(index)에 있는 문자를 알려준다(index는 0부터 시작)
		 * String s = "Hello";
		String n= "0123456";
		char c = s.charAt(1);
		char c2 = n.charAt(1);
		
		System.out.println("c = "+c);
		System.out.println("c = "+c2);*/
		
		/*concat 메소드
		 * String concat(String str)
		 * 문자열(str)을 뒤에 덧붙인다
		 * String s = "Hello";
		String s2 = s.concat(" World");
		System.out.println("s2 = "+s2);*/
		
		/*contains 메소드
		 * boolean contains(CharSequence s)
		 * 지정된 문자열(s)이 포함되었는지 검사한다.
		 * String s = "abcdfg";
		boolean b = s.contains("bc");
		System.out.println("b = "+b);*/
		
		/*endWith 메소드
		 * boolean endsWith(String suffix)
		 * 지정된 문자열(suffix)로 끝나는지 검사한다.
		 * String file = "Hello.txt";
		boolean b = file.endsWith("txt");
		System.out.println("b = "+b);*/
		
		/*equals 메소드
		 * boolean equals(Object obj)
		 * 매개변수로 받은 문자열(obj)과 String 인스턴스의 문자열을 비교한다.
		 * obj가 String이 아니거나 문자열이 다르면 false를 반환한다.
		 * String s= "Hello";
		boolean b = s.equals("Hello");
		boolean b2 = s.equals("hello");
		
		System.out.println("b = "+b);//true
		System.out.println("b2 = "+b2);//false
*/		
		/*equalsIgnoreCase 메소드
	 * 	boolean equalsIgnoreCase(String str)
	 * 	문자열과 String 인스턴드의 문자열을 대소문자 구분없이 비교한다.
	 * 	String s = "Hello";
		boolean b= s.equalsIgnoreCase("HELLO");
		boolean b2 = s.equalsIgnoreCase("heLLo");
		
		System.out.println("b = "+b); //true
		System.out.println("b2 = "+b2); //true
*/		
		/*indexof 메소드
		 * int indexOf(int ch)
		 * 주어진 문자(ch)가 문자열에 존재하는지 확인하여 위치(index)를 알려준다.
		 * 못 찾으면 -1을 반환한다(index는 0부터 시작)
		 * String s = "Hello";
		int idx1 = s.indexOf('o');
		int idx2 = s.indexOf('k');
		
		System.out.println("idx1 = "+idx1); //4
		System.out.println("idx2 = "+idx2);//'k'가 없으므로 -1이 리턴
*/	
		
		/*int indexOf(String str)
		 * 주어진 문자열이 존재하는 확인하여 그 위치(index)를 알려준다.
		 * 없으면 -1을 반환
		 * String s = "ABCDEFG";
		int idx = s.indexOf("CD");  //2
		System.out.println("idx = "+idx);*/
		
		/*String intern()
		 * 문자열을 constant pool에 등록한다.
		 * 이미 constant pool에 같은 내용의 문자열이 있을 경우
		 * 그 문자열의 주소값을 반환
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
		 * 지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 위치(index)를 알려준다.
		 * 못 찾으면 -1을 반환한다.
		 * String s = "java.lang.Object";
		int idx1 = s.lastIndexOf('.');
		int idx2 = s.indexOf('.');
		
		System.out.println("idx1 = "+idx1); //9
		System.out.println("idx2 = "+idx2); //4
*/		
		/*int lastIndexOf(String str)
		 * 지정된 문자열을 인스턴스의 문자열 끝에서부터 찾아서 위치(index)를 알려준다.
		 * 못찾으면 -1을 반환한다.
		String s = "java.lang.java";
		int idx1 = s.lastIndexOf("java");
		int idx2 = s.indexOf("java");
		
		System.out.println("idx1 = "+idx1);//10
		System.out.println("idx2 = "+idx2);//0
*/	
		/*int length();
		문자열의 길이를 알려준다.
		String s = "Hello";
		int length = s.length();
		System.out.println(length);//5
*/	
		/*String replace(char old, char nw)
		 * 문자열 중의 문자(old)를 새로운 문자(nw)로 바꾼 문자열을 반환한다.
		 * String s = "Hello";
		String s1 = s.replace('H', 'C');
		System.out.println("s1 = "+s1);*/
		
		/*String replace(CharSequence old, CharSequence nw)
		 * 문자열 중의 문자열(old)을 새로운 문자열(nw)로 모두 바꾼 문자열을 반환한다.
		 * String s = "Hellollo";
		String s1 = s.replace("ll", "LL");
		
		System.out.println("s1 = "+s1);*/
		
		/*String replaceALL(String regex, String replacement)
		문자열 중에서 지정된 문자열(regex)과 일치하는 것을 
		새로운 문자열(replacement)로 모두 변경한다.
		String ab = "AABBAABB";
		String r = ab.replaceAll("BB", "bb");
		System.out.println("r = "+r);*/
		
		/*String replaceFirst(String regex, String replacement)
		문자열 중에서 지정된 문자열(regex)과 일치하는 것 중,
		첫 번째 것만 새로운 문자열(replacement)로 변경한다.
		String ab = "AABBAABB";
		String r = ab.replaceFirst("BB", "bb");
		System.out.println("r = "+r);  //AAbbAABB
*/		
		
		/*String[] split(String regex)
		문자열을 지정된 분리자(regex)로 나누어 문자열 배열로 담아 반환
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
		//왼쪽 끝과 오른쪽 끝 공백 지움
*/		
		//static String valueof()
		//지정된 값을 문자열로 변환하여 반환한다.
	}
	

}
