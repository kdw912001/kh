package method.run;

import test.method.NonStaticSample;

public class TestNonStaticSample {

	public static void main(String[] args) {
		// non static method ½Ç½À1
		NonStaticSample samp = 
				new NonStaticSample();

		String result = samp.mySubstring("java program", 2, 8);
		System.out.println("result : " + result);
	}

}
