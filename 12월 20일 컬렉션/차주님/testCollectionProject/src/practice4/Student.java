package practice4;

public class Student 
	implements java.io.Serializable{
	//Field
	private int sno;
	private String sname;
	private int kor, eng, mat, tot, avg;
	
	//생성자, getter, setter, toString() 오버라이딩 처리
	public Student(){}

	public Student(int sno, String sname, int kor, int eng, int mat, int tot, int avg) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avg = avg;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString(){
		return sno + ", " + sname + ", " + kor + ", " + eng + ", " + mat
				+ ", " + tot + ", " + avg;
	}
}
