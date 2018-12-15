package object.silsub3.model;

public class Product {
	//Field
	private String productID;		//	- productID:String		//��ǰ���̵�
	private String productName;	//	- productName:String	//��ǰ��
	private String productArea;	//	- productArea:String	//������
	private int price;					//	- price:int	//����
	private double tex;				//	- tex:double	//�ΰ�������
	
	//Constructor
	public Product(){}

	public Product(String productID, String productName, String productArea, int price, double tex) {
		this.productID = productID;
		this.productName = productName;
		this.productArea = productArea;
		this.price = price;
		this.tex = tex;
	}

	//Getter and Setter
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTex() {
		return tex;
	}

	public void setTex(double tex) {
		this.tex = tex;
	}
	
	//Method
	public void information(){
		System.out.println(this.productID + ", " 
				+ this.productName + ", " 
				+ this.productArea + ", " 
				+ this.price + ", " 
				+ this.tex);
	}	
}
