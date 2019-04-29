package org.kh.first.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* org.kh.first..service..*Impl.*(..))")
	public void allPointcut() {}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pp) 
			throws Throwable {
		//사전, 사후 처리를 모두 해결하고자 할 때 사용하는
		//어드바이스임.
		String methodName = pp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();  //메소드가 실행되기 전(before)
		
		Object obj = pp.proceed();  //메소드가 구동됨
		//구동이 끝나면 객체가 리턴됨
		
		stopWatch.stop();  
		
		//메소드 실행이 끝나면(after)
		System.out.println(methodName + 
				"() 메소드 수행에 걸린 시간 : " + 
				stopWatch.getTotalTimeMillis() + "(ms)초");
		
		return obj;
	}
}






