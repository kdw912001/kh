package practice3;
import java.util.*;
import java.util.Map.Entry;

import practice2.AscCategory;
import practice2.Book;
public class BookManagerMap {
	HashMap booksMap; //도서번호를 키로 사용함
	
	public BookManagerMap() {
		booksMap = new HashMap();
	}
	public BookManagerMap(HashMap booksMap) {
//		booksMap 객체의 초기값으로 생성함->뭔말이야
		this.booksMap=booksMap;
	}
	
	public void putBook(Book book) {
		//내가한거booksMap.put(book.getbNo(),new Book(book.getbNo(),book.getCategory(),book.getTitle(),book.getAuthor()));
		booksMap.put(book.getbNo(), book);
	}
	public void removeBook(String key) {
		booksMap.remove(key);
	}
	public String searchBook(String bTitle) {
		Set bookSet = booksMap.entrySet();
		Iterator entryIter = bookSet.iterator();
		
		while(entryIter.hasNext()) {
			Object obj = entryIter.next();
			Map.Entry entry = (Map.Entry) obj;
			Book value = (Book) entry.getValue();
			if(value.getTitle().equals(bTitle))
				return (String)(entry.getKey());
		}
		return null;
	}
	public void displayAll() {
		//내가한거System.out.println(booksMap);
		Iterator booksIter = booksMap.keySet().iterator();
		while(booksIter.hasNext()){
			System.out.println(booksMap.get(booksIter.next()));
		}
	}
	
	public Book[] sortedBookMap() {
		/*Set bookSet = booksMap.entrySet();
		Iterator entryIter = bookSet.iterator();
		Book[] value = new Book[booksMap.size()];
		int index=0;
		while(entryIter.hasNext()) {
			Object obj = entryIter.next();
			Map.Entry entry = (Map.Entry) obj;
			value[index] = (Book) entry.getValue();
			index++;
		}
		
		Book tmp = null;
		for(int i=0; i<value.length-1;i++) {
			for(int j=i+1; j<value.length;j++) {
				if((value[i].getTitle()).compareTo(value[j].getTitle())>0) {
					tmp = value[i];
					value[i]=value[j];
					value[j]=tmp;
				}
			}
		}
		return value;*/
		List booksList = new ArrayList(booksMap.values());
		//values로 Collection으로 바꾼 후 new ArrayList의 생성자 이용
		booksList.sort(new AscBookTitle());
		
		Book[] bar = new Book[booksList.size()];
		booksList.toArray(bar);
		
		return bar;
	}
	public void printBokMap(Book[]br) {
		for(Book b:br)
			System.out.println(b);
	}
	public void printBook(String key) {
		System.out.println(booksMap.get(key));
	}
}
