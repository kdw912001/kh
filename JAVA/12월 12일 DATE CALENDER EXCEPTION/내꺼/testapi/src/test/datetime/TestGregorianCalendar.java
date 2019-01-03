package test.datetime;

import java.util.*;
import java.text.*;

public class TestGregorianCalendar {

	public static void main(String[] args) {
		/*GregorianCalendar today = new GregorianCalendar();*/
		Calendar today = new GregorianCalendar(); //��Ӱ����̱� ������ ����
		System.out.println(today);//toString�� �������̵� �Ǿ����� 
		//Calendar�� ���� ��, GregorianCalendar�� Calendar�� �ڼ��̱� ����
		GregorianCalendar cristmas = new GregorianCalendar(2020, 12, 25);
		
		System.out.println(cristmas);
		System.out.println(cristmas.get(Calendar.DAY_OF_WEEK));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)");
		String str = sdf.format(cristmas.getGregorianChange()); //format(DateŬ����)
				//GregorianChange() return Date�� �̿�
		System.out.println(str); //���� �� �ȳ���
		
		System.out.println(sdf.format(today.getTime())); 
		//Calendar�� getTime()�޼ҵ� return Date�� �̿�
		
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
		
		//GregorianCalendar ���� ����� �ȳ��� 
		//format�� ����ϸ� ���� �� �ȳ���. get�� �̿�
		//������ �ڵ� Ȯ��
	}

}
