package model.dao;

import java.sql.*;
import static common.JDBCTemp.*;

//회원 정보 처리용 클래스
public class UserDao {
	public UserDao(){}
	
	public String loginCheck(String uid, String upwd){
		String uname = null;
		
		//db 연결 요청
		Connection conn = getConnection();
		
		//쿼리문 작성
		String query = "select username from users where userid = ? and userpwd = ?";
		
		//결과 받음
		
		return uname;
	}
}
