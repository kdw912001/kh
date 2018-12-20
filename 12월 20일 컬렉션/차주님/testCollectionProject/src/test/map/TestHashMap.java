package test.map;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestHashMap {

	public static void main(String[] args) {
		// HashMap test
		HashMap hmap = new HashMap();
		//Map hm = new HashMap();
		
		//Ű ��ü�� �� ��ü ������ ������
		hmap.put("one", 
			new Person("ȫ�浿", 27, 1530.5));
		hmap.put("23", new Book("23", 1, "�ظ�����5", "���ٷѸ�"));
		//key �� Set ������� ����
		//Ű�� �ߺ��Ǹ� �� ��
		//value �� List ������� �����
		//���� �ߺ� �����
		
		
		System.out.println("����� ��ü �� : "
				+ hmap.size());
		System.out.println(hmap/*.toString()*/);
	
		hmap.put("one", "java programming");
		System.out.println(hmap);
		hmap.put("two", new Book("23", 1, "�ظ�����5", "���ٷѸ�"));
		System.out.println(hmap);
		
		//�ʿ� ����� �� ��ü ��ȸ��
		Object value = hmap.get("23");
		System.out.println(value);
		if(value instanceof Book) {
			Book b = (Book)value;
			System.out.println(b.getTitle());
			System.out.println(((Book)value).getAuthor());
		}
	}

}






