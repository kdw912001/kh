package munjae1;

public class Increment implements Runnable{
	private int num;
	
	public Increment(int num) {
		this.num=num;
	}
	
	public void run() {
		for(int i=1; i<=num; i+=2) {
			System.out.println(i+"inc");
			try {
				Thread.sleep(50L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
