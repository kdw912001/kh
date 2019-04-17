package org.kh.first.member.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Member implements java.io.Serializable{
	private static final long serialVersionUID = 11111L;
	
	//테이블의 컬럼명과 똑같이 필드명 지정함->getter setter 만들 필요없고, resultMap 만들 필요 없어짐
	private String userid;
	private String userpwd;
	private String username;
	private String gender;
	private int age;
	private String phone;
	private String email;
	private String hobby;
	private String etc;
	private Date enroll_date;
	private Date lastmodified;
	
	public Member() {}

	public Member(String userid, String userpwd, String username, String gender, int age, String phone, String email,
			String hobby, String etc, Date enroll_date, Date lastmodified) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.hobby = hobby;
		this.etc = etc;
		this.enroll_date = enroll_date;
		this.lastmodified = lastmodified;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return userid + ", " + userpwd + ", " + username + ", " + gender + ", " + age + ", " + phone + ", " + email
				+ ", " + hobby + ", " + etc + ", " + enroll_date + ", " + lastmodified;
	}

	
	
	
}
