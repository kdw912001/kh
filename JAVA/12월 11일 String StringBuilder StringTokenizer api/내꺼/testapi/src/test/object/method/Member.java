package test.object.method;

public class Member {
	//Field
	private String name;
	private int age;
	private double point;
	
	//Constructor
	public Member() {
		super();//기본적으로 Object의 기본생성자를 호출
	}

	public Member(String name, int age, double point) {
		super();	//Object() call..
		this.name = name;
		this.age = age;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
	
	
	@Override
	public String toString() {
		//return "클래스명@16진수코드";//원래코드
		return this.name+", "+this.age+"세, "+this.point+"점";
	}
	
	@Override
	public boolean equals(Object obj) {
		//return this == (Member)obj; //원래코드
		Member other = (Member)obj;
		
		return (this.name.equals(other.name)&&this.age==other.age&&this.point==other.point);
	}
	
	@Override		//1.접근제한자 부모꺼보다 넓은거 protected보다 넓은거->public
					//2.예외처리 같거나 줄일 수 있다. 1개면 1개 혹은 0개
	public Object clone(){
		//return this; 	//원래코드 : 얕은복사(주소를 복사)
		//주소복사 : 얕은복사(shalow copy)
		
		//deep copy : 깊은복사로 오버라이딩
		//new로 선언했으므로 값은 똑같지만 주소가 다름
		return new Member(this.name, this.age, this.point);
	}
	
	
}
