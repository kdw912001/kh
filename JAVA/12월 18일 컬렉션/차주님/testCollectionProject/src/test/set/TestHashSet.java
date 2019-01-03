package test.set;

import java.util.*;

public class TestHashSet {

	public static void main(String[] args) {
		// HashSet test
		HashSet hset = new HashSet();
		
		System.out.println(hset.isEmpty());
		System.out.println(hset.size());
		
		//��ü�� ������ �� ����.
		hset.add(new String("apple"));
		hset.add("banana");
		hset.add(new Integer(123));
		//data(��) --> instance(��ü) : Boxing
		//Wrapper Ŭ���� ���
		hset.add(456);  //Auto Boxing ó����
		hset.add(new Double(54.7)); //Boxing ó��
		hset.add(3.15);  //Auto Boxing 
		//�⺻�ڷ��� ���� ���ؼ���
		//�÷��ǿ� ����� �ڵ� boxing ó����
		
		//�θ�Ŭ������ toString() �������̵��Ǿ� ����
		System.out.println(hset/*.toString()*/);
		//��������� ���� �� �� 
		//�ߺ� ��� �� ��
		
		hset.add("apple");
		hset.add("banana");
		System.out.println(hset);
		System.out.println(hset.size());
		
		if(hset.contains("apple")) {
			hset.remove("apple");
		}
		
		System.out.println(hset);
		System.out.println(hset.size());
		
		/*hset.clear();
		System.out.println(hset.isEmpty());*/
		
		//����� ��ü ������ �ϳ��� ������
		//����ϴ� ���
		//ù��° : ����� ��ü�� ��ϸ����
		//��� : iterator ��� ��
		System.out.println("1 -------------");
		Iterator iter = hset.iterator();
		while(iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
		}
		
		//�ι�° : Object[] �� �ٲپ� ������
		System.out.println("2 ----------------");
		Object[] objArr = hset.toArray();
		for(int i = 0; i < objArr.length; i++) {
			System.out.println(objArr[i]);
		}
		
		//����°, toArray(T[] a) ����ϴ� ���
		Object[] objArr2 = new Object[hset.size()];
		hset.toArray(objArr2);
		System.out.println("3 -------------");
		for(Object o : objArr2) {
			System.out.println(o);
		}
	}

}





