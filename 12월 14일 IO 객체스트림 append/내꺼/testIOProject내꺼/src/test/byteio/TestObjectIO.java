package test.byteio;

import java.io.*;

public class TestObjectIO {
	public void fileSave() {
		//파일 기록에 사용할 객체배열 준비
		Student[] sar = {
				new Student(12, "홍길동",4.43,"경영학과"),
				new Student(25, "이순신",4.5,"체육학과"),
				new Student(37, "장영실", 3.87,"정보통신학과")
		};
		
		try(ObjectOutputStream objOut = new ObjectOutputStream(
				new FileOutputStream("student.dat"));){
			for(int i=0; i<sar.length;i++) {
				objOut.writeObject(sar[i]);
			}
			System.out.println("파일 기록 완료.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		int count = 0;
		//배열공간은 모자르면 안되기 때문에 넉넉히 선언
		Student[] sar = new Student[10];
		try(ObjectInputStream objIn = new ObjectInputStream(
				new FileInputStream("student.dat"))){
			while(true) {
				/*Student std = (Student)objIn.readObject();
				//Object가 상위 클래스이기 때문에 다운캐스팅*/
				//위와같이 할 필요 없이 아래처럼 한 문장으로 선언
				sar[count] = (Student)objIn.readObject();
				count++;
			}
			
		}catch(EOFException e) {
			System.out.println("파일 읽기 완료");
			for(int i=0; i<count;i++) {
				System.out.println(sar[i]); //toString오버라이딩
			}
		}catch(Exception e) {
			//System.out.println("파일 읽기 완료.");
			//->EOFException발생 고로 catch문 작성
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// 객체입출력 테스트
		TestObjectIO test = new TestObjectIO();
		test.fileSave();
		test.fileRead();
	}
}
