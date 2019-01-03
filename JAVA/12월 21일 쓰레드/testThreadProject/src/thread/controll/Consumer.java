package thread.controll;

public class Consumer implements Runnable {
	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// 10�� ������ : buffer ���� ���� ����
		for(int k = 1; k < 11; k++) {
			int number = buffer.get();
			System.out.println("�Һ��ڰ� "
				+ k + "�� ������ �Һ��Ͽ����ϴ�.");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}




