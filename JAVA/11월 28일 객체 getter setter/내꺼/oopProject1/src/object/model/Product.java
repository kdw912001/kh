package object.model;

public class Product {
	private String productID;
	private String productName;
	private String productArea;
	private int price;
	private double tex;
	
	public Product() {}
	
	public Product(String productID, String productName, String productArea,
					int price, double tex) {
		this.productID=productID;
		this.productName=productName;
		this.productArea=productArea;
		this.price = price;
		this.tex=tex;
	}
	
	public void information() {
		System.out.println(this.productID+"\t"+this.productName+" "+this.productArea+" "+
							this.price+" "+this.tex); 
		//this생략 가능하지만 this쓰면 변수이름이 바로 나오기 때문에 빨리 작성 가능
	}
	
	public void setProductId(String productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setTex(double tex) {
		this.tex = tex;
	}
	
	public String getProductId() {
		return this.productID;
	}
	public String getProductName() {
		return this.productName;
	}
	public String getProductArea() {
		return this.productArea;
	}
	public int getPrice() {
		return this.price;
	}
	public double getTex() {
		return this.tex;
	}
}
