package test.datetime;

import java.util.*;

public class TestCalendar {

	public static void main(String[] args) {
		// java.util.Calendar Ŭ���� �׽�Ʈ
		// �ļ� Ŭ������ GregorianCalendar
		// ��� �׽�Ʈ
		Calendar today;  //�߻�Ŭ������.
		today = Calendar.getInstance();
		System.out.println(today);
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DAY_OF_MONTH);
		int weekDay = today.get(Calendar.DAY_OF_WEEK);
		int hour = today.get(Calendar.HOUR);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		int ampm = today.get(Calendar.AM_PM);
		
		String week = null;
		switch(weekDay) {
		case 1:	week = "�Ͽ���"; break;
		case 2:	week = "������"; break;
		case 3:	week = "ȭ����"; break;
		case 4:	week = "������"; break;
		case 5:	week = "�����"; break;
		case 6:	week = "�ݿ���"; break;
		case 7:	week = "�����"; break;
		}
		
		System.out.println(year + "�� "
				+ month + "�� "
				+ day + "�� " 
				+ week + 
				(ampm == 0? " ���� ": " ���� ")
				+ hour + "�� "
				+ minute + "�� "
				+ second + "��");
	}

}




