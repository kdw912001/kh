package munjae1;

public class Decrement implements Runnable{
	private int min, max;
	
	public Decrement(int min, int max){
		this.min = min;
		this.max = max;
	}	
	
	@Override
	public void run() {
		// 45���� 12�� ������ 1�� ���ҽ�Ű�� ���� �ݺ���
		// ���� �ϳ� ����� 0.1�� ���� �ְ���.
		for(int k = max; k >= min; k--){
			System.out.println(k + "dec");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
