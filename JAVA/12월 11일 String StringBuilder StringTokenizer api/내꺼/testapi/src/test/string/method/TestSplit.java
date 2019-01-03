package test.string.method;

public class TestSplit {

	public static void main(String[] args) {
		// �ϳ��� ���ڿ��� ��ū���ڸ� �������� 
		// ���� ���� ���ڿ��� �и��ϴ� ��
		String s = "red yellow green blue purple";
		String[] sar = s.split(" "); //split ��ȯ���� String[]�迭
		System.out.println("�и��� ���ڿ� ���� : "+sar.length);
		
		//��ü�迭�� �÷����� for each�� ����� �� ����
		/* for(Ŭ������ ���۷��� ���� : �迭��){
		 * 			���۷�������.�޼ҵ�();
		 * }
		 */
		for(String ref : sar) {
			System.out.println(ref); //�ϳ��� ���
		}
		
		System.out.println("-----------");
		String s2 = "java,oracle,jdbc";
		String[] sar2 = s2.split(",");
		for(String sref : sar2) {
			System.out.println(sref);
		}
		
		System.out.println("------------");
		String s3 = "html5 css3,javascript&jquery#web";
		String[] sar3 = s3.split(" |,|&|#"); //��Ʈor ������ | �� ����
	  
		for(String sref2 : sar3) {
			System.out.println(sref2);
		}
		
		//java.lang.StringTokenizer �� ���� ����ϴٰ� since JDK1.0
		//String Ŭ������ split ����� since JDK1.4
		//token : �и��� ���ڿ� �� ����
		

	}

}
