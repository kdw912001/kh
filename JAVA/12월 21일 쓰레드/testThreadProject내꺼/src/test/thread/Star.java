package test.thread;

public class Star /*extends Thread*/implements Runnable{
	//멀티스레드를 사용하려면 상속받아야함
	//Thread 상속받지 못하면 Runnable 인터페이스 사용
	public Star() {}
	
	@Override
	public void run() {
		for(int k = 1; k<501; k++) {
			System.out.println("★");
			/*try {
				Thread.sleep(100L);
				//0.1초간 멈추고, 다른 스레드에 실행권 넘김
				//InterruptedException 발생
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
}
