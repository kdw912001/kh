package test.properties;

import java.util.*;
import java.io.*;

public class TestProperties2 {

	public static void main(String[] args) {
		// Properties file load test
		Properties prop1 = new Properties();
		Properties prop2 = new Properties();
		
		try {
			prop1.load(new FileReader("setting.txt"));
			prop2.loadFromXML(new FileInputStream("setting.xml"));
			
			prop1.list(System.out);
			System.out.println("===================");
			prop2.list(System.out);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}






