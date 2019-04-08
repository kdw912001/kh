package question.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Question implements Serializable {
	private static final long serialVersionUID = -4625653056618896760L;
	
	private int questionNo;
	private String questionTitle;
	private String questionContent;
	private Date questionDate;
	private String questionreplyYn;
	private String userId;
	
	public Question () {}

	public Question(int questionNo, String questionTitle, String questionContent, Date questionDate,
			String questionreplyYn, String userId) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionDate = questionDate;
		this.questionreplyYn = questionreplyYn;
		this.userId = userId;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	public String getQuestionreplyYn() {
		return questionreplyYn;
	}

	public void setQuestionreplyYn(String questionreplyYn) {
		this.questionreplyYn = questionreplyYn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", questionTitle=" + questionTitle + ", questionContent="
				+ questionContent + ", questionDate=" + questionDate + ", questionreplyYn=" + questionreplyYn
				+ ", userId=" + userId + "]";
	}

	
	
	}
