package test.exception;

import java.io.FileNotFoundException;

public class TestThrows {

	public static void main(String[] args) throws FileNotFoundException {
		// throws test
		testA();
	}
	
	public static void testA() throws FileNotFoundException {
		testB();
	}
	
	public static void testB() throws FileNotFoundException {
		testC();
	}
	
	public static void testC() throws FileNotFoundException {
		new java.io.FileInputStream("test.dat");
	}

}







