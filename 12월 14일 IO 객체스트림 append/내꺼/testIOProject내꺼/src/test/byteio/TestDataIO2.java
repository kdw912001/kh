package test.byteio;

import java.io.*;

public class TestDataIO2 {

	public void fileSave() {
		//try 옆에 선언과 생성해서 close 생략하지 말고 직접 다 쳐보기
		//exception 종류도 다 써보기
		FileOutputStream fout = null;
		DataOutputStream dout = null;
		
		try {
			fout=new FileOutputStream("member.dat");
			dout=new DataOutputStream(fout);
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
		}catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dout.close();
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileRead() {
		
		FileInputStream fin = null;
		DataInputStream din = null;
		
		try {
			fin = new FileInputStream("test.dat");
			din = new DataInputStream(fin);
			//꼭 기록한 순서대로 읽어와야 함.
			String name = din.readUTF();
			int age = din.readInt();
			char gender = din.readChar();
			double height = din.readDouble();
			
			System.out.println(name + ", "+age +", "+gender+", "+height);
		}catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				din.close();
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[]args) {
		TestDataIO test = new TestDataIO();
		//test.fileSave();
		test.fileRead();
	}

}
