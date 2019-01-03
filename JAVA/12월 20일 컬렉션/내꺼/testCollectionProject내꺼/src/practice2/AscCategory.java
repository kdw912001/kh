package practice2;
import java.util.*;
public class AscCategory implements Comparator{
	public int compare(Object o1,Object o2) {
		int result =0;
		if(o1 instanceof Book && o2 instanceof Book) {
			Book b1 = (Book)o1;
			Book b2 = (Book)o2;
			if(b1.getCategory()>b2.getCategory()) {
				result =1; 
			}
			if(b1.getCategory()<b2.getCategory()) {
				result = -1;
			}
			if(b1.getCategory()==b2.getCategory()) {
				result =0;
			}
			//선생님 코드
			/*result = (b1.getCategory() > b2.getCategory())? 1 : 
				((b1.getCategory() == b2.getCategory())? 0 : -1);*/
		}
		return result;
	}
}
