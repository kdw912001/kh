package obj.array.sample;

//MVC ������������ ������ ��
//Model ���� vo �� �ش��
//VO(Value Object) : �� ����� ��ü
//DO(Domain Object) == entity
//Bean == DTO(Data Transfer Object)

//1. ��� �ʵ�� �ݵ�� private �̾�� ��.
//2. �⺻�����ڿ� �Ű����� �ִ� �����ڸ� 
//	�ݵ�� �ۼ��ؾ� ��
//3. ��� �ʵ忡 ���� getter�� setter �� 
//	�־�� ��
public class Book {
	//Field
	private String title;		//������
	private String author;	//���ڸ�
	private int price;		//����
	private double discountRate;	//���η�
	
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
				+ ", " + this.price + "��, "
				+ this.discountRate + "%";
	}
}












