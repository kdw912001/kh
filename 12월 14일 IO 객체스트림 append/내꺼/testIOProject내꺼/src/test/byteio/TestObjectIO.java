package test.byteio;

import java.io.*;

public class TestObjectIO {
	public void fileSave() {
		//���� ��Ͽ� ����� ��ü�迭 �غ�
		Student[] sar = {
				new Student(12, "ȫ�浿",4.43,"�濵�а�"),
				new Student(25, "�̼���",4.5,"ü���а�"),
				new Student(37, "�念��", 3.87,"��������а�")
		};
		
		try(ObjectOutputStream objOut = new ObjectOutputStream(
				new FileOutputStream("student.dat"));){
			for(int i=0; i<sar.length;i++) {
				objOut.writeObject(sar[i]);
			}
			System.out.println("���� ��� �Ϸ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		int count = 0;
		//�迭������ ���ڸ��� �ȵǱ� ������ �˳��� ����
		Student[] sar = new Student[10];
		try(ObjectInputStream objIn = new ObjectInputStream(
				new FileInputStream("student.dat"))){
			while(true) {
				/*Student std = (Student)objIn.readObject();
				//Object�� ���� Ŭ�����̱� ������ �ٿ�ĳ����*/
				//���Ͱ��� �� �ʿ� ���� �Ʒ�ó�� �� �������� ����
				sar[count] = (Student)objIn.readObject();
				count++;
			}
			
		}catch(EOFException e) {
			System.out.println("���� �б� �Ϸ�");
			for(int i=0; i<count;i++) {
				System.out.println(sar[i]); //toString�������̵�
			}
		}catch(Exception e) {
			//System.out.println("���� �б� �Ϸ�.");
			//->EOFException�߻� ��� catch�� �ۼ�
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// ��ü����� �׽�Ʈ
		TestObjectIO test = new TestObjectIO();
		test.fileSave();
		test.fileRead();
	}
}
