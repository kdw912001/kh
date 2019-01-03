package munjae1;

public class Decrement implements Runnable {
	private int start;
	private int end;
	
	public Decrement(int start, int end) {
		this.start=start;
		this.end=end;
	}
	
	public void run() {
		for (int i = end; i >= start; i--) {
			System.out.println(i+"dec");
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
