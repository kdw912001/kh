package make.generic;

public class TestMyArray {

	public static void main(String[] args) {
		// MyArray test
		MyArray<Integer> arr1 = 
			new MyArray<Integer>(
				new Integer[] {10, 20, 30, 40, 50});
		
		arr1.displayAll();

		MyArray<String> arr2 = 
			new MyArray<String>(
				new String[] {"java", "oracle", "jsp/servlet"});
		arr2.displayAll();
	}

}






