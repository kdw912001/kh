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
	
	public static void testB() throws FileNotFoundException {//testB를 사용하는 위치로 예외를 넘김
		testC();
	}
	
	public static void testC() throws FileNotFoundException /*testC를 사용하는 위치로 예외를 넘김 B로*/{
		new java.io.FileInputStream("test.dat");//기본위치 프로젝트 폴더 안에서 이 파일을 찾음
	}
}
