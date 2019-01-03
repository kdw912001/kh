package com.practice2.model.entity;

public class Circle extends Point{
	private int radius;
	
	public Circle() {}
	public Circle(int x, int y, int radius) {
		/*super.x=x;
		super.y=y;*/
		super(x,y);		//부모의 매개변수 있는 생성자를 사용하려면 이런 식으로 작성
							//super는 반드시 첫 줄에 작성
							//첫 줄에 있는 이유 : 부모 먼저 실행 시키고 그 다음에 자손
							//실행시키도록 자바에서 정함.
		
		/*this.x=x;	//Point 클래스에 x,y가 
		 * this.y=y;*/  //protected로 선언 되어있기 떄문에 this로도 가능
		
		this.radius=radius;
	}
	
	@Override
	public void draw() {
		/*내가 한거
		 * System.out.println("원 면적 = "+(int)(Math.PI*100)/100.0+"X"+this.radius+"X"+this.radius+" = " + ((int)(((Math.PI*this.radius*this.radius)+0.05)*10)/10.0) );
		System.out.println("원 둘레 = " + ((int)(((2*Math.PI*this.radius)+0.05)*10)/10.0));
		*/
		double area = (int)(Math.PI*radius*radius*10)/10.0;
		double perimeter = (int)(2*Math.PI*radius*10) / 10.0;
		super.draw();	//부모 클래스가 갖고 있는 draw() 호출
		//this.draw(); 재귀호출
		
		/*System.out.printf("원 면적 = %.1f \n",area);
		System.out.printf("원 둘레 : %1.f\n", perimeter);*/
		System.out.println("원 면적 : "+area);
		System.out.println("원 둘레 : "+perimeter);
	}
}
