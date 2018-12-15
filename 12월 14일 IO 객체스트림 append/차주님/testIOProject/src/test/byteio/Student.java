package test.byteio;

//객체입출력에 사용되려면, 반드시 직렬화처리 해야 함
//java.io.Serializable 인터페이스를 상속받으면 됨
//추상메소드를 가지고 있지 않는 인터페이스임.
//마크업(markup) 인터페이스임
public class Student 
	implements java.io.Serializable {
	private static final long serialVersionUID = 333L;

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
		return no + ", " + name + ", "
			+ score + ", " + major;
	}
	
}





