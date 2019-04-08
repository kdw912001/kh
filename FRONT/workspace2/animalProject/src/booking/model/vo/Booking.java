package booking.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Booking implements Serializable {
	private static final long serialVersionUID = -1425532249012842120L;
	
	private int bookingNo;
	private Date checkInDate;
	private Date checkOutDate;
	private int petNo;
	private String userId;
	private String bookingProgress;
	private String bookingEtc;
	private String serviceKind;
	
	public Booking () {}

	public Booking(int bookingNo, Date checkInDate, Date checkOutDate, int petNo, String userId, String bookingProgress,
			String bookingEtc, String serviceKind) {
		super();
		this.bookingNo = bookingNo;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.petNo = petNo;
		this.userId = userId;
		this.bookingProgress = bookingProgress;
		this.bookingEtc = bookingEtc;
		this.serviceKind = serviceKind;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getPetNo() {
		return petNo;
	}

	public void setPetNo(int petNo) {
		this.petNo = petNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookingProgress() {
		return bookingProgress;
	}

	public void setBookingProgress(String bookingProgress) {
		this.bookingProgress = bookingProgress;
	}

	public String getBookingEtc() {
		return bookingEtc;
	}

	public void setBookingEtc(String bookingEtc) {
		this.bookingEtc = bookingEtc;
	}

	public String getServiceKind() {
		return serviceKind;
	}

	public void setServiceKind(String serviceKind) {
		this.serviceKind = serviceKind;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString () {
		return
				this.bookingNo + ", " + this.checkInDate + ", " + this.checkOutDate + ", " + this.petNo + ", "
			  + this.userId + ", " + this.bookingProgress + ", " + this.bookingEtc + ", " + this.serviceKind;
	}

}
