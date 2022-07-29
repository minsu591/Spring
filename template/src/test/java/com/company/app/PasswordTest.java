package com.company.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
	@Test
	public void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		//괄호 안은 stress, 값이 클 수록 시간이 더 지연됨
		String result = encoder.encode("1111");
		System.out.println(result);
		//암호화된 것끼리 비교하고 싶을 때
		//(로그인 페이지에서 넘어오는 패스워드, db의 값)
		assertTrue(encoder.matches("1111", result));
	}
}
