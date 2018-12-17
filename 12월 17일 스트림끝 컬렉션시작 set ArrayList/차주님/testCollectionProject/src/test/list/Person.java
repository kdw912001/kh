package test.list;

//vo(Value Object) 
//== dto(Data Transfer Object)
//== bean == do(Domain Object)
//entity
public class Person 
	implements java.io.Serializable{
	public static final long serialVersionUID = 333L;
	
	private String name;
	private int age;
	private double point;
	
	public Person() {}

	public Person(String name, 
			int age, double point) {
		super();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + 
				this.age + ", " + 
				this.point;
	}
}







