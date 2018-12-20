package test.generic;

import java.util.*;

public class TestSetGeneric {
	
	public HashSet<String> makeSet(){
		HashSet<String> hset = 
				new HashSet<String>();
		
		hset.add("java 8");
		hset.add("oracle 11g");
		hset.add("html5");
		hset.add("css3");
		//hset.add(new Date());
		
		return hset;
	}

	public void printSet(HashSet<String> hset) {
		
		Iterator<String> iter = hset.iterator();
		
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		// Set Generic test
		TestSetGeneric test = 
				new TestSetGeneric();
		HashSet<String> hs = test.makeSet();
		test.printSet(hs);
	}

}






