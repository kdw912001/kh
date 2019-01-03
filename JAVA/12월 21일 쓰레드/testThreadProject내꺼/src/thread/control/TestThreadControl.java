package thread.control;

public class TestThreadControl {

	public static void main(String[] args) {
		// 멀티스레드의 생산자-소비자 프로그램 테스트
		Buffer buffer = new Buffer();
		new Thread(new Producer(buffer)).start();
		new Thread(new Consumer(buffer)).start();
		
	}
}
