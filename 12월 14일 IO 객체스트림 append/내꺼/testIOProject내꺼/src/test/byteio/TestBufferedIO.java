package test.byteio;

import java.util.*;
import java.io.*;

public class TestBufferedIO {
	private Scanner sc = new Scanner(System.in);
	
	public TestBufferedIO() {}
	
	public void fileSave() {
		BufferedOutputStream bout = null;
		FileOutputStream fout = null; 
		
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		
		try {
			fout = new FileOutputStream(fileName);
			bout = new BufferedOutputStream(fout);
			//������Ʈ���� �ݵ�� �⺻ ��Ʈ���� �־�� ���� ����
			
			System.out.print("���Ͽ� ����� ������ �Է��ϼ���. ");
			String str = null;
			sc.nextLine(); //���� ����Ű ����
			while(!(str = sc.nextLine()).equals("exit")) {
				bout.write(str.getBytes());
			}
			bout.flush(); //Ȥ�ó� �������� ������ ��� ����
			System.out.println("���� ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ��� ���� �߻�");
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bout.close();//������ FileOutputStream ����� BufferedOutputStream 
				fout.close();//������� ������ ���� ���� �� ���Ͻ�Ʈ�� ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave2() {
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		
		try(BufferedOutputStream bout = new BufferedOutputStream(
				new FileOutputStream(fileName));){
			//close()ó��, BufferedOutputStream �� ���忡 �ۼ� ����
						
			System.out.print("���Ͽ� ����� ������ �Է��ϼ���. ");
			String str = null;
			sc.nextLine(); //���� ����Ű ����
			while(!(str = sc.nextLine()).equals("exit")) {
				bout.write(str.getBytes());
			}
			bout.flush(); //Ȥ�ó� �������� ������ ��� ����
			
			System.out.println("���� ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			System.out.println("���� ��� ���� �߻�");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		System.out.print("���� ���ϸ� : ");
		String fileName = sc.next();
		
		try(BufferedInputStream bin = new BufferedInputStream(
				new FileInputStream(fileName));){//�⺻��Ʈ������ ���۽�Ʈ������ ����
			int readData;
			while((readData = bin.read()) != -1) {
				System.out.print((char)readData);
			}
			System.out.println("\n���� �б� �Ϸ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Buffer �� �̿��� ������Ʈ�� ��� �׽�Ʈ
		TestBufferedIO test = new TestBufferedIO();
		//test.fileSave();
		//test.fileSave2();
		test.fileRead();
	}
}
