package review.model.vo;

import java.io.Serializable;

public class Review implements Serializable {
	private static final long serialVersionUID = -5555128744764844463L;
	
	private int reviewNo;
	private String userId;
	private int bookingNo;
	private String point;
	private String reviewContent;
	private String reviewOriginFile;
	private String reviewReFile;
	
	public Review() {}
	
	public Review(int reviewNo, String userId, int bookingNo, String point, String reviewContent,
			String reviewOriginFile, String reviewReFile) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.bookingNo = bookingNo;
		this.point = point;
		this.reviewContent = reviewContent;
		this.reviewOriginFile = reviewOriginFile;
		this.reviewReFile = reviewReFile;
	}



	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewOriginFile() {
		return reviewOriginFile;
	}

	public void setReviewOriginFile(String reviewOriginFile) {
		this.reviewOriginFile = reviewOriginFile;
	}

	public String getReviewReFile() {
		return reviewReFile;
	}

	public void setReviewReFile(String reviewReFile) {
		this.reviewReFile = reviewReFile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return reviewNo + ", " + userId + ", " + bookingNo + ", " + point + ", " + reviewContent + ", "
				+ reviewOriginFile + ", " + reviewReFile;
	}
	
}
