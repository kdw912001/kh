package io.silsub3;


import replay.BookManager;

public class TestBookManager {
	public static void main(String[]args) {
		BookManager bm = new BookManager();
		bm.fileSave();
		bm.fileRead();
	}
}
