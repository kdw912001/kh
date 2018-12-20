package test.map;

import java.util.*;

public class TestHashMap2 {

	public static void main(String[] args) {
		// �ʿ� ����� ��ü���� ���� ó��
		HashMap hmap = new HashMap();
		
		hmap.put("one", new Integer(12345));
		hmap.put(2, "java");  //Auto Boxing
		hmap.put("two", "oracle");
		
		System.out.println(hmap);

		//Map �迭�� ����� ��ü�� ����
		//���� ó�� ��� ����
		//���� ó���Ϸ���
		//Map �� Set �̳� Collection����
		//�ٲٰ� ���� Iterator() �� ��ϸ���ų�
		//Object[] �� �ٲپ� ����ؾ� ��
		
		//ù��°, Ű���� Set���� �ٲ�
		//Ű�� ���� ����� ����
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
		System.out.println("----------------");
		
		//�ι�°, �� ��ü�鸸 Collection ����
		//�ٲٰ� ����, ����̳� ��ü�迭�� ����
		Collection values = hmap.values();
		//1. ��� �����
		Iterator valueIter = values.iterator();
		while(valueIter.hasNext()) {
			System.out.println(valueIter.next());
		}
		System.out.println("-------------");
		
		//2. ��ü�迭�����
		Object[] valueArr = values.toArray();
		for(Object obj : valueArr) {
			System.out.println(obj);
		}
		System.out.println("----------------");
		
		//����°, entrySet() ���
		//Map.Entry ���� Set ���� �ٲٰ�
		//��Ʈ���� ���� ����� ����
		//Entry : Ű�� �� �ѽ�
		Set entries = hmap.entrySet();
		Iterator entryIter = entries.iterator();
		while(entryIter.hasNext()) {
			Object obj = entryIter.next();
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey()
					+ "=" + entry.getValue());
		}
	}

}







