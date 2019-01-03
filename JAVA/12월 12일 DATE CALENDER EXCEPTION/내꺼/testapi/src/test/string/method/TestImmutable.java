package test.string.method;

public class TestImmutable {

	public static void main(String[] args) {
		// String is immutable.
		// 문자열 저장소에 기록된 문자열 값은 수정불가능
		String s = "java";
		String s2 = new String("java");
		System.out.println("s == s2 :"+(s==s2));
		System.out.println("hashCode() 비교 : " + (s.hashCode()==s2.hashCode()));
		//hashCode가 s가진 주소, s2가 가진 주소가 아니라
		//String값을 가진 주소값으로 오버라이딩 되어있다.
		//a hash code value for this object.->String클래스 hashCode() api
		
		//문자열 저장소는 한번 기록된 문자열값 두번 기록하지 않는다
		//이미 기록된 문자열 값의 위치를 리턴함
		System.out.println("s : "+ s.hashCode());
		System.out.println("s2 : "+s2.hashCode());
		
		//문자열 저장소에 기록된 문자열 값은 변경 못함 : immutable
		String s3 = s.toUpperCase();//s3는 새로 할당
		System.out.println("s : "+s);
		System.out.println("s3 : "+s3);
		System.out.println("s3 : "+s3.hashCode());//s와 다른 주소
		
	}

}
