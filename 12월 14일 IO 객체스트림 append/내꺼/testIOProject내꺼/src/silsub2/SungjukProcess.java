package silsub2;

import java.util.*;
import java.io.*;

public class SungjukProcess {
	private Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		SungjukProcess test = new SungjukProcess();
		//test.sungjukSave();
		test.scoreRead();
	}
	public void sungjukSave() {
		
		try(DataOutputStream dout = new DataOutputStream(
				new FileOutputStream("score.dat"));) {
			do{
				System.out.print("���� ���� �Է� : ");
				int kor = sc.nextInt();
				dout.writeInt(kor);
				System.out.print("���� ���� �Է� : ");
				int eng = sc.nextInt();
				dout.writeInt(eng);
				System.out.print("���� ���� �Է� : ");
				int ma = sc.nextInt();
				dout.writeInt(ma);
				
				int sum = kor+eng+ma;
				dout.writeInt(sum);
				double avg = (kor+eng+ma)/3;
				dout.writeDouble(avg);
				System.out.print("��� �����Ͻðڽ��ϱ�?(y/n) : ");
			}while(sc.next().toUpperCase().charAt(0) == 'Y');
			System.out.println("score.dat�� ���� �Ϸ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void scoreRead() {
		/*FileInputStream�� readDouble() the next eight bytes of this input stream, interpreted as a double.
		 * EOFException - if this input stream reaches the end before reading eight bytes.
		 * ���������� �Է¹��� double���� EOFException(���� ������)�� �߻��ϸ� �ݺ��� ����
		 */
		int count = 0;
		int totalSum=0;
		double totalAvg=0;
		try(DataInputStream din = new DataInputStream(
				new FileInputStream("score.dat"));){
			
			do{
				int kor = din.readInt();
				int eng = din.readInt();
				int ma = din.readInt();
				int sum = din.readInt();
				double avg = din.readDouble();
						
				//System.out.println(kor+" "+eng+" "+ma+" "+sum+" "+avg);
				System.out.printf("%5d%5d%5d%5d%7.2f\n", kor,eng,ma,sum,avg);
				//printf �Ҽ��� ���� �ڵ����� �ݿø� ��.
				totalSum +=sum;
				totalAvg +=avg;
				count++;
			}while(true);
			//System.out.println("��ü���� : "+totalSum+"��ü ��� : "+totalAvg+"���� Ƚ�� : "+count);
			
		}catch(EOFException e) {//���������� ������ �� readDouble()�� ���� �� ����Ǵ� ���� 
			System.out.printf("Ƚ�� : %2d ����� : %2d ����� �� : %2.2f\n", count,totalSum/count,totalAvg/count);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
