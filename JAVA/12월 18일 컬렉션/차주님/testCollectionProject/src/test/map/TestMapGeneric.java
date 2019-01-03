package test.map;

import java.util.*;
import practice2.Book;

public class TestMapGeneric {

	public static void main(String[] args) {
		// Map �迭�� ���׸� ��� ���	 
		
		 HashMap<String, Book> hmap = getInstance();
		 //printMap(hmap);
		 //printMap2(hmap);
		 printMap3(hmap);

	}
	
	public static HashMap<String, Book> getInstance(){
		HashMap<String, Book> hmap = 
				new HashMap<String, Book>();
		
		hmap.put("12", new Book("12", 1, "�ڹ�����", "ȫ�浿"));
		hmap.put("23", new Book("23", 2, "ȫ�浿��", "�㳭����"));
		hmap.put("37", new Book("37", 4, "��̻�Ȱ", "�ݼ�����"));
		//hmap.put(77, "77");
		
		return hmap;
	}
	
	public static void printMap(HashMap<String, Book> hmap) {
		//ù��°, Ű���� Set ���� �ٲ�
		Set<String> keys = hmap.keySet();
		//��� �����
		Iterator<String> keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			Book b = hmap.get(key);
			System.out.println(key + "=" + b);
		}
	}
	
	public static void printMap2(HashMap<String, Book> hmap) {
		//�ι�°, ����ü���� Collection ���� �ٲ�
		Collection<Book> values = hmap.values();
		//��� �����
		Iterator<Book> valueIter = values.iterator();
		while(valueIter.hasNext()) {
			Book b = valueIter.next();
			System.out.println(b);
		}
		System.out.println("--------------------");
		//�迭�� �ٲٱ�
		Book[] bar = new Book[values.size()];
		values.toArray(bar);
		for(Book b : bar) {
			System.out.println(b);
		}
	}
	
	public static void printMap3(HashMap<String, Book> hmap) {
		//ù��°, Ű�� ���� ���� ��Ʈ������
		//Set ���� �ٲ�
		Set<Map.Entry<String, Book>> entries 
			= hmap.entrySet();
		//��� �����
		Iterator<Map.Entry<String, Book>> entryIter 
			= entries.iterator();
		while(entryIter.hasNext()) {
			Map.Entry<String, Book> entry 
				= entryIter.next();
			String key = entry.getKey();
			Book b = entry.getValue();
			System.out.println(key + "=" + b);
		}
	}

}




