package thread.controll;

public class Buffer {
	private int number;
	private boolean empty = true;
	
	public synchronized int get() {
		while(empty) {
			System.out.println("값이 없어요. 공급될 때까지 기다려 주세요....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//값이 있을 때, empty 가 false 임
		empty = true;
		notifyAll();
		return number;
	}
	
	public synchronized void put(int number) {
		while(!empty) {
			System.out.println("값이 소비될 때까지 기다리세요...");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//값이 없다면, empty 가 true 이면
		empty = false;
		this.number = number;
		notifyAll();
	}
}





