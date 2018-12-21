package munjae1;

public class Increment implements Runnable {
	private int limit;
	
	public Increment(int limit){
		this.limit = limit;
	}	
	
	@Override
	public void run() {
		// 1부터 limit 값까지 2씩 증가 반복 출력
		// 숫자 하나 출력후 0.05초 멈춰있게 함
		for(int k = 1; k <= limit; k+=2){
			System.out.println(k + "inc");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
