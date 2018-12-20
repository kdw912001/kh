package test.properties;

import java.util.*;
import java.io.*;

public class TestProperties4 {

	public static void main(String[] args) {
		// Properties loop test
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("setting.txt"));
			
			Set<String> keys = 
					prop.stringPropertyNames();
			Iterator<String> keyIter = keys.iterator();
			
			while(keyIter.hasNext()) {
				String key = keyIter.next();
				String value = prop.getProperty(key);
				System.out.println(key + "=" + value);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
