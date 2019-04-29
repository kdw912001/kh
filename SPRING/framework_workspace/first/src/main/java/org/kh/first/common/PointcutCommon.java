package org.kh.first.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	//Pointcut만 따로 모아서 설정할 수도 있음
	
	@Pointcut("execution(* org.kh.first..service.*Impl.*(..))")
	public void serviceAllPointcut() {}
	
	@Pointcut("execution(* org.kh.first..service.*Impl.select*(..))")//service 패키지 밑에 있는 select글자로 시작하는 메소드들만
	public void getPointcut() {}
	
	@Pointcut("execution(* org.kh.first..service.*Impl.insert*(..))")//service패키지 밑에 있는 insert글자로 시작하는 메소드들만
	public void setPointcut() {}
}
