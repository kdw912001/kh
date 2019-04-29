package org.kh.first.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	//Pointcut 만 따로 모아서 설정할 수도 있음
	
	@Pointcut("execution(* org.kh.first..service.*Impl.*(..))")
	public void serviceAllPointcut() {}
	
	@Pointcut("execution(* org.kh.first..service.*Impl.select*(..))")
	public void getPointcut() {}
	
	@Pointcut("execution(* org.kh.first..service.*Impl.insert*(..))")
	public void setPointcut() {}
}











