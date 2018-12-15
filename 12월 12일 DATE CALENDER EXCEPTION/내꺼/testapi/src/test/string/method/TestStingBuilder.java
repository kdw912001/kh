package test.string.method;

public class TestStingBuilder {

	public static void main(String[] args) {
		// mutable : ��ϵ� ���ڿ��� ���氡��
		// StringBuffer : ������ safe ��� ����
		// String Builder : ������ safe ��� ����
		StringBuilder sb = new StringBuilder();//java.lang ��Ű�� �̱� ������ import�� �ʿ� ����
		
		System.out.println("����뷮 : " + sb.capacity()+" ����");
		System.out.println("sb : "+sb.hashCode());
		
		StringBuilder sb2 = sb.append("java");
		sb2 = sb.append(8.5);
		sb2 = sb.append(' ');
		sb2 = sb.append(true);
		sb2 = sb.append(10);
		
		System.out.println("sb2 : "+sb2.hashCode()); //sb�� sb2 ���� �ּ�
		
		System.out.println("���ڰ��� : "+sb.length());
		System.out.println("sb : "+sb);
		sb.delete(2, 6);
		System.out.println("sb : "+sb);
		
		char[] dst = new char[5];
		sb.getChars(0, 5, dst, 0);   
		for(int i=0; i<dst.length;i++) {
			System.out.print(dst[i]+"-");
		}
		System.out.println();
		
		sb.insert(3, "oracle"); //3�� �ε����� "oracle"�߰�
		System.out.println("sb : "+sb);
		sb.reverse();//���ڰ� ��������
		System.out.println("sb : "+sb);
		
		sb.setCharAt(7, 'A'); //7�� �ε����� 'A'�� set��.
		System.out.println("sb : "+sb);
		
		//sb ---> String  
		//StringBuilder�� String���� �ٲٴ� 2���� ����� ����
		String ss = sb.toString(); //toString
		String ss2 = new String(sb); //���ο� ��ü ����
		System.out.println("ss : "+ss.toUpperCase());
	}

}
