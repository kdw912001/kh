package test.map;

import java.util.*;

public class TestTreeMap {

	public static void main(String[] args) {
		// TreeMap test
		//�ڵ� ���ı���� ����� Map Ŭ����
		HashMap hmap = new HashMap();
		
		for(int k = 1; k < 6; k++) {
			hmap.put((int)(Math.random() * 100) + 1, 
					Math.random());
		}
		
		System.out.println(hmap);
		
		//Ű�� ���� ������������ ó����
		//�ڵ����� �Ϸ���
		//TreeMap ����ϸ� ��
		TreeMap tmap = new TreeMap(hmap);
		System.out.println(tmap);
		
		//Ű�� ���� ������������ ó����
		Map descMap = tmap.descendingMap();
		System.out.println(descMap);
	}

}






