package board.model.vo;

public class BoardPage implements java.io.Serializable{
	private static final long serialVersionUID = 8000L;
	
	private int currentPage;
	private int limit; 
	
	public BoardPage() {}

	public BoardPage(int currentPage, int limit) {
		super();
		this.currentPage = currentPage;
		this.limit = limit;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return this.currentPage + ", " + this.limit;
	}
}
