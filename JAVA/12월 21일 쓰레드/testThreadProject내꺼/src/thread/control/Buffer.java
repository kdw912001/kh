package thread.control;

public class Buffer {//공유객체 - 메소드 동기화를 해야 함.
	private int number;
	private boolean empty = true;
	
	public synchronized int get() {//synchronized 동기화 처리
		//한 스레드가 이 메소드를 사용하고 있다면 다른 스레드는 이 메소드가 끝날 때까지 기다려야 함.
		while(empty) {
			System.out.println("값이 없어요. 공급될 때까지 기다려 주세요...");
			try {
				wait();//Object의 wait()메소드 
				//실행을 강제로 멈추기 때문에 InterruptedException 발생
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//값이 있을 때, empty가 false임
		empty = true; //while문에서 나와 empty false를 true로 바꿈
		notifyAll();//기다리고 있는 모든 스레드 깨움
		return number;
	}
	
	public synchronized void put(int number) {
		//값을 넣고 뺴는 과정일 때 동기화 처리 해야 함.
		while(!empty) {
			System.out.println("값이 소비될 떄까지 기다리세요...");
			try {
				wait();//값이 소비될 때까지 wait()
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//값이 없다면, empty가 true이면 
		empty = false;
		this.number=number;
		notifyAll(); //다시 실행상태로 // 실행하라
	}
}
