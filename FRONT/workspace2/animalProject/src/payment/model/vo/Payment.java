package payment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Payment implements Serializable {
	private static final long serialVersionUID = -9136359375880192792L;
	
	private int bookingNo;
	private Date paymentDate;
	private String paymentMethod;
	private String paymentYn;
	
	public Payment () {}

	public Payment(int bookingNo, Date paymentDate, String paymentMethod, String paymentYn) {
		super();
		this.bookingNo = bookingNo;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.paymentYn = paymentYn;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentYn() {
		return paymentYn;
	}

	public void setPaymentYn(String paymentYn) {
		this.paymentYn = paymentYn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString () {
		return
				this.bookingNo + ", " + this.paymentDate + ", " + this.paymentMethod + ", " + this.paymentYn;
	}

}
