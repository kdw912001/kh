package make.generic;

public class MyArray<T> { //제네릭 만들기
	//T : type (자료형)
	private T[] array;
	//T객체 배열(자료형이 정해지지않은) MyArray를 사용할 때 자료형이 정해짐
	
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
