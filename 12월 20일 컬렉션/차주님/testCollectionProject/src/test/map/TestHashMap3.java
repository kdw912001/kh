package test.map;

import java.util.*;

public class TestHashMap3 {

	public static void main(String[] args) {
		// HashMap �ǽ�
		HashMap hmap = new HashMap();
		
		for(int k = 1; k <= 5; k++) {
			//1 ~ 100 ������ ������ ������ Ű
			//0.0 ���� 1.0 �̸��� ������ �Ǽ����� ��
			hmap.put(new Random().nextInt(100) + 1, 
					Math.random());
			//Auto Boxing ó����
		}
		
		System.out.println(hmap);

		//�ʿ� ��ϵ� ��ü ���� ���� ó��
		//ù��°. Ű���� Set ����
		//Set �� ������� �ٲپ� ó��
		Set keys = hmap.keySet();
		System.out.println(keys);
		Iterator keyIter = keys.iterator();
		System.out.println("-----------");
		while(keyIter.hasNext()) {
			Object key = keyIter.next();
			Object value = hmap.get(key);
			System.out.println(key + " = "
					+ value);
		}
		System.out.println("-----------");
		
		//�ι�°. ������ Collection����
		//Collection�� ������� ó��
		Collection values = hmap.values();
		Iterator valueIter = values.iterator();
		while(valueIter.hasNext()) {
			System.out.println(valueIter.next());
		}
		System.out.println("-----------");
		
		//����°, Collection�� ��ü�迭��
		Object[] valueArr = values.toArray();
		for(Object obj : valueArr) {
			System.out.println(obj);
		}
		System.out.println("-----------");
		
		//�׹�°, Map.Entry ���� Set����
		//������� �ٲپ� ó��
		Set entries = hmap.entrySet();
		Iterator entryIter = entries.iterator();
		while(entryIter.hasNext()) {
			Object obj = entryIter.next();
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey()
					+ "=" + entry.getValue());
		}
		System.out.println("-----------");
	}

}
