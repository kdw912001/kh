package oop.staticmethod;

public class StaticMethod {
	private static String value = "abc";
	
	public StaticMethod() {}
	
	public static void toUpper() {
		value = value.toUpperCase();
		System.out.println(value);
	}
	public static void setChar(int index, char ch) {
		System.out.println(value.replace(value.charAt(index), ch));
	}
	public static int valueLength() {
		return value.length();
	}
	public static String valueConcat(String str) {
		return str+value;
	}
}
