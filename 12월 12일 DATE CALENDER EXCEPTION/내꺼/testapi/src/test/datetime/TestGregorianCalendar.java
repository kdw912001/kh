package test.datetime;

import java.util.*;
import java.text.*;

public class TestGregorianCalendar {

	public static void main(String[] args) {
		/*GregorianCalendar today = new GregorianCalendar();*/
		Calendar today = new GregorianCalendar(); //상속관계이기 때문에 가능
		System.out.println(today);//toString이 오버라이딩 되어있음 
		//Calendar와 같은 값, GregorianCalendar는 Calendar의 자손이기 때문
		GregorianCalendar cristmas = new GregorianCalendar(2020, 12, 25);
		
		System.out.println(cristmas);
		System.out.println(cristmas.get(Calendar.DAY_OF_WEEK));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)");
		String str = sdf.format(cristmas.getGregorianChange()); //format(Date클래스)
				//GregorianChange() return Date를 이용
		System.out.println(str); //값이 잘 안나옴
		
		System.out.println(sdf.format(today.getTime())); 
		//Calendar의 getTime()메소드 return Date를 이용
		
		Calendar current = 
				new GregorianCalendar(TimeZone.getTimeZone("America/New_York"));
		
		SimpleDateFormat sdf2 = 
				new SimpleDateFormat(
				"yyyy-MM-dd (E)");
		String str2 = sdf.format(
				cristmas.getGregorianChange());
		System.out.println(str2);
		
		System.out.println(sdf2.format(today.getTime()));
		System.out.println(sdf2.format(current.getTime()));
		
		//GregorianCalendar 값이 제대로 안나옴 
		//format을 사용하면 값이 잘 안나옴. get을 이용
		//선생님 코드 확인
	}

}
