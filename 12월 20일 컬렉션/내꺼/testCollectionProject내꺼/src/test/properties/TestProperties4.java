package test.properties;

import java.util.*;
import java.io.*;

public class TestProperties4 {

	public static void main(String[] args) {
		// Properties loop test
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("setting.txt"));
			
			Set<String> keys = prop.stringPropertyNames();//키만 따로 뺴는 메소드
			Iterator<String> keyIter = keys.iterator();
			while(keyIter.hasNext()) {
				String key = keyIter.next();
				String value = prop.getProperty(key);
				System.out.println(key + "=" + value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
