package prebooking.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class PreBooking implements Serializable {
	private static final long serialVersionUID = -7046887578077558556L;
	
	private int prebookingNo;
	private String userId;
	private String prebookingTitle;
	private String prebookingContent;
	private Date prebookingDate;
	private String answerYn;
	
	public PreBooking() {}

	public PreBooking(int prebookingNo, String userId, String prebookingTitle, String prebookingContent,
			Date prebookingDate, String answerYn) {
		super();
		this.prebookingNo = prebookingNo;
		this.userId = userId;
		this.prebookingTitle = prebookingTitle;
		this.prebookingContent = prebookingContent;
		this.prebookingDate = prebookingDate;
		this.answerYn = answerYn;
	}

	public int getPrebookingNo() {
		return prebookingNo;
	}

	public void setPrebookingNo(int prebookingNo) {
		this.prebookingNo = prebookingNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPrebookingTitle() {
		return prebookingTitle;
	}

	public void setPrebookingTitle(String prebookingTitle) {
		this.prebookingTitle = prebookingTitle;
	}

	public String getPrebookingContent() {
		return prebookingContent;
	}

	public void setPrebookingContent(String prebookingContent) {
		this.prebookingContent = prebookingContent;
	}

	public Date getPrebookingDate() {
		return prebookingDate;
	}

	public void setPrebookingDate(Date prebookingDate) {
		this.prebookingDate = prebookingDate;
	}

	public String getAnswerYn() {
		return answerYn;
	}

	public void setAnswerYn(String answerYn) {
		this.answerYn = answerYn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return
				this.prebookingNo + ", " + this.userId + ", " + this.prebookingTitle + ", "
			  + this.prebookingContent + ", " + this.prebookingDate + ", " + this.answerYn;
	}

}
