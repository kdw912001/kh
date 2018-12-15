package oop.inherit.sample;

public class Member extends Person{
	//Field
	private double point;
	private String memberId;
	private String password;
	
	//Constructor
	public Member() {
		super();	//������ �ȿ����� �����
					//�ݵ�� ù �ٿ��� �����ؾ� ��.
		System.out.println("Member() run...");
	}

	public Member(double point, String memberId, String password) {
		super();
		this.point = point;
		this.memberId = memberId;
		this.password = password;
	}
	
	public Member(String name, int age, char gender, double point, 
			String memberId, String password) {
		
		super(name, age, gender);
		
		this.point=point;
		this.memberId=memberId;
		this.password=password;
	}
	
	//Getter and Setters
	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String information() {
		return super.information()+", "+this.memberId+", "+this.password+", "+this.point+" ����Ʈ";
	}
	
}
