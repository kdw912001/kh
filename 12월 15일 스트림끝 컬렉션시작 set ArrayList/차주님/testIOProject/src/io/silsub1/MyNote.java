package io.silsub1;

import java.util.*;
import java.io.*;

public class MyNote {
	private Scanner sc = new Scanner(System.in);
	
	public MyNote(){}
	
	public void fileSave(){
		StringBuilder sb = new StringBuilder();
		
		System.out.println(
			"���Ͽ� ������ ������ �Է��Ͻÿ�");
		while(true){			
			String s = sc.nextLine();			
			if(s.equals("exit"))	break;			
			sb.append(s + "\n");
		}
		
		System.out.println("�����Ͻðڽ��ϱ�? (y/n) : ");			
		if(sc.next().toUpperCase().charAt(0) == 'Y'){			
			System.out.println("������ ���ϸ� : ");
			String fileName = sc.next();
			
			try(BufferedWriter bw = 
				new BufferedWriter(
					new FileWriter(fileName))){
				bw.write(sb.toString());
				bw.flush();
				System.out.println(fileName 
					+ "���Ͽ� ���������� �����Ͽ����ϴ�.");
				System.out.println();
			}catch(IOException e){
				e.printStackTrace();
			}
		}	

	}
	
	public void fileOpen(){
		System.out.println("������ ���ϸ� : ");
		String fileName = sc.next();
		try(BufferedReader br = 
			new BufferedReader(
				new FileReader(fileName))) {
			while(true){
				String line = br.readLine();
				if(line == null)	break;
				System.out.println(line);
			}
			System.out.println("\n" + 
				fileName + " �б� �Ϸ�...\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileEdit(){
		StringBuilder sb = new StringBuilder();
		
		System.out.println("������ ���ϸ� : ");
		String fileName = sc.next();
		
		try(BufferedReader br = 
				new BufferedReader(
					new FileReader(fileName));
			BufferedWriter bw = 
				new BufferedWriter(
				new FileWriter(fileName, true));) {
			//������ ���� �б�
			String line;
			while((line = br.readLine()) != null)
				sb.append(line + "\n");
			
			//�߰��� ���� �Է¹ޱ�
			System.out.println("���Ͽ� �߰��� ������ �Է��Ͻÿ�." );
			while(!(line = sc.nextLine()).equals("exit")){
				sb.append(line + "\n");
			}
			
			System.out.println("����� ������ ���Ͽ� �߰��Ͻðڽ��ϱ�? (y/n) : ");
			if(sc.next().toUpperCase().charAt(0) == 'Y'){
				bw.write(sb.toString());
				System.out.println(fileName + " ������ ������ ����Ǿ����ϴ�.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
