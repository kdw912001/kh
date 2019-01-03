package thread.controll;

public class Buffer {
	private int number;
	private boolean empty = true;
	
	public synchronized int get() {
		while(empty) {
			System.out.println("���� �����. ���޵� ������ ��ٷ� �ּ���....");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//���� ���� ��, empty �� false ��
		empty = true;
		notifyAll();
		return number;
	}
	
	public synchronized void put(int number) {
		while(!empty) {
			System.out.println("���� �Һ�� ������ ��ٸ�����...");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//���� ���ٸ�, empty �� true �̸�
		empty = false;
		this.number = number;
		notifyAll();
	}
}





