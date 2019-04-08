package faq.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Faq implements Serializable {
	private static final long serialVersionUID = -7616138761377886352L;
	
	private int faqNo;
	private String faqTitle;
	private String faqContent;
	private Date faqDate;
	private String managerId;
	private String faqType;
	
	public Faq () {}

	public Faq(int faqNo, String faqTitle, String faqContent, Date faqDate, String managerId, String faqType) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqDate = faqDate;
		this.managerId = managerId;
		this.faqType = faqType;
	}
	
	public String getFaqType() {
		return faqType;
	}
	
	public void setFaqType(String faqType) {
		this.faqType = faqType;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public Date getFaqDate() {
		return faqDate;
	}

	public void setFaqDate(Date faqDate) {
		this.faqDate = faqDate;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return this.faqNo + ", " + this.faqTitle + ", " + this.faqContent + ", " + this.faqDate + ", "
			 + ", " + this.managerId + ", " + this.faqType;
	}

}
