package test.calendar;
import java.util.*;
public class ShowData {

	public static void main(String[] args) {
		DateCalculator totalDay = new DateCalculator();
		
		//���ذ� ��������?�������? ���Ȯ��
		System.out.println();
		////1�� 1�� 1�Ϻ��� ���ñ����� �� ���� ��� ���
		long total = totalDay.getDays();
		System.out.println("�� ��¥ �� : "+total);
		
	}

}
