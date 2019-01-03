package test.thread;

public class Number /*extends Thread*/
	implements Runnable {
	public Number() {}
	
	@Override
	public void run() {
		for(int k = 1; k < 501; k++) {
			System.out.println(k);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}*/
		}
	}
}
