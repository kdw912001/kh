package thread.controll;

public class Producer implements Runnable {
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		// 10번을 정수를 공급함
		for(int k = 1; k < 11; k++) {
			buffer.put(k);
			System.out.println("생산자가 "
				+ k + "번 물건을 생산하였습니다.");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}





