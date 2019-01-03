package test.string.method;

public class TestStingBuilder {

	public static void main(String[] args) {
		// mutable : 기록된 문자열값 변경가능
		// StringBuffer : 스래드 safe 기능 있음
		// String Builder : 스래드 safe 기능 없음
		StringBuilder sb = new StringBuilder();//java.lang 패키지 이기 때문에 import할 필요 없음
		
		System.out.println("저장용량 : " + sb.capacity()+" 글자");
		System.out.println("sb : "+sb.hashCode());
		
		StringBuilder sb2 = sb.append("java");
		sb2 = sb.append(8.5);
		sb2 = sb.append(' ');
		sb2 = sb.append(true);
		sb2 = sb.append(10);
		
		System.out.println("sb2 : "+sb2.hashCode()); //sb와 sb2 같은 주소
		
		System.out.println("글자갯수 : "+sb.length());
		System.out.println("sb : "+sb);
		sb.delete(2, 6);
		System.out.println("sb : "+sb);
		
		char[] dst = new char[5];
		sb.getChars(0, 5, dst, 0);   
		for(int i=0; i<dst.length;i++) {
			System.out.print(dst[i]+"-");
		}
		System.out.println();
		
		sb.insert(3, "oracle"); //3번 인덱스에 "oracle"추가
		System.out.println("sb : "+sb);
		sb.reverse();//글자가 뒤집어짐
		System.out.println("sb : "+sb);
		
		sb.setCharAt(7, 'A'); //7번 인덱스에 'A'를 set함.
		System.out.println("sb : "+sb);
		
		//sb ---> String  
		//StringBuilder를 String으로 바꾸는 2가지 방법이 있음
		String ss = sb.toString(); //toString
		String ss2 = new String(sb); //새로운 객체 선언
		System.out.println("ss : "+ss.toUpperCase());
	}

}
