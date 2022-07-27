package com.company.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {

	// 포인트컷은 다시 만들 필요없이, 해당 클래스명 아래의 포인트컷을 가져와서 사용할 수 있음
	// 한 클래스 내에 포인트 컷을 모아두기도 함.
	// return 값을 받아오기 위한 AfterReturning
	// 그냥 After만 설정할 수도 있음
	@AfterReturning(pointcut = "LogAdvice.allpointcut()", returning = "ret")
	public void afterLog(JoinPoint jp, Object ret) {

		System.out.println("[after] 로그 출력");
		System.out.println(ret);
	}
}
