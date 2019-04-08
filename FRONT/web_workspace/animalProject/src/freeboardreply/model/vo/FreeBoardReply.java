package freeboardreply.model.vo;

import java.sql.Date;

public class FreeBoardReply {

	private int freereply;
	private String freereplycontent;
	private Date freereplydate;
	private String userid;
	private int freeboardno;
	private String freeboarddelete;
	
	
	public FreeBoardReply(int freereply, String freereplycontent, Date freereplydate, String userid, int freeboardno,
			String freeboarddelete) {
		super();
		this.freereply = freereply;
		this.freereplycontent = freereplycontent;
		this.freereplydate = freereplydate;
		this.userid = userid;
		this.freeboardno = freeboardno;
		this.freeboarddelete = freeboarddelete;
	}

	
	public int getFreereply() {
		return freereply;
	}

	public void setFreereply(int freereply) {
		this.freereply = freereply;
	}

	public String getFreereplycontent() {
		return freereplycontent;
	}

	public void setFreereplycontent(String freereplycontent) {
		this.freereplycontent = freereplycontent;
	}

	public Date getFreereplydate() {
		return freereplydate;
	}

	public void setFreereplydate(Date freereplydate) {
		this.freereplydate = freereplydate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getFreeboardno() {
		return freeboardno;
	}

	public void setFreeboardno(int freeboardno) {
		this.freeboardno = freeboardno;
	}

	public String getFreeboarddelete() {
		return freeboarddelete;
	}

	public void setFreeboarddelete(String freeboarddelete) {
		this.freeboarddelete = freeboarddelete;
	}

	
	@Override
	public String toString() {
		return "FreeBoardReply [freereply=" + freereply + ", freereplycontent=" + freereplycontent + ", freereplydate="
				+ freereplydate + ", userid=" + userid + ", freeboardno=" + freeboardno + ", freeboarddelete="
				+ freeboarddelete + "]";
	}
	
	
	
	
}
