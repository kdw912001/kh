package org.kh.first.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	//로그 출력용 메소드를 사용해서 aop 테스트해 봄
	//어드바이스 클래스 안에서 포인트컷 설정을 직정 작성하고,
	//위빙할 메소드에 바로 적용한 경우로 해 봄
	//Aspect = Advice + pointcut
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//포인트컷 설정시 정규표현식 또는 AspectJ 문법 사용
	//어드바이스가 위빙되는 시점을 설정함
	@Pointcut("execution(* org.kh.first..*.*(..))")
	public void allPointcut() {}
	
	//어드바이스로 사용될 메소드 작성함
	//모든 메소드가 실행되기 전에 구동될 로그 출력용 메소드 작성
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		//포인트컷으로 지정된 대상 메소드가 실행되기 전에 
		//공통으로 작동될 메소드가 됨.
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		logger.info("[메소드 호출전 확인] : " + methodName
				+ "() 전달되는 매개변수 갯수 : " + 
				args.length);
		
		for(int i = 0; i < args.length; i++) {
			logger.info(i + "번째 매개변수 정보 : " + 
					args[i].toString());
		}
	}
	
	
}







