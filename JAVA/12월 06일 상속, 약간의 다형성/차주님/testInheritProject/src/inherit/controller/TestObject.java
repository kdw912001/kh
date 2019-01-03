package inherit.controller;

import inherit.vo.ObjectOverriding;

public class TestObject {

	public static void main(String[] args) {
		// Object method overriding test
		ObjectOverriding test = 
			new ObjectOverriding();
		test.testObjectMethod();
		
		/*System.out.println("test : " + test.hashCode());
		System.out.println("test.toString() : " + test.toString());
		
		ObjectOverriding o2 = test;
		
		System.out.println(test.equals(o2));*/

	}

}





