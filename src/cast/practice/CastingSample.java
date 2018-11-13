package cast.practice;
import java.util.*;
import java.lang.Integer;


public class CastingSample {
	
	public void printUniCode() {
		
		System.out.print("문자 입력 : ");
		char a =  new Scanner(System.in).next().charAt(0);
		System.out.println("A is unicode : "+(int)a);
	}
	
	public void calculatorScore() {
		
		System.out.print("국어 : ");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		System.out.print("영어 : ");
		double b = sc.nextDouble();
		System.out.print("수학 : ");
		double c = sc.nextDouble();
		
		System.out.println("총점 : "+(int)(a+b+c));
		System.out.println("평균 : "+(int)(a+b+c)/3);
		
	}
	
	public void printBitCount() {
		System.out.print("정수 입력 : ");
		int a = new Scanner(System.in).nextInt();
		
		String c=Integer.toBinaryString(a); //a 입력 값의 2진수
		System.out.println(a+"의 2진수 값 : "+c);
		
		int b=Integer.bitCount(a);	 //2진수에 포함된 1의 갯수
		System.out.println(b+"의 2진수에 포함된 1의 갯수 : " +a);
		
		
	}
}
