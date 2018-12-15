package replay;

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
				new Book("자바1","김1",1000, new GregorianCalendar(1990,11,12),1.1),
		};
		try(ObjectOutputStream objOut = new ObjectOutputStream(
				new FileOutputStream("books.dat", true));){
			//대상 파일이 없으면 자동으로 파일을 만듦
			//대상 파일이 있으면, 파일 안의 내용을 지우고 
			//새로쓰기 상태로 파일을 연다.
			//파일출력스트림 생성시에 추가쓰기(append) 모드를 true로 하면
			//대상파일이 있을 때 기존 내용은 그대로 두고 내용 뒤에 추가쓰기가 됨.
			//생략되면 기본이 false// true면 파일 안의 내용을 놔두고 계속 씀
			//객체 출력 스트림에서는 오류 남
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
