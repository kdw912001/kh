package logic.home.model;
import java.lang.*;

public class PrimitiveTypeSample {
	public void typeSize() { //기본자료형 메모리 할당크기 확인
				
		System.out.println("기본 자료형 메모리 할당크기입니다.");
		System.out.println();
		System.out.println("char : "+Character.BYTES);
		System.out.println("byte : "+Byte.BYTES);
		System.out.println("short : "+Short.BYTES);
		System.out.println("long : "+Long.BYTES);
		System.out.println("florst : "+Float.BYTES);
		System.out.println("double : "+Double.BYTES);		
	}
	
	public void minMaxValue() { //기본자료형 값의 최소값, 최대값 출력
		
		System.out.println("기본자료형 값의 최소값, 최대값입니다.");
		System.out.println();
		System.out.println("최소값 : "+Character.MIN_VALUE +"최대값 : "+Character.MAX_VALUE);
		System.out.println("최소값 : "+Byte.MIN_VALUE +"최대값 : "+Byte.MAX_VALUE);
		System.out.println("최소값 : "+Short.MIN_VALUE +"최대값 : "+Short.MAX_VALUE);
		System.out.println("최소값 : "+Long.MIN_VALUE +"최대값 : "+Long.MAX_VALUE);
		System.out.println("최소값 : "+Float.MIN_VALUE +"최대값 : "+Float.MAX_VALUE);
		System.out.println("최소값 : "+Double.MIN_VALUE +"최대값 : "+Double.MAX_VALUE);
	}
	public void bitSize() { //기본자료형 비트갯수 확인
		System.out.println();
		System.out.println(Byte.SIZE);
		System.out.println(Short.SIZE);
		System.out.println(Long.SIZE);
		System.out.println(Float.SIZE);
		System.out.println(Double.SIZE);
		
			
	}
	
}
