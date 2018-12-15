package oop.run;

import oop.method.NonStaticSample;

public class NonStaticSampleTest {

	public static void main(String[] args) {
		NonStaticSample nssamp=new NonStaticSample();
		
		System.out.print("배열의 주소 : ");
		System.out.println(nssamp.intArrayAllocateion(5));
		System.out.println();
		
		System.out.println("1~100까지 임의의 정수를 배열10개에 입력");
		int[] ar = new int[10];
		for(int i=0; i<ar.length;i++) {
			ar[i]=(int)(Math.random()*100)+1;
		}
		nssamp.display(ar);
		System.out.println();
		
		System.out.println("첫번째 숫자와 마지막 숫자 교환");
		nssamp.swap(ar, 0, 9);
		nssamp.display(ar);
		System.out.println();
		
		System.out.println("배열 내림차순 정렬");
		nssamp.sortDescendint(ar);
		nssamp.display(ar);
		System.out.println();
		
		System.out.println("배열 오름차순 정렬");
		nssamp.sortAscending(ar);
		nssamp.display(ar);
		System.out.println();
		
		
		System.out.println(nssamp.countChar("appleeip", 'p'));
		
		System.out.println(nssamp.totalValue(1, 100));
		
		System.out.println(nssamp.pCarAt("apple",4));
		
		System.out.println(nssamp.pConcat("김", "동욱"));
	}

}
