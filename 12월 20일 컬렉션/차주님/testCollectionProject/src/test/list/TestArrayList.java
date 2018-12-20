package test.list;

import java.util.*;

public class TestArrayList {

	public static void main(String[] args) {
		// ArrayList test
		ArrayList alist = new ArrayList();
		
		//��������� index �� �Ű���
		//��ü �ߺ� ���� ������
		alist.add("java");
		alist.add("oracle");
		alist.add("jdbc");
		alist.add("java");
		
		System.out.println(alist);
		System.out.println("���� ��ü�� : "
				+ alist.size());
		
		for(int i = 0; i < alist.size(); i++) {
			System.out.println(i + " : " + 
					alist.get(i));
		}
		
		//��������� �ִ� �迭�̳� ����Ʈ��
		//for each �� ��� ������
		for(Object obj : alist) {
			System.out.println(obj);
		}

		//add(����, ��ü)
		alist.add(1, "html5");
		System.out.println(alist);
		
		//set(index, ������ ��ü)
		alist.set(3, "css3");
		System.out.println(alist);
		
		//remove(������ ��ü) 
		//Set �迭 �޼ҵ�� ������
		alist.remove("java");
		System.out.println(alist);
		
		//remove(index)
		alist.remove(2);
		System.out.println(alist);
	}

}




