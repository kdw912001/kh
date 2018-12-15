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
				System.out.print("국어 점수 입력 : ");
				int kor = sc.nextInt();
				dout.writeInt(kor);
				System.out.print("영어 점수 입력 : ");
				int eng = sc.nextInt();
				dout.writeInt(eng);
				System.out.print("수학 점수 입력 : ");
				int ma = sc.nextInt();
				dout.writeInt(ma);
				
				int sum = kor+eng+ma;
				dout.writeInt(sum);
				double avg = (kor+eng+ma)/3;
				dout.writeDouble(avg);
				System.out.print("계속 저장하시겠습니까?(y/n) : ");
			}while(sc.next().toUpperCase().charAt(0) == 'Y');
			System.out.println("score.dat에 저장 완료.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void scoreRead() {
		/*FileInputStream에 readDouble() the next eight bytes of this input stream, interpreted as a double.
		 * EOFException - if this input stream reaches the end before reading eight bytes.
		 * 마지막으로 입력받은 double값에 EOFException(값이 없을때)이 발생하면 반복문 종료
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
				//printf 소수점 계산시 자동으로 반올림 됨.
				totalSum +=sum;
				totalAvg +=avg;
				count++;
			}while(true);
			//System.out.println("전체총점 : "+totalSum+"전체 평균 : "+totalAvg+"읽은 횟수 : "+count);
			
		}catch(EOFException e) {//마지막으로 저장한 값 readDouble()이 없을 때 실행되는 예외 
			System.out.printf("횟수 : %2d 합평균 : %2d 평균의 합 : %2.2f\n", count,totalSum/count,totalAvg/count);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
