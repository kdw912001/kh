package io.silsub3;

import java.util.*;
import java.io.*;

public class BookManager {
	Scanner sc = new Scanner(System.in);	//�ʱ�ȭ ��ü ������

	public BookManager(){}

	public void fileSave(){
		Book[] books = new Book[]{
				new Book("java", "hong", 120, new GregorianCalendar(2015, 10, 3), 0.1),
				new Book("oracle", "park", 245, new GregorianCalendar(2014, 3, 5), 0.1),
				new Book("html5", "lee", 133, new GregorianCalendar(2013, 5, 25), 0.1),
				new Book("css3", "kim", 542, new GregorianCalendar(2010, 1, 1), 0.1),
				new Book("jquery", "choi", 789, new GregorianCalendar(), 0.1)};
		
		try(ObjectOutputStream objOut = 
				new ObjectOutputStream(
				new FileOutputStream("books.dat"))){
			//��� ������ ������ �ڵ����� ������ ����
			//��� ������ ������, ���� ���� ������ �����
			//���ξ��� ���·� ������ ����.
			//������½�Ʈ�� �����ÿ� 
			//�߰�����(append) ��带 true �� �ϸ�
			//��������� ���� �� ���� ������ �״�� �ΰ�
			//���� �ڿ� �߰����Ⱑ ��
			
			for(Book b : books)
				objOut.writeObject(b);
			
			System.out.println("books.dat �� ���� �Ϸ�!");
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void fileRead(){
		Book[] books = new Book[10];
		
		try(ObjectInputStream objIn = 
				new ObjectInputStream(new FileInputStream("books.dat"))){
			
			for(int i = 0; i < books.length; i++){
				books[i] = (Book)objIn.readObject();
				System.out.println(books[i]);				
			}
						
		}catch(EOFException e){
			System.out.println("books.dat �б� �Ϸ�!");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
