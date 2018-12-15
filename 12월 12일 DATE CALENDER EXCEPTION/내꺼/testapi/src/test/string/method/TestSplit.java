package test.string.method;

public class TestSplit {

	public static void main(String[] args) {
		// 하나의 문자열을 토큰문자를 기준으로 
		// 여러 개의 문자열로 분리하는 것
		String s = "red yellow green blue purple";
		String[] sar = s.split(" "); //split 반환형이 String[]배열
		System.out.println("분리된 문자열 갯수 : "+sar.length);
		
		//객체배열과 컬렉션은 for each문 사용할 수 있음
		/* for(클래스명 레퍼런스 변수 : 배열명){
		 * 			레퍼런스변수.메소드();
		 * }
		 */
		for(String ref : sar) {
			System.out.println(ref); //하나씩 출력
		}
		
		System.out.println("-----------");
		String s2 = "java,oracle,jdbc";
		String[] sar2 = s2.split(",");
		for(String sref : sar2) {
			System.out.println(sref);
		}
		
		System.out.println("------------");
		String s3 = "html5 css3,javascript&jquery#web";
		String[] sar3 = s3.split(" |,|&|#"); //비트or 연산자 | 로 구분
	  
		for(String sref2 : sar3) {
			System.out.println(sref2);
		}
		
		//java.lang.StringTokenizer 를 먼저 사용하다가 since JDK1.0
		//String 클래스의 split 사용함 since JDK1.4
		//token : 분리된 문자열 한 묶음
		

	}

}
