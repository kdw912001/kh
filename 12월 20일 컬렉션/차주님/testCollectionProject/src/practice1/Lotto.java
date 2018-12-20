package practice1;

import java.util.*;

public class Lotto {
	//컬렉션 실습문제1
	public static void lottoDisplay(){
		TreeSet lottoNumbers = 
				new TreeSet();
		Random r = new Random();
				
		while(true){
			lottoNumbers.add(r.nextInt(45) + 1);
			if(lottoNumbers.size() == 6)		
				break;
		}
		
		Object[] numbers = lottoNumbers.toArray();
		int[] ar = new int[lottoNumbers.size()];
		
		for(int i = 0; i < ar.length; i++){
			ar[i] = (Integer)numbers[i]; 
			//Auto UnBoxing
			System.out.print(ar[i] + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		lottoDisplay();
	}

}
