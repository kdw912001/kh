package practice2;

import java.util.*;

public class BookManager {
	private ArrayList<Book> bookList;
	
	public BookManager(){
		bookList = new ArrayList<Book>();
	}
	
	public BookManager(ArrayList<Book> bookList){
		this.bookList = bookList;
	}

	public void addBook(Book book) {
		//����Ʈ�� ��ü �߰�
		bookList.add(book);
	}

	public Book[] sortedBookList() {
		// �ش� ī�װ��� �������������ؼ� ��ü�迭 ������
		bookList.sort(new AscCategory());
		Book[] bar = new Book[bookList.size()];
		bookList.toArray(bar);
		return bar;
	}

	public void printBookList(Book[] books) {
		//��ü �迭 ���, for each �� ���
		for(Book b : books)
			System.out.println(b);
	}

	public void deleteBook(int index) {
		//����Ʈ���� ��ü ����
		bookList.remove(index);
	}

	public int searchBook(String bookTitle) {
		//�������� ��ġ�ϴ� ��ü�� ã�� �ش� �ε����� ����
		//�������� ��ġ�ϴ� ��ü�� ����Ʈ�� ������, -1 ������
		int result = -1;
		
		for(int i = 0; i < bookList.size(); i++){
			if(bookList.get(i).getTitle().equals(bookTitle) == true){
				result = i;
				break;
			}
		}
		
		return result;
	}

	public void displayAll() {
		//������� ��� ���
		for(int i = 0; i < bookList.size(); i++)
			System.out.println(bookList.get(i));
	}

	public void printBook(int index) {
		//�ε��� ��ġ�� ��ü�� ������ �����
		System.out.println(bookList.get(index));
	}
}
