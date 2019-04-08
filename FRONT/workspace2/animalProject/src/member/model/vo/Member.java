package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	   private static final long serialVersionUID = -5224047403963087858L;

	   public Member() {}

	   private String userId;
	   private String userPwd;
	   private String email;
	   private String userName;
	   private String phone;
	   private String address;
	   private String job;
	   private String petSitter;
	   private int price;
	   private Date userDate;
	   private String userDelete;
	   
	   public Member(String userId, String userPwd, String email, String userName, String phone, String address,
	         String job, String petSitter, int price, Date userDate, String userDelete) {
	      super();
	      this.userId = userId;
	      this.userPwd = userPwd;
	      this.email = email;
	      this.userName = userName;
	      this.phone = phone;
	      this.address = address;
	      this.job = job;
	      this.petSitter = petSitter;
	      this.price = price;
	      this.userDate = userDate;
	      this.userDelete = userDelete;
	   }
	   public String getUserDelete() {
		   return userDelete;
	   }
	   public void setUserDelete(String userDelete) {
		   this.userDelete = userDelete;
	   }

	   public String getUserId() {
	      return userId;
	   }

	   public void setUserId(String userId) {
	      this.userId = userId;
	   }

	   public String getUserPwd() {
	      return userPwd;
	   }

	   public void setUserPwd(String userPwd) {
	      this.userPwd = userPwd;
	   }

	   public String getEmail() {
	      return email;
	   }

	   public void setEmail(String email) {
	      this.email = email;
	   }

	   public String getUserName() {
	      return userName;
	   }

	   public void setUserName(String userName) {
	      this.userName = userName;
	   }

	   public String getPhone() {
	      return phone;
	   }

	   public void setPhone(String phone) {
	      this.phone = phone;
	   }

	   public String getAddress() {
	      return address;
	   }

	   public void setAddress(String address) {
	      this.address = address;
	   }

	   public String getJob() {
	      return job;
	   }

	   public void setJob(String job) {
	      this.job = job;
	   }

	   public String getPetSitter() {
	      return petSitter;
	   }

	   public void setPetSitter(String petSitter) {
	      this.petSitter = petSitter;
	   }

	   public int getPrice() {
	      return price;
	   }

	   public void setPrice(int price) {
	      this.price = price;
	   }

	   public Date getUserDate() {
	      return userDate;
	   }

	   public void setUserDate(Date userDate) {
	      this.userDate = userDate;
	   }

	   @Override
	   public String toString() {
	      return "Member [userId=" + userId + ", userPwd=" + userPwd + ", email=" + email + ", userName=" + userName
	            + ", phone=" + phone + ", address=" + address + ", job=" + job + ", petSitter=" + petSitter + ", price="
	            + price + ", userDate=" + userDate + ", userDelete=" + userDelete + "]";
	   }
	   
	}
