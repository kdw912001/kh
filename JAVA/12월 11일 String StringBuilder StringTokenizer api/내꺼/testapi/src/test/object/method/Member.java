package test.object.method;

public class Member {
	//Field
	private String name;
	private int age;
	private double point;
	
	//Constructor
	public Member() {
		super();//�⺻������ Object�� �⺻�����ڸ� ȣ��
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
		//return "Ŭ������@16�����ڵ�";//�����ڵ�
		return this.name+", "+this.age+"��, "+this.point+"��";
	}
	
	@Override
	public boolean equals(Object obj) {
		//return this == (Member)obj; //�����ڵ�
		Member other = (Member)obj;
		
		return (this.name.equals(other.name)&&this.age==other.age&&this.point==other.point);
	}
	
	@Override		//1.���������� �θ𲨺��� ������ protected���� ������->public
					//2.����ó�� ���ų� ���� �� �ִ�. 1���� 1�� Ȥ�� 0��
	public Object clone(){
		//return this; 	//�����ڵ� : ��������(�ּҸ� ����)
		//�ּҺ��� : ��������(shalow copy)
		
		//deep copy : ��������� �������̵�
		//new�� ���������Ƿ� ���� �Ȱ����� �ּҰ� �ٸ�
		return new Member(this.name, this.age, this.point);
	}
	
	
}
