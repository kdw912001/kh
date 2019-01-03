package test.set;

import java.util.*;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		// LinkedHashSet test
		// ��������� �����Ǵ� Set
		// �ߺ� ��� �� ��
		
		LinkedHashSet lset = 
				new LinkedHashSet();

		lset.add("apple");
		lset.add("banana");
		lset.add(123);
		lset.add(54.7);
		lset.add("apple");
		
		System.out.println(lset);
		
		System.out.println("1 -------------");
		//ù��° : ����� ��ü ��ϸ����
		//�ϳ��� ������
		Iterator objIter = lset.iterator();
		while(objIter.hasNext()) {
			System.out.println(objIter.next());
		}
		
		System.out.println("2 -------------");
		//�ι�° : Object[] �迭�� �ٲپ�
		//�ϳ��� ������
		Object[] objArr = lset.toArray();
		for(Object obj : objArr) {
			System.out.println(obj);
		}
		
		System.out.println("3 ------------");
		Object[] objArr2 = new Object[lset.size()];
		lset.toArray(objArr2);
		for(int i = 0; i < objArr2.length; i++) {
			System.out.println(objArr2[i]);
		}
	}

}






