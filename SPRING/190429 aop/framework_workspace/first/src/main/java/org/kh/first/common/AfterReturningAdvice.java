package org.kh.first.common;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.first.member.model.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository  //dao 에 적용하는
@Aspect     //aop 를 의미함
public class AfterReturningAdvice {
	//비즈니스 메소드가 리턴한 결과 데이터를 
	//다른 용도로 처리하고자 할 때 사용할 수 있음
	
	private static final Logger logger = 
			LoggerFactory.getLogger(
					AfterReturningAdvice.class);
	
	@Pointcut("execution(* org.kh.first.member.model.dao.MemberDao.selectLogin(..))")
	public void loginPointcut() {}
	
	@AfterReturning(pointcut="loginPointcut()", returning="returnObj")
	public void loginLog(JoinPoint jp, Object returnObj) {
		if(returnObj instanceof Member) {
			Member member = (Member)returnObj;
			logger.info(new Date() + " : " + 
					member.getUserid() + "님이 접속했습니다.");
		}
	}
}








