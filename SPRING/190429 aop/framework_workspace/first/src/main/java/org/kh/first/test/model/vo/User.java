package org.kh.first.test.model.vo;

import org.springframework.stereotype.Component;

@Component
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 8888L;
	
	private String userid;
	private String userpwd;
	private String username;
	private int age;
	private String email;
	private String phone;
	
	public User() {}

	public User(String userid, String userpwd, String username, int age, String email, String phone) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.age = age;
		this.email = email;
		this.phone = phone;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", age=" + age
				+ ", email=" + email + ", phone=" + phone + "]";
	}	

}
