package test.calendar;

public class ShowDate {

	public static void main(String[] args) {
		// ��¥�ð� �ǽ�����
		DateCalculator totalDay = 
				new DateCalculator();
		//���ذ� ��������? �������? ��� Ȯ��
		System.out.println(totalDay.isLeapYear(2018) == true? "����" : "���");
		//1�� 1�� 1�Ϻ��� ���ñ����� �� ���� ��� ���
		long total = totalDay.getDays();
		System.out.println("�ѳ�¥�� : " + total + "��");

	}

}
