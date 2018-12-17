package practice1;

import java.util.*;

public class Lotto {
	public static void lottoDisplay() {
		TreeSet tset = new TreeSet();//treeset은 자동정렬
		for(int i=0; i<6;i++) {
			tset.add((int)(Math.random()*45)+1);
		}
		System.out.println(tset);
		Iterator it = tset.iterator();
		int []arr = new int[tset.size()];
		int count=0;
		while(it.hasNext()) {
			arr[count]=(int) it.next();
			System.out.print(arr[count]+ " ");
			count++;
		}
		System.out.println();
		
		//선생님 방식
		TreeSet lottoNumbers = new TreeSet();
		Random r = new Random();
		while(true) {
			lottoNumbers.add(r.nextInt(45)+1);
			if(lottoNumbers.size()==6) break;
		}
		System.out.println(lottoNumbers);
		Object[] numbers = lottoNumbers.toArray();
		int[] ar = new int[lottoNumbers.size()];
		
		for(int i=0; i<ar.length;i++) {
			ar[i] = (Integer)numbers[i]; //Object를 Integer로 형변환
			System.out.print(ar[i]+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		lottoDisplay();
	}

}
