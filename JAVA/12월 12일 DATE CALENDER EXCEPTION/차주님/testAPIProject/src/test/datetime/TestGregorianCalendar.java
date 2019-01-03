package test.datetime;

import java.util.*;
import java.text.*;

public class TestGregorianCalendar {
	public static void main(String[] args) {
		/*GregorianCalendar today = 
			new GregorianCalendar();*/
		Calendar today = 
			new GregorianCalendar();
		System.out.println(today);
		
		GregorianCalendar cristmas =
			new GregorianCalendar(
					2020, 12, 25);
		System.out.println(cristmas);
		System.out.println(
		cristmas.get(Calendar.DAY_OF_WEEK));
		
		Calendar current = 
			new GregorianCalendar(
			TimeZone.getTimeZone("America/Los_Angeles"));
		System.out.println(current);
		System.out.println(
				current.get(Calendar.DAY_OF_MONTH)
				+ "일 " + 
				current.get(Calendar.AM_PM)
				+ ", " + current.get(Calendar.HOUR)
				+ "시" + current.get(Calendar.MINUTE)
				+ "분 " + current.get(Calendar.SECOND)
				+ "초");
		
		/*SimpleDateFormat sdf = 
				new SimpleDateFormat(
				"yyyy-MM-dd (E) a HH:mm:ss");
		String str = sdf.format(
				cristmas.getGregorianChange());
		System.out.println(str);
		
		System.out.println(sdf.format(today.getTime()));
		System.out.println(sdf.format(current.getTime()));*/
		
	}
}






