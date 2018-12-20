package test.properties;

import java.util.*;
import java.io.*;

public class TestProperties3 {

	public static void main(String[] args) {
		//Properties file load test 2
		Properties profile = new Properties();
		
		try {
			profile.load(new FileReader("sample.txt"));
			//txt파일이기 때문에 Reader로 읽음
			profile.list(System.out);
			
			String name = profile.getProperty("name");
			int age = Integer.parseInt(profile.getProperty("age"));
			char gender = profile.getProperty("gender").charAt(0);
			double height = Double.parseDouble(profile.getProperty("height"));
			
			System.out.println(name+", "+age+"세, "+gender+"자, "+height+" cm");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
