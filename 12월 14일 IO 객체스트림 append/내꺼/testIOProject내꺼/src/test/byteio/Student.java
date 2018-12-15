package test.byteio;

	//��ü����¿� ���Ƿ���, �ݵ�� ����ȭó�� �ؾ���.
	//java.io.Serializable �������̽��� ��ӹ����� ��.
	//Serializable �������̽��� �߻�޼ҵ带 ������ �ִ� �ʴ� �������̽���.
	//->�������̵��� ���� �ʾƵ� ��.
	//��ũ��(markup) �������̽���.
public class Student implements java.io.Serializable{
	private static final long serialVersionUID = 3687787741274169068L;
	//Student�� ������ ���� �ذ�->���콺 �÷��� 2��° �ذ��
	//UID�� Ŭ������ �����ϴ� ID, �� ���ڴ� �ٸ� Ŭ������ ��ġ�� �� ��.
	//����ȭ ���� ������ȭ�� �ϴµ� ������ȭ�� �ϱ� ���� �ʿ��� ID��
	//�ڹٴ� �������� �����ӿ�ũ�� �̷��� ����� ������ �����ϰ� �Ѿ�� �� ��.
	
	private int no;
	private String name;
	private double score;
	private String major;
	
	public Student() {}

	public Student(int no, String name, double score, String major) {
		super();
		this.no = no;
		this.name = name;
		this.score = score;
		this.major = major;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return no + ", "+name+ ", "+score+ ", "+major;
	}
}
