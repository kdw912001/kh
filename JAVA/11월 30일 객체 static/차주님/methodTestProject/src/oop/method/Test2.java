package oop.method;

public class Test2 {

	public static void main(String[] args) {
		// NonStatic 메소드 실습 2
		NonStaticSample samp = 
				new NonStaticSample();
		/*
		int[] iar = samp.intArrayAllocation(5);
		samp.display(iar);
		
		//samp.swap(iar, 0, 1);
		samp.sortDescending(iar);
		samp.display(iar);
		
		samp.sortAscending(iar);
		samp.display(iar);*/
		
		/*int count = samp.countChar("java oracle", 'a');
		System.out.println("포함된 글자갯수 : "
				+ count);*/
		
		/*int total = samp.totalValue(24, 12);
		System.out.println("12 + ... + 24 : "
				+ total);*/
		
		/*String str = "java oracle";
		char c = samp.pCharAt(str, 2);
		System.out.println("index 2 의 글자 : " + c);
		
		System.out.println("[2] : " + 
		     samp.pCharAt("java oracle",  2));*/
		
		String result = samp.pConcat(
					"oracle", " database");
		System.out.println(result);
	}

}








