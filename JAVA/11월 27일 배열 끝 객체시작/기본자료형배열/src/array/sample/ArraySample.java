﻿package array.sample;

import java.util.Random;
import java.util.Scanner;

//기본(Primitive) 자료형 배열 테스트용
public class ArraySample {
	public void testArray1() {
		//1. 배열 선언
		//배열공간의 주소기록용 레퍼런스변수 만들기
		//자료형[] 배열명;
		//배열명 == 레퍼런스 변수
		int[] ar;
		int []arr;
		int ar2[];
		
		//2. 배열생성
		//힙에 배열공간 만들고, 시작주소를 
		//레퍼런스에 기록 처리
		//배열레퍼런스 = new 자료형[갯수];
		ar = new int[5];
		
		System.out.println("ar 이 가진 주소 : "+ar.hashCode());
		System.out.println("ar이 참조하는 위치의 배열방의 갯수 : "+ar.length);
	
		for(int index = 0; index < ar.length; index++) {
			System.out.println("ar[" + index + "] :" + ar[index]);
		}
		
		//1~100사이의 임의의 정수를
		//인덱스 순서대로 기록해 넣음
		
		Random r = new Random();
		/*ar[0] = r.nextInt(100) + 1;
		ar[1] = r.nextInt(100) + 1;
		ar[2] = r.nextInt(100) + 1;
		ar[3] = r.nextInt(100) + 1;
		ar[4] = r.nextInt(100) + 1;*/
		for(int i=0; i<ar.length; i++) {
			ar[i] = r.nextInt(100)+1;
		}
		
		for(int index = 0; index < ar.length; index++) {
			System.out.println("ar[" + index + "] :" + ar[index]);
		}
	}
	public void test1() {
		Random r = new Random();
		int[]ar=new int[10];
		int sum=0, i;
		for(i=0; i<ar.length;i++) {
			ar[i]=r.nextInt(100)+1;
			sum+=ar[i];
		}
		
		//출력확인
		System.out.print("ar : ");
		for(i=0; i<ar.length; i++) {
			System.out.print(ar[i]+ "  ");
		}
		System.out.println();
		System.out.println("합계 : "+ sum);
	}
	
	public void test2() {
		int[]ar=new int[10];
		int max, min, i;
		
		//값 기록
		for(i=0;i<ar.length;i++) {
			ar[i]=(int)(Math.random()*100)+1;		
			System.out.print(ar[i]+" ");
		}
		
		max = min = ar[0];
		// 가장 큰 값과 가장 작은 값 찾기
		System.out.println();
		for(i=1;i<ar.length;i++) {
			if(ar[i]>max)
				max=ar[i];
			if(ar[i]<min)
				min=ar[i];
		}
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public void test3() {
		byte[] ar=new byte[10];
		int sum=0,i;
		Random r= new Random();
		
		r.nextBytes(ar);
		
		System.out.print("ar : ");
		for(i=0;i<ar.length;i++) {
			System.out.print(ar[i]+ " ");
			if(ar[i]%2==0)
				sum+=ar[i];
		}
		System.out.println();
		System.out.println("짝수들의 합 : "+sum);
		
	}
	
	public void test4() {
		String[] ar = new String[1];
		Scanner sc= new Scanner(System.in);
		ar[0]=sc.next();
		ar[0].toCharArray();
	    int sum=0, i;
	    for(i=0;i<ar[0].length();i++) {
	       	sum+=ar[0].charAt(i)-48;
	     }
	    System.out.println(sum);
	}
	
	public void test44() { //강사님 하신것
		System.out.print("문자열 입력 : ");
		String numbers = new Scanner(System.in).next();
		
		char[] numChars = numbers.toCharArray(); //String->Char
		
		int sum=0;
		
		for(int i=0;i<numChars.length;i++) {
			System.out.print(numChars[i]+"  ");
			sum+=numChars[i]-48;
		}
		System.out.println();
		System.out.println("합계 : "+sum);
	}
	//배열 실습문제5
	public void test5() {
		//숫자로 된 문자열 입력받음
		System.out.print("숫자로 된 문자열 입력 : ");
		String numbers = new Scanner(System.in).next();
		//입력된 글자갯수만큼 char[] 할당함
		char[] car = new char[numbers.length()];
		//문자열값 하나씩을 char[]에 기록함
		//char charAt(index) 사용함
		for(int i=0; i<car.length; i++) {
			car[i] = numbers.charAt(i);
		}
		//char[]갯수만큼 int[] 할당하고
		//char[]에 기록된 숫자문자를 하나씩
		//int[]에 숫자로 옮겨 기록함
		//'2'->2
		int[] iar = new int[car.length];
		for(int i=0;i<iar.length;i++) {
			iar[i]=car[i]-48;
		}
		//int[]에 기록된 값과 합계를 구함
		int sum=0;
		for(int i=0; i<iar.length; i++) {
			System.out.print(iar[i]+" ");
			sum +=iar[i];
		}
		System.out.println();
		
		System.out.println("합계 : "+sum);
		
		/*내가 한거
		 * System.out.print("문자열 입력 : ");
		String str = new Scanner(System.in).next();
		char[] ch = new char[str.length()];
		int i;
		for(i=0;i<str.length();i++) {
			ch[i]=str.charAt(i);
			System.out.print(ch[i]+"   ");
		}
		System.out.println();
		int[] in = new int[str.length()];
		for(i=0;i<str.length();i++) {
			in[i]=ch[i]-48;
			System.out.print(in[i]+"  ");
		}*/
	}
	
	//배열의 초기화 테스트용
	public void testArrayInit() {
		//자료형[] 배열레퍼런스 = {값, 값, 값, 값};
		//int[] iar = {12,5,34,17,55};
		int[] iar = new int[] {12,5,34,17,55};//new int[]에서 []사이에 값 넣으면 에러남
		
		System.out.println("방 갯수 : "+iar.length);
		for(int i=0;i<iar.length;i++) {
			System.out.println(iar[i]);
		}
	}
	
	public void Swap() {
		int a=12, b=23;
		System.out.println("before : ");
		System.out.println("a : "+a+", b : "+b);
		
		int tmp=a;
		a=b;
		b=tmp;
		
		System.out.println("after ; ");
		System.out.println("a : "+a+", b :"+b);
		
	}
	/*10개의 정수를 기록할 배열 공간 할당,
	 * 1~100사이의 난수를 배열공간에 기록,
	 * 정수를 하나 입력받아,
	 * 배열 안에 입력값이 존재하는지 검색함.
	 * 일치하는 있으면,"몇번째 위치에 기록"
	 * 다 검색했는데 일치하는 값이 없으면
	 * "값이 존재하지 않습니다."출력처리
	 */
	public void test6() {
		int[] ar=new int[10];
		for(int i=0; i<ar.length;i++) {
			ar[i]=(int)(Math.random()*100)+1;
			System.out.print(ar[i]+"  ");
		}
		System.out.println();
		System.out.print("몇 번째 위치에 있는지 확인할 값: ");
		int num = new Scanner(System.in).nextInt();
		for(int i=0; i<ar.length;i++) {
			
			if(ar[i]==num) {
				System.out.println(i+"번째 위치");
				break;
			}
			else {
				if(i==ar.length-1)
					System.out.println("값이 존재하지 않습니다.");
		
			}
		}
	}
	
	/*문자열을 입력받아 char[]로 바꿈
	 * 키보드로 index(순번)을 입력받아,
	 * 순번 위치의 문자의 유니코드를 출력
	 * 단, 마지막 인덱스를 초과한 정수가
	 * 입력되면 "배열 인덱스 범위를 초과함"
	 * 출력되게함.
	 * 
	 */
	public void test7() {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] ch=str.toCharArray();
		int index = sc.nextInt();
		
		
		if(index>=str.length())
			System.out.println("배열 인덱스 범위를 초과함");
		else
			System.out.println("["+index+"]"+"위치의 문자의 유니코드는"+(int)ch[index]);
	}
	
	
}
