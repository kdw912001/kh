package make.generic;

public class MyArray<T> {
	//T : type (�ڷ���)
	private T[] array;
	
	public MyArray(T[] array) {
		this.array = array;
	}
	
	public void setArray(T[] array) {
		this.array = array;
	}
	
	public T[] getArray() {
		return array;
	}
	
	public void displayAll() {
		for(T obj : array) {
			System.out.println(obj);
			//T Ÿ���� toString() �������̵��ؾ� ��
		}
	}
}



