package book.mvc.model.vo;

import java.sql.Date;

public class Book implements java.io.Serializable {
	private static final long serialVersionUID = 2L;
	
	private int bookId;
	private String title;
	private String author;
	private String publisher;
	private Date publishDate;
	private int price;
	
	public Book() {}

	public Book(int bookId, String title, String author, String publisher, Date publishDate, int price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return bookId + ", " + title + ", " + author
			+ ", " + publisher + ", " + publishDate
			+ ", " + price;
	}
}








