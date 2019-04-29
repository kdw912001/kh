package org.kh.first.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	@Pointcut("execution(* org.kh.first..service..*Impl.*(..))")
	public void allServiceMethod() {}
	
	
	//함수 실행하면 함수 위에 있는 @Pointcut안에 있는 내용 실행, 예외객체명을 throwing 안에 입력
	@AfterThrowing(pointcut="allServiceMethod()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		//비즈니스 서비스 메소드 실행 도중에 예외가 발생했을 때
		//공통적인 예외 처리 로직을 제공할 목적으로 사용하는 어드바이스임.
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "() 메소드 수행 중 예외발생!");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다.");
		}else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다.");
		}else if(exceptObj instanceof Exception) {
			System.out.println(exceptObj.getMessage() + " 예외가 발생하였습니다.");
		}
	}
}
