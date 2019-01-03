package test.string.method;

public class TestStringBuilder {

	public static void main(String[] args) {
		// mutable : ��ϵ� ���ڿ��� ���氡��
		//StringBuffer : ������ safe ��� ����
		//StringBuilder : ������ safe ��� ����
		StringBuilder sb = new StringBuilder();
		
		System.out.println("����뷮 : " + 
				sb.capacity() + "����");
		System.out.println("sb : " + 
				sb.hashCode());
		
		StringBuilder sb2 = sb.append("java");
		sb2 = sb.append(8.5);
		sb.append(' ');
		sb.append(true);
		sb2 = sb.append(10);
		
		System.out.println("sb2 : " + 
				sb2.hashCode());
		
		System.out.println("���ڰ��� : "
				+ sb.length());
		
		System.out.println("sb : " + sb);
		sb.delete(2, 6);
		System.out.println("sb : " + sb);
		
		char[] dst = new char[5];
		sb.getChars(0, 5, dst, 0);
		for(int i = 0; i < dst.length; i++)
			System.out.print(dst[i] + "-");
		System.out.println();
		
		sb.insert(3, "oracle");
		System.out.println("sb : " + sb);
		sb.reverse();
		System.out.println("sb : " + sb);
		
		sb.setCharAt(7, 'A');
		System.out.println("sb : " + sb);
		
		//sb ---> String 
		String ss = sb.toString();
		String ss2 = new String(sb);
		System.out.println("ss : " + ss.toUpperCase());
	}

}





