package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* com.company.app..*Impl.*(..))")
		//포인트컷 아이디값에 해당하는 메소드 만들기
	public void allpointcut() {}
	
	//메서드 이름을 넣어주기
	@Before("allpointcut()")
	public void printLog(JoinPoint jp) {
		//이 메서드가 실행되는 원인이 되는 pointcut
		String name = jp.getSignature().getName(); //메서드명
		String args = jp.getArgs() != null && jp.getArgs().length > 0 ? jp.getArgs()[0].toString() : "";
		System.out.printf("[before] 로그 출력 name = %s, args = %s",name, args);
		
	}
}
