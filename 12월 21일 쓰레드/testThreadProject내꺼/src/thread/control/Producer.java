package thread.control;

public class Producer implements Runnable{
	//Consumer 와 Producer가 같이 이용할 수 있는 공용공간 생성
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer=buffer;
	}
	
	
	@Override
	public void run() {
		// 10번을 정수를 공급함
		for(int k = 1; k <11; k++) {
			buffer.put(k);
			System.out.println("생산자가 " + k + "번 물건을 생산하였습니다.");
			try {
				Thread.sleep(100); //값을 넣고 잠깐 대기 시간
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
