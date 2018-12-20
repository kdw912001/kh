package practice3;

import java.util.Comparator;

import practice2.Book;

public class AscBookTitle implements Comparator {

	public int compare(Object o1, Object o2) {
		int result = 0;
		if (o1 instanceof Book && o2 instanceof Book) {
			Book b1 = (Book) o1;
			Book b2 = (Book) o2;
			if (b1.getTitle().compareTo(b2.getTitle()) > 0) {
				result = 1;
			} else if (b1.getTitle().compareTo(b2.getTitle()) < 0) {
				result = -1;

			}

		}
		return result;
	}
}
