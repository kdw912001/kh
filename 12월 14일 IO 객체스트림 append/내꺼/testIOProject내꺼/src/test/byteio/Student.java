package test.byteio;

	//객체입출력에 사용되려면, 반드시 직렬화처리 해야함.
	//java.io.Serializable 인터페이스를 상속받으면 됨.
	//Serializable 인터페이스는 추상메소드를 가지고 있는 않는 인터페이스임.
	//->오버라이딩을 하지 않아도 됨.
	//마크업(markup) 인터페이스임.
public class Student implements java.io.Serializable{
	private static final long serialVersionUID = 3687787741274169068L;
	//Student에 나오는 오류 해결->마우스 올려서 2번째 해결법
	//UID는 클래스를 구분하는 ID, 이 숫자는 다른 클래스와 겹치면 안 됨.
	//직렬화 이후 역직렬화를 하는데 역직렬화를 하기 위해 필요한 ID값
	//자바는 괜찮지만 프레임워크는 이러한 노란색 에러도 무시하고 넘어가면 안 됨.
	
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
