package test.byteio;

import java.io.*;

public class TestDataIO2 {
	public void fileSave() {
		FileOutputStream fout = null;
		DataOutputStream dout = null;
		
		try{
			fout = new FileOutputStream("member.dat");
			dout = new DataOutputStream(fout);
			
			String name = "ȫ�浿";
			int age = 27;
			char gender = '��';
			double height = 178.5;			
			
			dout.writeUTF(name);
			dout.writeInt(age);
			dout.writeChar(gender);
			dout.writeDouble(height);
			dout.flush();
			
			System.out.println("���Ͽ� ��� �Ϸ�.");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
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
		
		try{
			fin = new FileInputStream("member.dat");
			din = new DataInputStream(fin);
			
			String name = din.readUTF();
			int age = din.readInt();
			char gender = din.readChar();
			double height = din.readDouble();
			
			System.out.println(name + ", " + 
					age + ", " + gender + 
					", " + height);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
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

	public static void main(String[] args) {
		// data ����� ������Ʈ�� �׽�Ʈ
		TestDataIO2 test2 = new TestDataIO2();
		//test2.fileSave();
		test2.fileRead();

	}
}
