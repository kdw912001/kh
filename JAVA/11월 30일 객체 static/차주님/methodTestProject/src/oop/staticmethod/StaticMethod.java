package oop.staticmethod;

public class StaticMethod {
	//Field
	private static String value = "test";
	
	//Constructor  : 
	//�ʵ尡 ��� static �� ���� ������ �ʿ����
	/*public StaticMethod(){}
	
	public StaticMethod(String v){
		value = v;
	}*/
	
	//value �ʵ� �� ����� : 
	//�ʵ尡 static�̸� setter �� static �̾�� ��
	public static void setValue(String v) {
		value = v;
	} 
	
	//value �ʵ� �� ��ȸ�� : 
	//�ʵ尡 static �̸� getter �� static �̾�� ��
	public static String getValue() {
		return value;
	}
	
	//�ʵ尡 ��� static �� ���� �޼ҵ嵵 ���� static �̾�� ��
	//static method
	//1. ��ȯ�� ���� �Ű����� ���� �޼ҵ�
	//value �ʵ� ���� ��� �빮�ڷ� �ٲٴ� static �޼ҵ�
	//�޼ҵ�� : toUpper
	public static void toUpper() {
		//value.toUpperCase();
		char[] carr = value.toCharArray();
		
		for(int i = 0; i < carr.length; i++) {
			if(carr[i] >= 97 
					&& carr[i] <= 122) {
				//�ҹ����̸� �빮�ڷ� �ٲ�
				carr[i] -= 32;
			}
		}
		
		value = String.valueOf(carr);
	}
	
	//2. ��ȯ�� ���� �Ű����� �ִ� �޼ҵ�
	//�ε����� ���ڸ� ���޹޾�
	//value �ʵ忡�� ���޹��� �ε��� ��ġ�� ����
	//���޹��� ���ڷ� �����ϴ� static �޼ҵ�
	//�޼ҵ�� : setChar
	public static void setChar(int index, 
			char ch) {
		char[] carr = value.toCharArray();
		carr[index] = ch;
		value = String.valueOf(carr);
	}
	

	//3. ��ȯ�� �ְ� �Ű����� ���� static �޼ҵ�
	//value �ʵ忡 ��ϵ� ���ڰ��� ���� ó��
	//�޼ҵ�� : valueLength
	public static int valueLength() {
		//return value.length();
		return value.toCharArray().length;
	}
	
	//4. ��ȯ�� �ְ� �Ű����� �ִ� static �޼ҵ�
	//���ڿ����� ���޹޾�, value �ʵ尪�� �ϳ��� ���ļ� ���� ó��
	//�޼ҵ�� : valueConcat
	public static String valueConcat(String s) {
		return value + s;
	}

}






