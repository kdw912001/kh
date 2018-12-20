package make.generic;

public class MyArray<T> {
	//T : type (자료형)
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
			//T 타입은 toString() 오버라이딩해야 함
		}
	}
}



