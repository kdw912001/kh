package obj.array.sample;

//MVC 디자인패턴을 적용할 때
//Model 에서 vo 에 해당됨
//VO(Value Object) : 값 저장용 객체
//DO(Domain Object) == entity
//Bean == DTO(Data Transfer Object)

//1. 모든 필드는 반드시 private 이어야 함.
//2. 기본생성자와 매개변수 있는 생성자를 
//	반드시 작성해야 함
//3. 모든 필드에 대한 getter와 setter 가 
//	있어야 함
public class Book {
	//Field
	private String title;		//도서명
	private String author;	//저자명
	private int price;		//가격
	private double discountRate;	//할인률
	
	//Constructor
	public Book() {}
	
	public Book(String title, String author,
			int price, double discountRate) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}
	
	//Method
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getPrice() {
		return price;
	}
	
	public double getDiscountRate() {
		return discountRate;
	}
	
	public String bookInfo() {
		return this.title + ", " + this.author
				+ ", " + this.price + "원, "
				+ this.discountRate + "%";
	}
}












