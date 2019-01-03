package object.silsub3.controller;

import object.silsub3.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		/*1. 매개변수 있는 생성자를 사용해서 3개의 객체를 생성함
		2. 객체가 가진 필드값 출력확인
		<출력예>
		ssgnote6	  갤럭시노트6  경기도수원  960000  10.0
		lgxnote5	  LG스마트폰5  경기도평택  780000  0.7
		ktnorm3	  KT일반폰3   서울시강남  25000  0.3*/
		Product p1 = new Product("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
		Product p2 = new Product("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
		Product p3 = new Product("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);
		
		p1.information();
		p2.information();
		p3.information();
		
		/*1. 각 객체의 가격을 모두 120만원으로 변경함
		2. 각 객체의 부가세율도 모두 0.5로 수정함
		3. 결과 확인*/
		p1.setPrice(1200000);
		p2.setPrice(1200000);
		p3.setPrice(1200000);
		
		p1.setTex(0.5);
		p2.setTex(0.5);
		p3.setTex(0.5);
		
		System.out.println();
		p1.information();
		p2.information();
		p3.information();
		
		/*1. 부가세율을 모두 0.05로 수정함
		2. 각 객체의 가격에 부가세율을 적용한 실제 가격을 계산해서 출력함
		실제 가격 = 가격 + (가격 * 부가세율);

		<출력결과>
		상품명 : 갤럭시노트6
		부가세 포함 가격 : 1260000 원
		상품명 : LG스마트폰5
		부가세 포함 가격 : 1260000 원
		상품명 : KT일반폰3
		부가세 포함 가격 : 1260000 원*/
		p1.setTex(0.05);
		p2.setTex(0.05);
		p3.setTex(0.05);
		
		int realPrice1 = p1.getPrice() + (int)(p1.getPrice() * p1.getTex());
		int realPrice2 = p2.getPrice() + (int)(p2.getPrice() * p2.getTex());
		int realPrice3 = p3.getPrice() + (int)(p3.getPrice() * p3.getTex());
		
		System.out.println("\n상품명 : " + p1.getProductName());
		System.out.println("부가세 포함 가격 : " + realPrice1 + "원");		
		System.out.println("상품명 : " + p2.getProductName());
		System.out.println("부가세 포함 가격 : " + realPrice2 + "원");
		System.out.println("상품명 : " + p3.getProductName());
		System.out.println("부가세 포함 가격 : " + realPrice3 + "원");
	}

}
