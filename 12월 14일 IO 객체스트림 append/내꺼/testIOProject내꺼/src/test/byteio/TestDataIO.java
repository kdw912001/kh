package test.byteio;

import java.io.*;

public class TestDataIO {
	
	public void fileSave() {
		//DataOutputStream Ŭ������ ���� �������� ����� �� �ִ�
		//�޼ҵ带 �����ϴ� ������Ʈ�� Ŭ������.
		/*try (FileOutputStream fout = new FileOutputStream("member.dat");
				DataOutputStream dout = new DataOutputStream(fout);){
			
		}���۷����� ���� �� ���� ���ٸ� �ϳ��� ���۷����� ������ ��.*/
		//�ѹ��� �����ϸ� ���� ���� ó�� 2���� ���۷����� ������ �ʿ䰡 ����.
		try(DataOutputStream dout = new DataOutputStream(
				new FileOutputStream("member.dat"))) {
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
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		//���۷����� ���� �� ���� ���ٸ� �ϳ��� ���۷����� ������ ��.
		/*try(FileInputStream fin = new FileInputStream("member.dat");
				DataInputStream din = new DataInputStream(fin);)*/
		try (DataInputStream din = new DataInputStream(
				new FileInputStream("member.dat"));){
			//�� ����� ������� �о�;� ��.
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
		//data ����� ���� ��Ʈ�� �׽�Ʈ
		TestDataIO test = new TestDataIO();
		//test.fileSave();
		//member.dat�� ����� ���� byte���� ������ ������ ���� �̻��ϰ� ����
		test.fileRead();
	}
}
