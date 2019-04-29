package org.kh.first.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service  //Service 에 적용하는
@Aspect  //AOP 를 의미함
public class AfterAdvice {
	//Advice + Pointcut => Aspect
	
	@Pointcut("execution(* org.kh.first..*Impl.*(..))")
	public void allPointcut() {}
	
	@After("allPointcut()")
	public void finallyLog() {
		//예외 발생 여부에 상관없이 무조건 수행되는 어드바이스임.
		System.out.println("[후실행] : 비즈니스 로직 수행 후 무조건 작동!");
	}
}










