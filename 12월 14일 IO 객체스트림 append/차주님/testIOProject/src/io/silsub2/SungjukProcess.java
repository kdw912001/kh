package io.silsub2;

import java.io.*;
import java.util.*;

public class SungjukProcess {
	private Scanner sc = new Scanner(System.in);
	
	public SungjukProcess(){}
	
	public void sungjukSave(){
		
		try(DataOutputStream dout = 
				new DataOutputStream(
					new FileOutputStream("score.dat"));){
			do{
				System.out.print("국어 : ");
				int kor = sc.nextInt();
				System.out.print("영어 : ");
				int eng = sc.nextInt();
				System.out.print("수학 : ");
				int mat = sc.nextInt();
				
				int tot = kor + eng + mat;
				double avg = tot / 3.0;
				
				dout.writeInt(kor);
				dout.writeInt(eng);
				dout.writeInt(mat);
				dout.writeInt(tot);
				dout.writeDouble(avg);
				
				System.out.print("계속 저장하시겠습니까? (y/n) : ");
				
			}while(sc.next().toUpperCase().charAt(0) != 'N');
			
			System.out.println("score.dat 에 저장 완료...");
			
		}catch(IOException e){
			System.out.println("score.dat 파일에 저장 실패...");
			e.printStackTrace();
		}		
		
	}
	
	public void scoreRead(){
		int totalSum = 0, count = 0;
		double totalAvg = 0;
		
		try(DataInputStream din = 
				new DataInputStream(
					new FileInputStream("score.dat"))){
			do{
				int kor = din.readInt();
				int eng = din.readInt();
				int mat = din.readInt();
				int tot = din.readInt();
				double avg = din.readDouble();
				
				System.out.printf("%5d%5d%5d%5d%7.2f\n", 
						kor, eng, mat, tot, avg);
				
				totalSum += tot;
				totalAvg += avg;
				count++;
			}while(true);
			
		}catch(EOFException e){
			System.out.printf("%5d%15d%7.2f\n", 
					count, totalSum/count, totalAvg/count);
			System.out.println("score.dat 파일 읽기 완료...");
			
		}catch(IOException e){
			System.out.println("score.dat 파일 읽기 실패...");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// 입출력 실습문제 2
		SungjukProcess test2 = new SungjukProcess();
		test2.sungjukSave();
		test2.scoreRead();
	}

}

