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
				System.out.print("���� : ");
				int kor = sc.nextInt();
				System.out.print("���� : ");
				int eng = sc.nextInt();
				System.out.print("���� : ");
				int mat = sc.nextInt();
				
				int tot = kor + eng + mat;
				double avg = tot / 3.0;
				
				dout.writeInt(kor);
				dout.writeInt(eng);
				dout.writeInt(mat);
				dout.writeInt(tot);
				dout.writeDouble(avg);
				
				System.out.print("��� �����Ͻðڽ��ϱ�? (y/n) : ");
				
			}while(sc.next().toUpperCase().charAt(0) != 'N');
			
			System.out.println("score.dat �� ���� �Ϸ�...");
			
		}catch(IOException e){
			System.out.println("score.dat ���Ͽ� ���� ����...");
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
			System.out.println("score.dat ���� �б� �Ϸ�...");
			
		}catch(IOException e){
			System.out.println("score.dat ���� �б� ����...");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// ����� �ǽ����� 2
		SungjukProcess test2 = new SungjukProcess();
		test2.sungjukSave();
		test2.scoreRead();
	}

}

