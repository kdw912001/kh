package thread.controll;

public class TestThreadControll {

	public static void main(String[] args) {
		// ��Ƽ�������� ������-�Һ��� ���α׷� �׽�Ʈ
		Buffer buffer = new Buffer();
		new Thread(new Producer(buffer)).start();
		new Thread(new Consumer(buffer)).start();

	}

}
