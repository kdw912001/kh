package io.silsub1;

import java.util.*;
import java.io.*;

public class MyNote {
	private Scanner sc = new Scanner(System.in);
	
	public MyNote(){}
	
	public void fileSave(){
		StringBuilder sb = new StringBuilder();
		
		System.out.println(
			"파일에 저장할 내용을 입력하시오");
		while(true){			
			String s = sc.nextLine();			
			if(s.equals("exit"))	break;			
			sb.append(s + "\n");
		}
		
		System.out.println("저장하시겠습니까? (y/n) : ");			
		if(sc.next().toUpperCase().charAt(0) == 'Y'){			
			System.out.println("저장할 파일명 : ");
			String fileName = sc.next();
			
			try(BufferedWriter bw = 
				new BufferedWriter(
					new FileWriter(fileName))){
				bw.write(sb.toString());
				bw.flush();
				System.out.println(fileName 
					+ "파일에 성공적으로 저장하였습니다.");
				System.out.println();
			}catch(IOException e){
				e.printStackTrace();
			}
		}	

	}
	
	public void fileOpen(){
		System.out.println("열기할 파일명 : ");
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
				fileName + " 읽기 완료...\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileEdit(){
		StringBuilder sb = new StringBuilder();
		
		System.out.println("수정할 파일명 : ");
		String fileName = sc.next();
		
		try(BufferedReader br = 
				new BufferedReader(
					new FileReader(fileName));
			BufferedWriter bw = 
				new BufferedWriter(
				new FileWriter(fileName, true));) {
			//파일의 내용 읽기
			String line;
			while((line = br.readLine()) != null)
				sb.append(line + "\n");
			
			//추가할 내용 입력받기
			System.out.println("파일에 추가할 내용을 입력하시오." );
			while(!(line = sc.nextLine()).equals("exit")){
				sb.append(line + "\n");
			}
			
			System.out.println("변경된 내용을 파일에 추가하시겠습니까? (y/n) : ");
			if(sc.next().toUpperCase().charAt(0) == 'Y'){
				bw.write(sb.toString());
				System.out.println(fileName + " 파일의 내용이 변경되었습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
