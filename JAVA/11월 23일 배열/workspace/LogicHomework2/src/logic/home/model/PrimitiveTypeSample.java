package logic.home.model;
import java.lang.*;

public class PrimitiveTypeSample {
	public void typeSize() { //�⺻�ڷ��� �޸� �Ҵ�ũ�� Ȯ��
				
		System.out.println("�⺻ �ڷ��� �޸� �Ҵ�ũ���Դϴ�.");
		System.out.println();
		System.out.println("char : "+Character.BYTES);
		System.out.println("byte : "+Byte.BYTES);
		System.out.println("short : "+Short.BYTES);
		System.out.println("long : "+Long.BYTES);
		System.out.println("florst : "+Float.BYTES);
		System.out.println("double : "+Double.BYTES);		
	}
	
	public void minMaxValue() { //�⺻�ڷ��� ���� �ּҰ�, �ִ밪 ���
		
		System.out.println("�⺻�ڷ��� ���� �ּҰ�, �ִ밪�Դϴ�.");
		System.out.println();
		System.out.println("�ּҰ� : "+Character.MIN_VALUE +"�ִ밪 : "+Character.MAX_VALUE);
		System.out.println("�ּҰ� : "+Byte.MIN_VALUE +"�ִ밪 : "+Byte.MAX_VALUE);
		System.out.println("�ּҰ� : "+Short.MIN_VALUE +"�ִ밪 : "+Short.MAX_VALUE);
		System.out.println("�ּҰ� : "+Long.MIN_VALUE +"�ִ밪 : "+Long.MAX_VALUE);
		System.out.println("�ּҰ� : "+Float.MIN_VALUE +"�ִ밪 : "+Float.MAX_VALUE);
		System.out.println("�ּҰ� : "+Double.MIN_VALUE +"�ִ밪 : "+Double.MAX_VALUE);
	}
	public void bitSize() { //�⺻�ڷ��� ��Ʈ���� Ȯ��
		System.out.println();
		System.out.println(Byte.SIZE);
		System.out.println(Short.SIZE);
		System.out.println(Long.SIZE);
		System.out.println(Float.SIZE);
		System.out.println(Double.SIZE);
		
			
	}
	
}
