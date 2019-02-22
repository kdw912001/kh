package user.model.biz;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.exceptions.UserException;
import user.model.vo.User;

public class UserBiz {
	public UserBiz(){}
	
	public User loginCheck(String uid, String upwd) throws UserException
	{
		User loginUser = null;
		String config = "mybatis/data/mybatis-config.xml";
		
		//파일 읽기용 객체
		Reader reader = null;
		//db connection 역할의 객체
		SqlSession session = null;
		
		try{
			//config 파일의 내용을 읽음
			reader = Resources.getResourceAsReader(config);
			
			//db 와 연결 처리함
			session = new SqlSessionFactoryBuilder()
							.build(reader).openSession();
			
			loginUser = (User)session.selectOne("selectID", new User(uid, upwd, null));
			
			if(loginUser == null)
				throw new UserException("로그인 조회 실패함");
		
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}		
		
		return loginUser;
	}
}
