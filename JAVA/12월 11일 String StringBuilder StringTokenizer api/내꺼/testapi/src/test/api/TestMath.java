package test.api;

public class TestMath {
	public static void main(String[]args) {
		//java.lang.Math 클래스의 메소드 테스트
		
		/*abs() 절대값
		 * int i=Math.abs(-10);
		double d = Math.abs(-10.0);
		System.out.println(i);//10
		System.out.println(d);//10.0
*/
		/*ceil 올림
		double d = Math.ceil(10.1);
		double d2 = Math.ceil(-10.1);
		double d3 = Math.ceil(10.0000015);
		System.out.println(d); //11.0
		System.out.println(d2); //-10.0
		System.out.println(d3); //11.0
*/	
		
		/*floor 버림
		 * double d = Math.floor(10.8);
		double d2 = Math.floor(-10.8);
		System.out.println(d); //10.0
		System.out.println(d2); //-11.0
*/	
		/*min 작은값
		 * double d = Math.max(9.5, 9.50001);
		int i= Math.min(0, -1);
		System.out.println(d);
		System.out.println(i);*/
		
		/*max 큰값
		 * double d = Math.max(9.5, 9.500001);
		int i=Math.max(0, -1);
		System.out.println(d);
		System.out.println(i);*/
		
		/*double d = Math.random();
		int i= (int)(Math.random()*10)+1;
		System.out.println(d);//0.0~1.0의 실수
		System.out.println(i);//1~10의 정수
*/		
		/*static double rint(double a)
		 * 주어진 double값과 가장 가까운 정수값으로 double형으로 반환
		 * double d = Math.rint(5.55);
		double d2 = Math.rint(5.11);
		double d3 = Math.rint(-5.55);
		double d4 = Math.rint(-5.11);
		System.out.println(d);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);*/
		
		/*round 소수점 첫째자리에서 반올림한 정수값을 반환한다
		 * long l =Math.round(5.55);
		long l2 = Math.round(5.11);
		long l3 = Math.round(-5.55);
		long l4 = Math.round(-5.11);
		double d = 90.7552;
		double d2 = Math.round(d*100)/100.0;
		System.out.println(l);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(l4);
		System.out.println(d);
		System.out.println(d2);*/
		
	}
}
