package com.practice1.controller;

import com.practice1.model.vo.*;

public class Run {

	public static void main(String[] args) {
		MyInfo[] mi = new MyInfo[6];
		
		mi[0]=new Stuff("ȫ�浿",19,"������","�����ó�Ʈ2",4);
		mi[1]=new Stuff("������",20,"�ѷ���","������7",3);
		mi[2]=new Stuff("�̼���",22,"���̺�","������8",5);
		mi[3]=new Favorite("�����",25,"����ŷ",3,"���");
		mi[4]=new Favorite("�Ӱ���",27,"���ǰ���",7,"����");
		mi[5]=new Favorite("������",29,"�����ϱ�",10,"����");
		
		memberInform(mi);
	
	}
	
	public static void memberInform(MyInfo[] mi) {
		for(int i=0; i<mi.length;i++) {
			if(i==0) {
				System.out.println("-------------������----------");
			}
			if(i==3) {
				System.out.println("----------------����-------------");
			}
			System.out.println(mi[i].toString());
		}
	}

}
