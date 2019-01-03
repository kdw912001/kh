package com.practice1.controller;

import com.practice1.model.vo.*;

public class Run {

	public static void main(String[] args) {
		MyInfo[] mi = new MyInfo[6];
		
		mi[0]=new Stuff("홍길동",19,"세이코","갤럭시노트2",4);
		mi[1]=new Stuff("유관신",20,"롤렉스","아이폰7",3);
		mi[2]=new Stuff("이순선",22,"다이브","갤럭시8",5);
		mi[3]=new Favorite("장발장",25,"하이킹",3,"사과");
		mi[4]=new Favorite("임걱중",27,"음악감상",7,"딸기");
		mi[5]=new Favorite("김유산",29,"게임하기",10,"수박");
		
		memberInform(mi);
	
	}
	
	public static void memberInform(MyInfo[] mi) {
		for(int i=0; i<mi.length;i++) {
			if(i==0) {
				System.out.println("-------------소유물----------");
			}
			if(i==3) {
				System.out.println("----------------취향-------------");
			}
			System.out.println(mi[i].toString());
		}
	}

}
