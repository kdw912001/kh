package member.model.dto;

public class Member {
	private String id;
	private String name;
	private String password;
	private String email;
	private char gender;
	private int age;
	
	public Member() {}
	public Member(String id, String name, String password,
			String email, char gender, int age) {
		this.id=id;
		this.name=name;
		this.password=password;
		this.email=email;
		this.gender=gender;
		this.age=age;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return this.password;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEamil() {
		return this.email;
	}
	public void setGender(char gender) {
		this.gender=gender;
	}
	public char getGender() {
		return this.gender;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return this.age;
	}
	
	public String memberInfo() {
		return this.id+" "+this.name+" "+this.password+" "+
				this.email+" "+this.gender+" "+this.age;
	}
}
