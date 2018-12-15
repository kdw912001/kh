package silsub3;

import java.util.*;
import java.io.*;

public class BookManager {
	private Scanner sc = new Scanner(System.in);
	
	public BookManager() {}
	
	public void fileSave() {
		Book[] b = { //new GregorianCalendar();
				new Book("자바1", "김1", 1000, new GregorianCalendar(1990,11,11), 1.1),
				new Book("자바1","김1",1000, new GregorianCalendar(1990,11,12),1.1),
				new Book("자바1","김1",1000, new GregorianCalendar(1990,11,12),1.1),
				new Book("자바1","김1",1000, new GregorianCalendar(1990,11,12),1.1),
				new Book("자바1","김1",1000, new GregorianCalendar(1990,11,12),1.1)
		};
		try(ObjectOutputStream objOut = new ObjectOutputStream(
				new FileOutputStream("books.dat"));){
			for(int i=0; i<b.length;i++) {
				objOut.writeObject(b[i]);
			}
			System.out.println("books.dat에 저장완료!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		Book[] bk = new Book[10];
		int count=0;
		try (ObjectInputStream objIn = new ObjectInputStream(
				new FileInputStream("books.dat"))){
			while(true) {
				bk[count]=(Book)objIn.readObject();
				count++;
			}
			
		}catch(EOFException e) {
			for(int i=0; i<count;i++) {
				System.out.println(bk[i]);
			}
			System.out.println("books.dat 읽기 완료!");
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
}
