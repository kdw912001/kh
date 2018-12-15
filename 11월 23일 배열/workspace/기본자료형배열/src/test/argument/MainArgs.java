package test.argument;

public class MainArgs {

	public static void main(String[] args) {
		// 프로그램 실행시 main()메소드로
		// 값을 전달할 수 있음
		//Run Configurations
		//왼쪽에 자바 어플리케이션에 class없으면 더블클릭
		//argument에 값 값 값    입력 후 run
		//이렇게 하고 실행하면 args 배열 안에 입력한 값이 그대로 고정됨.
		
		//다른 방법 실행할 때마다 값 변경하고싶으면
		//Run Configurations->argument->variable->string_promt->run
		System.out.println("전달받은 갓의 갯수 : "+args.length);
		
		for(int i=0; i<args.length;i++) {
			System.out.println("args["+i+"]: "+args[i]);
		}
		int num = Integer.parseInt(args[0]);
		double dnum = Double.parseDouble(args[1]);
		char level = args[2].charAt(0);

	}

}
