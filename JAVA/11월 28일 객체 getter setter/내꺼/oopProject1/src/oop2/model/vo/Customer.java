package oop2.model.vo;

public class Customer {
	//������� : Field
	//�ڷ����� �ٸ� �������� ���� ���� : ����ü
	//����ü + ���ȱ�� : Ŭ���� => ĸ��ȭ
	//�ʵ带 ĸ��ȭ : private ���������� ���
	//private : Ŭ���� �ȿ����� ��밡��
	
	//���������� [�����] �ڷ��� ������[ = �ʱⰪ];
	private int id;//�� ���̵�
	private String name;//�� �̸�
	private int age;//�� ����
	private char gender;//�� ����
	private String phone;//�� ��ȭ��ȣ
	private String address;//�� �ּ�
	private double point;//�� ��������Ʈ
	
	//������ : Constructor
	//new �� �� ����Ǵ� �ʱ�ȭ �޼ҵ���.
	//new �� �� �ش� Ŭ���� ���� ��ü(�ν��Ͻ�)
	//�� ��(heap : �����޸� ����)�� ������� ��
	//��ü �ȿ� �Ҵ�Ǵ� �ʵ���� �ʱⰪ ó�� ���
	//api Deprecated->���� ��� ����.
	//�Ű������� �ٸ��� ���� ��->�����ε� ����
	
	//���������� Ŭ������(){ �ʵ� = �ʱⰪ; }
	//���������� Ŭ������(�ڷ��� ������){}
	//�����ڴ� �����ε�(overloading) ������
	
	//�����ε� :  �� Ŭ���� �ȿ� �̸��� ���� 
	//�����ڳ� �޼ҵ带 ���� �� �ߺ� �ۼ��ϴ� ��
	//1. �̸��� �ݵ�� ���ƾ� ��
	//2. �Ű������� �޶�� ��

	//�����ڴ� �Ϲ������� public �����
	//public(����) : Ŭ���� ��/��, ��Ű�� ��/��
	//			��𼭳� ��� ���ٰ�����
	
	//�⺻(default) �����ڶ�� ��
	public Customer() {
		//�����ڿ� �޼ҵ� �ȿ���
		//this ���۷����� ������
		//�ش� �����ڳ� �޼ҵ尡 ���� ��
		//this�� �ڵ����� �ּҸ� ���޹���
		//System.out.println("this : " + this.hashCode());
		//���� Ŭ�������� ���ο� ��ü �����ϸ鼭 ���� �ּҰ� = this�� ���� �ּ� ��
		//����Ŭ�������� cm = new Customer();���� ������� �ּ� cm.hashCode()= CustomerŬ������ this.hashCode()
	}
	
	//�Ű����� �ִ� �����ڶ�� ��
	public Customer(int id, String name) {
		//System.out.println("this : " + this.hashCode());
		
		this.id = id; //�� this.id�� heap�޸𸮿� �ִ��ּ� ��ġ,
						//�� id�� stack�� ���������� ����Ǿ� �ִ� ��
		this.name = name;
		
		
	}
	
	public Customer(int id, String name, int age, 
			char gender, String phone, String address, double point) {
		//System.out.println("this : " + this.hashCode());
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.point = point;
	}
	
	//����Լ� : Method (���)
	//���������� ��ȯ�ڷ��� �޼ҵ��([�ڷ��� ����]){}
	
	public void printCustomer() {
		//System.out.println("printCustomer() run...");
		//System.out.println("this : "+this.hashCode());

		System.out.println(this.id + ", "+this.name+", "+this.age+", "+this.gender+", "+
							this.phone+", "+this.address+", "+this.point);
		//this�� �� ���̴��� JVM���� �ڵ����� this�� ����.
	}
	
	//Setter : set �޼ҵ�
	//public void set�ʵ��(�ڷ��� ����){ �ʵ�� = ����; }
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPoint(double point) {
		this.point = point;
	}
	
	//Getter : get �޼ҵ�
	public int getId() {
		return this.id; //this ��������
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public char getGender() {
		return this.gender;
	}
	public String getPhone() {
		return this.phone;
	}
	public String getAddress() {
		return this.address;
	}
	public double getPoint() {
		return this.point;
	}
}