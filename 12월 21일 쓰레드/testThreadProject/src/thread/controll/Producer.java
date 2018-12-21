package thread.controll;

public class Producer implements Runnable {
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		// 10���� ������ ������
		for(int k = 1; k < 11; k++) {
			buffer.put(k);
			System.out.println("�����ڰ� "
				+ k + "�� ������ �����Ͽ����ϴ�.");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}





