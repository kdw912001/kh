package test.properties;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class TestProperties1 {

	public static void main(String[] args) {
		// Properties test
		Properties prop = new Properties();

		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		//파일에 기록 시에 값 바로 앞에 공백 있으면 안되고 키 사이에 공백 있으면 안됨
		prop.setProperty("url", "jdbc:oracle:thin:@127.0.0.1:1521:xe");
		prop.setProperty("user", "user007");
		prop.setProperty("password", "pass007");

		prop.list(System.out);
		// properties에 저장된 값을 콘솔에 출력 맵은 키가 set방식으로 저장되다보니 저장순서 유지 안됨

		System.out.println("=======================");
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("user"));
		System.out.println(prop.getProperty("password"));

		// 파일에 기록 저장
		try {
			prop.store(new FileWriter("setting.txt"), "jdcb driver setting file");
			//public void store(OutputStream out, String comments) throws IOException
			//comments는 주석과 같은 개념(파일 설명)
			prop.storeToXML(new FileOutputStream("setting.xml"), "jdbc oracle setting");
			//public void storeToXML(OutputStream os, String comment) throws IOException
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
