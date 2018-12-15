package test.byteio;

import java.io.*;

public class TestDataIO2 {

	public void fileSave() {
		//try ���� ����� �����ؼ� close �������� ���� ���� �� �ĺ���
		//exception ������ �� �Ẹ��
		FileOutputStream fout = null;
		DataOutputStream dout = null;
		
		try {
			fout=new FileOutputStream("member.dat");
			dout=new DataOutputStream(fout);
			//dout.writeUTF("ȫ�浿"); //Data ��Ʈ���� ����� ������� ���� �о�� ��.
			String name = "ȫ�浿";
			int age = 27;
			char gender = '��';
			double height = 178.5;
			dout.writeUTF(name);//���� �� �� UTF�� �о�� ��
			dout.writeInt(age);
			dout.writeChar(gender);
			dout.writeDouble(height);
			dout.flush();
			
			System.out.println("���Ͽ� ��� �Ϸ�.");
		}catch(FileNotFoundException e) {
			System.out.println("������ �����ϴ�.");
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
			//�� ����� ������� �о�;� ��.
			String name = din.readUTF();
			int age = din.readInt();
			char gender = din.readChar();
			double height = din.readDouble();
			
			System.out.println(name + ", "+age +", "+gender+", "+height);
		}catch(FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
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
