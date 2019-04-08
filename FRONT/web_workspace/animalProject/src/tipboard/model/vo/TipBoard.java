package tipboard.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class TipBoard implements Serializable{
	private static final long serialVersionUID = -3274317731419044500L;
	
	private int tipBoardNo;
	private String tipBoardTitle;
	private String tipBoardContent;
	private Date tipBoardDate;
	private String tipBoardOriginFile;
	private String tipBoardReFile;
	private int tipBoardViews;
	private int tipBoardRecommend;
	private String userId;
	private String tipBoardDelete;
	
	public TipBoard() {}
	
	public TipBoard(int tipBoardNo, String tipBoardTitle, String tipBoardContent, Date tipBoardDate,
			String tipBoardOriginFile, String tipBoardReFile, int tipBoardViews, int tipBoardRecommend, String userId,
			String tipBoardDelete) {
		super();
		this.tipBoardNo = tipBoardNo;
		this.tipBoardTitle = tipBoardTitle;
		this.tipBoardContent = tipBoardContent;
		this.tipBoardDate = tipBoardDate;
		this.tipBoardOriginFile = tipBoardOriginFile;
		this.tipBoardReFile = tipBoardReFile;
		this.tipBoardViews = tipBoardViews;
		this.tipBoardRecommend = tipBoardRecommend;
		this.userId = userId;
		this.tipBoardDelete = tipBoardDelete;
	}
	public int getTipBoardNo() {
		return tipBoardNo;
	}
	public void setTipBoardNo(int tipBoardNo) {
		this.tipBoardNo = tipBoardNo;
	}
	public String getTipBoardTitle() {
		return tipBoardTitle;
	}
	public void setTipBoardTitle(String tipBoardTitle) {
		this.tipBoardTitle = tipBoardTitle;
	}
	public String getTipBoardContent() {
		return tipBoardContent;
	}
	public void setTipBoardContent(String tipBoardContent) {
		this.tipBoardContent = tipBoardContent;
	}
	public Date getTipBoardDate() {
		return tipBoardDate;
	}
	public void setTipBoardDate(Date tipBoardDate) {
		this.tipBoardDate = tipBoardDate;
	}
	public String getTipBoardOriginFile() {
		return tipBoardOriginFile;
	}
	public void setTipBoardOriginFile(String tipBoardOriginFile) {
		this.tipBoardOriginFile = tipBoardOriginFile;
	}
	public String getTipBoardReFile() {
		return tipBoardReFile;
	}
	public void setTipBoardReFile(String tipBoardReFile) {
		this.tipBoardReFile = tipBoardReFile;
	}
	public int getTipBoardViews() {
		return tipBoardViews;
	}
	public void setTipBoardViews(int tipBoardViews) {
		this.tipBoardViews = tipBoardViews;
	}
	public int getTipBoardRecommend() {
		return tipBoardRecommend;
	}
	public void setTipBoardRecommend(int tipBoardRecommend) {
		this.tipBoardRecommend = tipBoardRecommend;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTipBoardDelete() {
		return tipBoardDelete;
	}
	public void setTipBoardDelete(String tipBoardDelete) {
		this.tipBoardDelete = tipBoardDelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return tipBoardNo + ", " + tipBoardTitle + ", " + tipBoardContent + ", " + tipBoardDate + ", "
				+ tipBoardOriginFile + ", " + tipBoardReFile + ", " + tipBoardViews + ", " + tipBoardRecommend + ", "
				+ userId + ", " + tipBoardDelete;
	}
	
	
}
