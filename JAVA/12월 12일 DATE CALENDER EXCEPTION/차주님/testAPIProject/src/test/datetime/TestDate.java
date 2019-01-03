package test.datetime;

import java.util.*;
import java.text.*;

public class TestDate {

	public static void main(String[] args) {
		// java.util.Date 클래스 테스트
		Date today = new Date();
		//시스템으로부터 현재 날짜와 시간정보를 
		//읽어와서 객체 생성함
		System.out.println(today);
		System.out.println(today.getTime());
		
		Date when = new Date(123456789000L);
		System.out.println(when);
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat(
				"yyyy-MM-dd (E) a hh:mm:ss");
		String fmDate = sdf.format(today);
		System.out.println(fmDate);
		
		SimpleDateFormat sdf2 = 
				new SimpleDateFormat(
				"yyyy'년' MM'월' dd'일' (E) a hh'시' mm'분' ss'초'");
		System.out.println(sdf2.format(when));
	}

}







