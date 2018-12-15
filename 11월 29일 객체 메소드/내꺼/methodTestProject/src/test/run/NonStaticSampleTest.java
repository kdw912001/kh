package test.run;

import test.method.NonStaticSample;

public class NonStaticSampleTest {

	public static void main(String[] args) {
		NonStaticSample nsamp = new NonStaticSample();
		nsamp.printLottoNumbers();
		
		nsamp.outputChar(3, 'A');
		System.out.println("·£´ý ¹®ÀÚ : "+nsamp.alphabette());
		
		System.out.println(nsamp.mySubstring("aaaa",0, 2));
	}

}
