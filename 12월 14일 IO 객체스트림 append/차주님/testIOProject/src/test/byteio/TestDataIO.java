package test.byteio;

import java.io.*;

public class TestDataIO {
	
	public void fileSave() {
		//DataOutputStream 클래스는
		//값을 종류별로 기록할 수 있는
		//메소드를 제공하는 보조스트림 클래스임.
		/*try(FileOutputStream fout = 
				new FileOutputStream("member.dat");
			DataOutputStream dout = 
				new DataOutputStream(fout);){*/
		try(DataOutputStream dout =
				new DataOutputStream(
					new FileOutputStream("member.dat"));){
			
			String name = "홍길동";
			int age = 27;
			char gender = '남';
			double height = 178.5;			
			
			dout.writeUTF(name);
			dout.writeInt(age);
			dout.writeChar(gender);
			dout.writeDouble(height);
			dout.flush();
			
			System.out.println("파일에 기록 완료.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		/*try(FileInputStream fin = 
			new FileInputStream("member.dat");
			DataInputStream din = 
				new DataInputStream(fin);){*/
		try(DataInputStream din = 
				new DataInputStream(
					new FileInputStream("member.dat"));){
			
			String name = din.readUTF();
			int age = din.readInt();
			char gender = din.readChar();
			double height = din.readDouble();
			
			System.out.println(name + ", " + 
					age + ", " + gender + 
					", " + height);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// data 입출력 보조스트림 테스트
		TestDataIO test = new TestDataIO();
		//test.fileSave();
		test.fileRead();

	}	
}




