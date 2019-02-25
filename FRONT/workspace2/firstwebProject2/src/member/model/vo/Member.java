package member.model.vo;

import java.sql.Date;

//do(domain object) : 데이터베이스 테이블 한 행의 컬럼별
//값들을 저장할 목적의 클래스
//dto(data transfer object : 값 이동 객체) == vo(value object)
//bean == entity

//1. 반드시 직렬화화 할 것
//2. 필드는 모두 private 이어야 함
//3. 반드시 기본생성자와 매개변수 있는 생성자 있어야 함
//4. 반드시 getter setter 만들어야 함.
public class Member implements java.io.Serializable{
	private static final long serialVersionUID = 1111L;
	
	public Member() {}
	
	private String userId;
	private String userPwd;
	private String userName;
	private String gender;
	private int age;
	private String phone;
	private String email;
	private String hobby;
	private String etc;
	private Date enroll_date;
	private Date lastmodified;	
	
	
	
	public Member(String userId, String userPwd, String userName, String gender, int age, String phone, String email,
			String hobby, String etc, Date enroll_date, Date lastmodified) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.hobby = hobby;
		this.etc = etc;
		this.enroll_date = enroll_date;
		this.lastmodified = lastmodified;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return userId + ", " + userPwd + ", " + userName + ", " + gender + ", " + age + ", " + phone + ", " + email
				+ ", " + hobby + ", " + etc + ", " + enroll_date + ", " + lastmodified;
	}
		
	
}
