package test.model.vo;

public class User implements java.io.Serializable{
	private final static long serialVersionUID = 1111L;
	
	private int no;
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private String email;
	private String phone;
	
	public User() {}

	public User(int no, String userId, String userPwd, String userName, int age, String email, String phone) {
		super();
		this.no = no;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	
	public User(String userId, String userPwd, String userName, int age, String email, String phone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
		return no + ", " + userId + ", " + userPwd + ", " + userName + ", " + age + ", " + email + ", " + phone;
	}
	
	
	
}
