package product.model.vo;

public class Product implements java.io.Serializable{
	
	private String productID;
	private String pName;
	private int price;
	private String description;
	
	public Product(){}

	public Product(String productID, String pName, int price, String description) {
		super();
		this.productID = productID;
		this.pName = pName;
		this.price = price;
		this.description = description;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		return productID + ", " + pName + ", " + price + ", " + description;
	}
}
