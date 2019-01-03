package thread.controll;

public class Consumer implements Runnable {
	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// 10번 구동함 : buffer 에서 값을 꺼냄
		for(int k = 1; k < 11; k++) {
			int number = buffer.get();
			System.out.println("소비자가 "
				+ k + "번 물건을 소비하였습니다.");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}




