package test.thread;

public class Star /*extends Thread*/ 
	implements Runnable {
	public Star() {}
	
	@Override
	public void run() {
		for(int k = 1; k < 501; k++) {
			System.out.println("¡Ú");
			/*try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}*/
		}
	}
}






