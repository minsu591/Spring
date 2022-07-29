package com.company.app.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomerLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//로그인 하는 사람의 role에 따라서 로그인 페이지를 다르게 하기
		
		List<String> list = new ArrayList<>();
		authentication.getAuthorities().forEach(auth -> list.add(auth.getAuthority()));
		
		if(list.contains("ROLE_ADMIN")) {
			response.sendRedirect(request.getContextPath()+"/admin/admin.jsp");
			return;
		}else if(list.contains("ROLE_USER")) {
			response.sendRedirect(request.getContextPath()+"/user/user.jsp");
			return;
		}
		response.sendRedirect("/");
	}

}
