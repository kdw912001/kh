package io.silsub3;

import java.util.*;
import java.io.*;

public class BookManager {
	Scanner sc = new Scanner(System.in);	//초기화 객체 생성함

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
			//대상 파일이 없으면 자동으로 파일을 만듦
			//대상 파일이 있으면, 파일 안의 내용을 지우고
			//새로쓰기 상태로 파일을 연다.
			//파일출력스트림 생성시에 
			//추가쓰기(append) 모드를 true 로 하면
			//대상파일이 있을 때 기존 내용은 그대로 두고
			//내용 뒤에 추가쓰기가 됨
			
			for(Book b : books)
				objOut.writeObject(b);
			
			System.out.println("books.dat 에 저장 완료!");
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
			System.out.println("books.dat 읽기 완료!");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
