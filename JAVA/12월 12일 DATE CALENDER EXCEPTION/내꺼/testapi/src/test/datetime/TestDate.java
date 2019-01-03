package test.datetime;

import java.util.*;
import java.text.*;

public class TestDate {

	public static void main(String[] args) {
		// java.util.Date Ŭ���� �޼ҵ�
		Date today = new Date();
		//�ý������κ��� ���� ��¥�� �ð�������
		//�о�ͼ� ��ü ������
		System.out.println(today);//today.toString() 
		//Thu Dec 13 03:55:55 KST 2018
		System.out.println(today.getTime()); 
		//���� ��¥���� ���� ��¥������ �ʷ� �ٲ�//1544640955880
		
		Date when = new Date(123456789000L);
		System.out.println(when);//Fri Nov 30 06:33:09 KST 1973
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) a hh:mm:ss"); 
		//HH24�ð� hh12�ð� a ��������ǥ�� (E) ����
		String fmDate = sdf.format(today);
		System.out.println(fmDate);//2018-12-13 (��) ���� 03:55:55
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy'��' MM'��' dd'��' (E) a hh'��' mm'��' ss'��'");  //" "�ȿ� " "�� ���� ������ ' ' ���� ����ǥ ���
		System.out.println(sdf2.format(when));//1973�� 11�� 30�� (��) ���� 06�� 33�� 09��
	}
}
