package practice2;

import java.util.*;

public class BookManager {
	private ArrayList<Book> bookList;
	
	public BookManager() {
		bookList = new ArrayList<Book>();
	}
	
	public BookManager(ArrayList<Book> bookList) {
		this.bookList=new ArrayList<Book>(bookList);
	}
	
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public void deleteBook(int index) {
		bookList.remove(index);
	}
	
	public int searchBook(String bTitle) {
		for(int i=0; i<bookList.size(); i++) {
			//if(((Book)(bookList.get(i))).getTitle().equals(bTitle))
			if(bookList.get(i).getTitle().equals(bTitle) == true){
				//bookList가 제네릭 적용되면 형변환할 필요없음.
				return i;
			}
		}
		return -1;
	}
	public void printBook(int index) {
		System.out.println(bookList.get(index));
	}
	public void displayAll() {
		System.out.println(bookList);
		/*선생님한거
		 * for(int i = 0; i < bookList.size(); i++)
			System.out.println(bookList.get(i));
		 */
	}
	public Book[] sortedBookList() {
		Book[] b = new Book[bookList.size()];
		bookList.sort(new AscCategory());
		bookList.toArray(b);//API내 toArray(T[] a) 활용
		/*for(int i=0; i<bookList.size();i++) {
			b[i] = (Book)(bookList.get(i));
		}
		*/return b;
	}
	public void printBookList(Book[] br) {
		for(Object o : br) {
			System.out.println(o);
		}
	}
}
