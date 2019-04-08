package message.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String senderId;
	private String messageTitle;
	private String messageContent;
	private String messageRead;
	private Date messageDate;
	private String userId;
	
	public Message() {}

	public Message(String senderId, String messageTitle, String messageContent, String messageRead, Date messageDate,
			String userId) {
		super();
		this.senderId = senderId;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.messageRead = messageRead;
		this.messageDate = messageDate;
		this.userId = userId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageRead() {
		return messageRead;
	}

	public void setMessageRead(String messageRead) {
		this.messageRead = messageRead;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
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
	public String toString () {
		return
				this.senderId + ", " + this.messageTitle + ", " + this.messageContent + ", " + this.messageRead + ", "
			  + this.messageDate + ", " + this.userId;
	}

}
