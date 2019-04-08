package freeboard.model.vo;

import java.sql.Date;

public class FreeBoard {
	
	public FreeBoard() {}
	
	private int freeboardNo;
	private String freeboardTitle;
	private String freeboardContent;
	private Date freeboardDate;
	private String freeboardOriginalFile;
	private int freeboardViews;
	private int freeboardRecommend;
	private String userId;
	private String freeboardDelete;
	private String freeboardRefile;
	
	
	public FreeBoard(int freeboardNo, String freeboardTitle, String freeboardContent, Date freeboardDate,
			String freeboardOriginalFile, int freeboardViews, int freeboardRecommend, String userId,
			String freeboardDelete, String freeboardRefile) {
		super();
		this.freeboardNo = freeboardNo;
		this.freeboardTitle = freeboardTitle;
		this.freeboardContent = freeboardContent;
		this.freeboardDate = freeboardDate;
		this.freeboardOriginalFile = freeboardOriginalFile;
		this.freeboardViews = freeboardViews;
		this.freeboardRecommend = freeboardRecommend;
		this.userId = userId;
		this.freeboardDelete = freeboardDelete;
		this.freeboardRefile = freeboardRefile;
	}


	public int getFreeboardNo() {
		return freeboardNo;
	}


	public void setFreeboardNo(int freeboardNo) {
		this.freeboardNo = freeboardNo;
	}


	public String getFreeboardTitle() {
		return freeboardTitle;
	}


	public void setFreeboardTitle(String freeboardTitle) {
		this.freeboardTitle = freeboardTitle;
	}


	public String getFreeboardContent() {
		return freeboardContent;
	}


	public void setFreeboardContent(String freeboardContent) {
		this.freeboardContent = freeboardContent;
	}


	public Date getFreeboardDate() {
		return freeboardDate;
	}


	public void setFreeboardDate(Date freeboardDate) {
		this.freeboardDate = freeboardDate;
	}


	public String getFreeboardOriginalFile() {
		return freeboardOriginalFile;
	}


	public void setFreeboardOriginalFile(String freeboardOriginalFile) {
		this.freeboardOriginalFile = freeboardOriginalFile;
	}


	public int getFreeboardViews() {
		return freeboardViews;
	}


	public void setFreeboardViews(int freeboardViews) {
		this.freeboardViews = freeboardViews;
	}


	public int getFreeboardRecommend() {
		return freeboardRecommend;
	}


	public void setFreeboardRecommend(int freeboardRecommend) {
		this.freeboardRecommend = freeboardRecommend;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFreeboardDelete() {
		return freeboardDelete;
	}


	public void setFreeboardDelete(String freeboardDelete) {
		this.freeboardDelete = freeboardDelete;
	}


	public String getFreeboardRefile() {
		return freeboardRefile;
	}


	public void setFreeboardRefile(String freeboardRefile) {
		this.freeboardRefile = freeboardRefile;
	}


	@Override
	public String toString() {
		return "FreeBoard [freeboardNo=" + freeboardNo + ", freeboardTitle=" + freeboardTitle + ", freeboardContent="
				+ freeboardContent + ", freeboardDate=" + freeboardDate + ", freeboardOriginalFile="
				+ freeboardOriginalFile + ", freeboardViews=" + freeboardViews + ", freeboardRecommend="
				+ freeboardRecommend + ", userId=" + userId + ", freeboardDelete=" + freeboardDelete
				+ ", freeboardRefile=" + freeboardRefile + "]";
	}
	

}
