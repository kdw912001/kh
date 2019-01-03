package test.string.method;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class TestImmutable {

	public static void main(String[] args) {
		// String is immutable.
		//문자열 저장소에 기록된 문자열값은
		//수정불가능
		String s = "java";
		String s2 = new String("java");
		
		System.out.println("s == s2 : "
				+ (s == s2));
		System.out.println("hashCode() 비교 : "
				+ (s.hashCode() == s2.hashCode()));
		
		//문자열저장소는 한번 기록된 문자열값
		//두 번 기록하지 않는다.
		//이미 기록된 문자열값의 위치를 리턴함
		System.out.println("s : " + s.hashCode());
		System.out.println("s2 : " + s2.hashCode());
		
		//문자열저장소에 기록된 문자열값은
		//변경못함 : immutable
		String s3 = s.toUpperCase();
		System.out.println("s : " + s);
		System.out.println("s3 : " + s3);
		System.out.println("s3 : " + s3.hashCode());
	}

}





