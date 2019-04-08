package notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable {
	private static final long serialVersionUID = 5875954839993211121L;
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeDate;
	private String noticeOriginFile;
	private String noticeReFile;
	private int noticeViews;
	private String managerId;
	private String noticeDelete;
	
	public Notice () {}

	public Notice(int noticeNo, String noticeTitle, String noticeContent, Date noticeDate, String noticeOriginFile,
			String noticeReFile, int noticeViews, String managerId, String noticeDelete) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeOriginFile = noticeOriginFile;
		this.noticeReFile = noticeReFile;
		this.noticeViews = noticeViews;
		this.managerId = managerId;
		this.noticeDelete = noticeDelete;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeOriginFile() {
		return noticeOriginFile;
	}

	public void setNoticeOriginFile(String noticeOriginFile) {
		this.noticeOriginFile = noticeOriginFile;
	}

	public String getNoticeReFile() {
		return noticeReFile;
	}

	public void setNoticeReFile(String noticeReFile) {
		this.noticeReFile = noticeReFile;
	}

	public int getNoticeViews() {
		return noticeViews;
	}

	public void setNoticeViews(int noticeViews) {
		this.noticeViews = noticeViews;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getNoticeDelete() {
		return noticeDelete;
	}

	public void setNoticeDelete(String noticeDelete) {
		this.noticeDelete = noticeDelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString () {
		return
				this.noticeNo + ", " + this.noticeTitle + ", " + this.noticeContent + ", " + this.noticeDate + ", " + this.noticeOriginFile + ", "
			  + this.noticeReFile + ", " + this.noticeViews + ", " + this.managerId + ", " + this.noticeDelete;
	}

}
