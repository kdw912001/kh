package test.datetime;

import java.util.*;

public class TestCalendar {

	public static void main(String[] args) {
		// java.util.Calendar Ŭ���� �׽�Ʈ
		//CalendarŬ������ �߻�Ŭ���� �̹Ƿ� ���� ��ü������ ����(new�� ���ϰ�)
		//�ļ� Ŭ������ GregorianCalendar
		//��� �׽�Ʈ
		Calendar today;//�߻� Ŭ������ new������ ���ϰ� ���۷��� ���� ����
		today = Calendar.getInstance();
		System.out.println(today); //�ļ��� �������Ѽ� �ļ��� toString()�� ������
		//java.util.GregorianCalendar[time=1544599729077,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
		//zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,
		//YEAR=2018,MONTH=11,WEEK_OF_YEAR=50,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=346,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=28,SECOND=49,
		//MILLISECOND=77,ZONE_OFFSET=32400000,DST_OFFSET=0]
		//[Field����]
		//MONTH�� 0~11�� ����->11�� 12���� �ǹ� ���� ���� +1�ؾ��� 
		//SET�� ���� -1�� �ؼ� �����ؾ� ��.
		//WEEK_OF_YEAR = 1�⿡ �� ��° ������
		//DAY_OF_WEEK=4 �Ͽ�����1 ������ �������̹Ƿ� 4
		//DAY_OF_WEEK_IN_MONTH=2  ���ÿ� �ش�Ǵ� ������ �Ѵ� �ȿ��� �� ��° �������� 
		//18��12��12�� 12������ �ι�° �������̹Ƿ� 2

		//get(int field) return (int) 
		//get�޼ҵ�� static�� �����Ƿ� ���۷���.get() 
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1; //MONTH 0~11�̹Ƿ� ���� 12���̴� +1
		int day = today.get(Calendar.DAY_OF_MONTH);
		int weekDay = today.get(Calendar.DAY_OF_WEEK);
		int hour = today.get(Calendar.HOUR); //HOUR OF DAY �� 24�ð� HOUR�� 12�ð�
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		int ampm = today.get(Calendar.AM_PM);
		
		String week = null;
		switch(weekDay) {
		case 1: week = "�Ͽ���"; break;
		case 2: week = "������"; break;
		case 3: week = "ȭ����"; break;
		case 4: week = "������"; break;
		case 5: week = "�����"; break;
		case 6: week = "�ݿ���"; break;
		case 7: week = "�����"; break;
		
		}
		System.out.println(year + "�� " +month+"�� " + day+"�� "+week+" "+
				(ampm==0?"����":"����")+" "+hour+"�� "+minute+"�� "+second+"��");
	}

}
