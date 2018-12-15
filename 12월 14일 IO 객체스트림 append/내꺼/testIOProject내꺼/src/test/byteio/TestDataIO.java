package test.byteio;

import java.io.*;

public class TestDataIO {
	
	public void fileSave() {
		//DataOutputStream 클래스는 값을 종류별로 기록할 수 있는
		//메소드를 제공하는 보조스트림 클래스임.
		/*try (FileOutputStream fout = new FileOutputStream("member.dat");
				DataOutputStream dout = new DataOutputStream(fout);){
			
		}레퍼런스를 각각 쓸 일이 없다면 하나의 레퍼런스로 선언할 것.*/
		//한번에 선언하면 굳이 위에 처럼 2개의 레퍼런스를 선언할 필요가 없음.
		try(DataOutputStream dout = new DataOutputStream(
				new FileOutputStream("member.dat"))) {
			//dout.writeUTF("홍길동"); //Data 스트림은 기록한 순서대로 값을 읽어야 함.
			String name = "홍길동";
			int age = 27;
			char gender = '남';
			double height = 178.5;
			dout.writeUTF(name);//읽을 때 꼭 UTF로 읽어야 함
			dout.writeInt(age);
			dout.writeChar(gender);
			dout.writeDouble(height);
			dout.flush();
			
			System.out.println("파일에 기록 완료.");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		//레퍼런스를 각각 쓸 일이 없다면 하나의 레퍼런스로 선언할 것.
		/*try(FileInputStream fin = new FileInputStream("member.dat");
				DataInputStream din = new DataInputStream(fin);)*/
		try (DataInputStream din = new DataInputStream(
				new FileInputStream("member.dat"));){
			//꼭 기록한 순서대로 읽어와야 함.
			String name = din.readUTF();
			int age = din.readInt();
			char gender = din.readChar();
			double height = din.readDouble();
			
			System.out.println(name + ", "+age +", "+gender+", "+height);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args) {
		//data 입출력 보조 스트림 테스트
		TestDataIO test = new TestDataIO();
		//test.fileSave();
		//member.dat를 열어보면 직접 byte값이 나오기 때문에 값이 이상하게 나옴
		test.fileRead();
	}
}
