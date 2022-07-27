package com.company.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AroundAdvice {


	@Around("LogAdvice.allpointcut()")
	public Object printLog(ProceedingJoinPoint pjp) {
		Object ret = null;
		try {
			// 서비스 실행전
			long start = System.currentTimeMillis();
			// 서비스 호출
			// 실제 실행해야할 서비스 메소드 호출
			ret = pjp.proceed();
			// 서비스 실행후
			long end = System.currentTimeMillis();
			System.out.println("경과시간 : " + (end - start));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return ret;
	}
}
