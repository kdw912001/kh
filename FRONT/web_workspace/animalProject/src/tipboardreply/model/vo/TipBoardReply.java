package tipboardreply.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class TipBoardReply implements Serializable {
	private static final long serialVersionUID = 8180445680639860893L;
	
	private int tipReplyNo;
	private String tipReplyContent;
	private Date tipReplyDate;
	private int tipNo;
	private String userId;
	private String tipReplyDelete;
	
	public TipBoardReply () {}

	public TipBoardReply(int tipReplyNo, String tipReplyContent, Date tipReplyDate, int tipNo, String userId,
			String tipReplyDelete) {
		super();
		this.tipReplyNo = tipReplyNo;
		this.tipReplyContent = tipReplyContent;
		this.tipReplyDate = tipReplyDate;
		this.tipNo = tipNo;
		this.userId = userId;
		this.tipReplyDelete = tipReplyDelete;
	}

	public int getTipReplyNo() {
		return tipReplyNo;
	}

	public void setTipReplyNo(int tipReplyNo) {
		this.tipReplyNo = tipReplyNo;
	}

	public String getTipReplyContent() {
		return tipReplyContent;
	}

	public void setTipReplyContent(String tipReplyContent) {
		this.tipReplyContent = tipReplyContent;
	}

	public Date getTipReplyDate() {
		return tipReplyDate;
	}

	public void setTipReplyDate(Date tipReplyDate) {
		this.tipReplyDate = tipReplyDate;
	}

	public int getTipNo() {
		return tipNo;
	}

	public void setTipNo(int tipNo) {
		this.tipNo = tipNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTipReplyDelete() {
		return tipReplyDelete;
	}

	public void setTipReplyDelete(String tipReplyDelete) {
		this.tipReplyDelete = tipReplyDelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString () {
		return
				this.tipReplyNo + ", " + this.tipReplyContent + ", " + this.tipReplyDate + ", " + this.tipNo + ", "
			  + this.userId + ", " + this.tipReplyDelete;
	}

}
