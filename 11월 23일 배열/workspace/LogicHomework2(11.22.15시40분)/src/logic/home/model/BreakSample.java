package logic.home.model;

public class BreakSample {
	public void sumBreak() {
		int sum = 0;
		for(int i=1;;i++) {
			sum+=i;
			if(i==100)
				break;
		}
		System.out.println("1~100���� �������� �� : "+sum);
	}
	public void guguDanBreak() {
		for(int i=1;i<=9;i++) {
			System.out.println(i+"��");
			loop1:for(int j=1;j<=9;j++) {
				if(j==5)
					break loop1;
				System.out.println(i+"x"+j+"="+(i*j));
				
			}
			System.out.println("------------------");
		}
	}
	
}
