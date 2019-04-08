package faq.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import faq.model.dao.FaqDao;
import faq.model.vo.Faq;
import static common.JDBCTemplate.*;

//notice처럼 조회, 글선택, 글작성, 글삭제, 글수정, 페이징
public class FaqService {
	
	private FaqDao fdao = new FaqDao();
	
	public ArrayList<Faq> selectList(int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Faq> list = fdao.selectList(conn, currentPage, limit);
		close(conn);
		System.out.println(list);
		return list;
	}
	
	public int insertFaq(Faq faq) {
		Connection conn = getConnection();
		int result = fdao.insertFaq(conn, faq);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public int deleteFaq(int faqNo) {
		Connection conn = getConnection();
		int result = fdao.deleteFaq(conn, faqNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int updateFaq(Faq faq) {
		Connection conn = getConnection();
		int result = fdao.updateFaq(conn, faq);
		System.out.println(result);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	public ArrayList<Faq> faqSearchTitle(String title, int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Faq> list = fdao.selectTitleList(conn, title, currentPage, limit);
		close(conn);
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = fdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public Faq selectFaq(int faqNum) {
		Connection conn =getConnection();
		Faq faq = fdao.selectFaq(conn, faqNum);
		close(conn);
		return faq;
	}
	
	
}
