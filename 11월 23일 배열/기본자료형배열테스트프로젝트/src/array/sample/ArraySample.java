package array.sample;

import java.util.Random;
import java.util.Scanner;

//기본(Primitive) 자료형 배열 테스트용
public class ArraySample {
	public void testArray1() {
		//1. 배열선언
		//배열공간의 주소기록용 레퍼런스변수 만들기 
		//자료형[] 배열명;
		//배열명 == 레퍼런스 변수
		int[] ar;  //주소기록
		int []arr;
		int ar2[];
		
		//2. 배열생성
		//힙에 배열공간 만들고, 시작주소를
		//레퍼런스에 기록 처리
		//배열레퍼런스 = new 자료형[갯수];
		ar = new int[5];
		
		System.out.println("ar 이 가진 주소 : " 
		+ ar.hashCode());
		System.out.println("ar이 참조하는 위치의 배열방의 갯수 : "
						+ ar.length);
		
		for(int index = 0; index < ar.length; index++) {
			System.out.println("ar[" + index + "] : " + ar[index]);
		}
		
		//1~100사이의 임의의 정수를 
		//인덱스 순서대로 기록해 넣음
		Random r = new Random();
		/*ar[0] = r.nextInt(100) + 1;
		ar[1] = r.nextInt(100) + 1;
		ar[2] = r.nextInt(100) + 1;
		ar[3] = r.nextInt(100) + 1;
		ar[4] = r.nextInt(100) + 1;*/
		
		//배열 추가 기록 알고리즘
		for(int i = 0; i <ar.length; i++) {
			ar[i] = r.nextInt(100) + 1;
		}
		
		for(int index = 0; index < ar.length; index++) {
			System.out.println("ar[" + index + "] : " + ar[index]);
		}
	}
	
	//배열 실습문제 1
	public void test1() {
		int[] ar = new int[10];
		Random r = new Random();
		int sum = 0, i;
		
		for(i = 0; i < ar.length; i++) {
			ar[i] = r.nextInt(100) + 1;
			sum += ar[i];
		}
		
		//출력확인
		System.out.print("ar : ");
		for(i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + "  ");
		}
		System.out.println();
		
		System.out.println("합계 : " + sum);
	}
	
	//배열 실습문제 2
	public void test2() {
		int[] intArr = new int[10];
		int max, min, i;
		
		//값 기록
		for(i = 0; i < intArr.length; i++) {
			intArr[i] = (int)(Math.random() * 100) + 1;
		}
		
		max = min = intArr[0];
		//가장 큰값과 가장 작은값 찾기
		for(i = 1; i < intArr.length; i++) {
			if(max < intArr[i])
				max = intArr[i];
			if(min > intArr[i])
				min = intArr[i];
		}
		
		//출력 확인
		System.out.print("intArr : ");
		for(i = 0; i < intArr.length; i++)
			System.out.print(intArr[i] + "  ");
		System.out.println();
		
		System.out.println("가장 큰 값 : " + max);
		System.out.println("가장 작은 값 : " + min);
	}
	
	//배열 실습문제 3
	public void test3() {
		byte[] bar = new byte[10];
		int sum = 0, i;
		Random r = new Random();
		
		r.nextBytes(bar);
		
		System.out.print("bar : ");
		for(i = 0; i < bar.length; i++) {
			System.out.print(bar[i] + "  ");
			if(bar[i] % 2 == 0) {
				sum += bar[i];
			}
		}		
		System.out.println();
		System.out.println("짝수들의 합 : " + sum);
	}
	
	//배열 실습문제 4
	public void test4() {
		System.out.print("숫자로 된 문자열 입력 : ");
		String numbers = new Scanner(System.in).next();
		
		char[] numChars = numbers.toCharArray();
		
		int sum = 0;
		for(int i = 0; i < numChars.length; i++) {
			System.out.print(numChars[i] + "   ");
			sum += numChars[i] - 48;
		}
		System.out.println();
		System.out.println("합계 : " + sum);
	}
	
	//배열 실습문제 5
	public void test5() {
		//숫자로 된 문자열 입력받음
		System.out.print("숫자로 된 문자열 입력 : ");
		String numbers = 
			new Scanner(System.in).next();
		
		//입력된 글자갯수만큼 char[] 할당함
		char[] car = new char[numbers.length()];
		
		//문자열값 하나씩을 char[]에 기록함
		//char charAt(index) 사용함
		for(int i = 0; i < car.length; i++) {
			car[i] = numbers.charAt(i);
		}
		
		//char[] 갯수만큼 int[] 할당하고
		//char[] 에 기록된 숫자문자를 하나씩
		//int[] 에 숫자로 옮겨 기록함
		//'2' -> 2
		int[] iar = new int[car.length];
		
		for(int i = 0; i < iar.length; i++) {
			iar[i] = car[i] - 48;
		}
		
		//int[] 에 기록된 값과 합계를 출력함
		int sum = 0;
		for(int i = 0; i < iar.length; i++) {
			System.out.print(iar[i] + " ");
			sum += iar[i];
		}
		System.out.println();
		
		System.out.println("합계 : " + sum);
	}
	
	//배열의 초기화 테스트용
	public void testArrayInit() {
		//자료형[] 배열레퍼런스 = {값, 값, 값, 값};
		//int[] iar = {12, 5, 34, 17, 55};
		int[] iar = new int[]{12, 5, 34, 17, 55};
		
		System.out.println("방갯수 : " + 
				iar.length);
		
		for(int i = 0; i < iar.length; i++) {
			System.out.println("iar[" 
					+ i + "] : " + iar[i]);
		}
	}
	
}









