package test.list;

import java.util.Comparator;

public class PointDescending 
	implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2) {
		// Person �� point �ʵ� ���� ������������
		int result = 0;
		
		if(o1 instanceof Person 
			&& o2 instanceof Person) {
			Person p1 = (Person)o1;
			Person p2 = (Person)o2;
			
			if(p1.getPoint() > p2.getPoint())
				result = 1;
			if(p1.getPoint() < p2.getPoint())
				result = -1;
			if(p1.getPoint() == p2.getPoint())
				result = 0;
		}
		
		return -result;
	}
}
