package board.model.vo;

public class BoardPage implements java.io.Serializable{
	private static final long serialVersionUID = -1115751488920669785L;
	private int currentPage;
	private int limit;
	private int startRow;
	private int endRow;
	
	public BoardPage() {}

	public BoardPage(int currentPage, int limit, int startRow, int endRow) {
		super();
		this.currentPage = currentPage;
		this.limit = limit;
		this.startRow = startRow;
		this.endRow = endRow;
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

	public int getStartRow() {
		startRow = (currentPage -1) * limit + 1;
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		endRow = startRow + limit - 1;
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Override
	public String toString() {
		return currentPage + ", " + limit + ", " + startRow + ", " + endRow;
	}
	
}
