package munjae1;

public class Decrement implements Runnable{
	private int min, max;
	
	public Decrement(int min, int max){
		this.min = min;
		this.max = max;
	}	
	
	@Override
	public void run() {
		// 45부터 12될 때까지 1씩 감소시키는 내용 반복함
		// 숫자 하나 출력후 0.1초 멈춰 있게함.
		for(int k = max; k >= min; k--){
			System.out.println(k + "dec");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
