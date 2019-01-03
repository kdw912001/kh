package munjae1;

public class Increment implements Runnable {
	private int limit;
	
	public Increment(int limit){
		this.limit = limit;
	}	
	
	@Override
	public void run() {
		// 1���� limit ������ 2�� ���� �ݺ� ���
		// ���� �ϳ� ����� 0.05�� �����ְ� ��
		for(int k = 1; k <= limit; k+=2){
			System.out.println(k + "inc");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
