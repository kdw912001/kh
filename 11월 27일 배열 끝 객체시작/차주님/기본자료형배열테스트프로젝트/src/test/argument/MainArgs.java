package test.argument;

public class MainArgs {

	public static void main(String[] args) {
		// 프로그램 실행시 main() 메소드로
		//값을 전달할 수 있음
		System.out.println("전달받은 값의 갯수 : " 
				+ args.length);
		
		for(int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] : "
					+ args[i]);
		}
		
		int num = Integer.parseInt(args[0]);
		double dnum = Double.parseDouble(args[1]);
		char level = args[2].charAt(0);
		
		//int result = args[0] * 3;
		
		System.out.println("num : " + (num * 3));
		System.out.println("dnum : " + dnum);
		System.out.println("level : " + level);

	}

}
