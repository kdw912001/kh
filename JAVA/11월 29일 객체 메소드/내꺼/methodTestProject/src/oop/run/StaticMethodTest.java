package oop.run;

import oop.staticmethod.StaticMethod;

public class StaticMethodTest {

	public static void main(String[] args) {
		StaticMethod.toUpper();
		StaticMethod.setChar(1, 'p');
		System.out.println(StaticMethod.valueLength());
		System.out.println(StaticMethod.valueConcat("def"));
		
	}

}
