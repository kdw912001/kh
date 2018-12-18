package test.list;

import java.util.*;

public class TestPersonArrayList {

	public static void main(String[] args) {
		// Person ����� ArrayList ���
		ArrayList list = new ArrayList();

		list.add(new Person("ȫ�浿", 25, 1537.5));
		list.add(new Person("�̼���", 49, 15789.0));
		list.add(new Person("�Ż��Ӵ�", 55, 34567.4));
		
		System.out.println(list);
		
		for(Object obj : list) {
			System.out.println(obj);
		}
		
		//�� ��ü�� ���� ����Ʈ ���� �հ踦 ����
		double totalPoint = 0.;
		for(int i = 0; i < list.size(); i++) {
			Person p = (Person)list.get(i);
			totalPoint += p.getPoint();
		}
		
		System.out.println("����Ʈ ���� : " +
				totalPoint);
	}

}






