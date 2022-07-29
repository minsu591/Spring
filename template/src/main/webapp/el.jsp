<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 내장객체</h3>
	<%
		request.setAttribute("name","리퀘스트");
		session.setAttribute("name","세션");
		application.setAttribute("name","어플리케이션");
		
		request.setAttribute("list", Arrays.asList("choi","park","kim"));
	%>
	<ul>
		<li>파라미터 읽기</li>
		<li><%= request.getParameter("id") %></li>
		<!-- el에서는 param으로 들어오는 파라미터에 접근 가능 -->
		<li>${param.id}</li>
		<li>${param["id"]}</li>
	</ul>
	
	<ul>
		<li>저장해둔 속성 읽기</li>
		<!-- 표현식 -->
		<li><%= request.getAttribute("name") %></li>
		<!-- el 장점 : null체크, 형변환 알아서 해줌 -->
		<!-- 이름만 적으면 됨. 그냥 쓰면 리퀘스트 -> 세션 -> 어플 순으로 찾음 -->
		<li>${name}</li>
		<!-- 바로 찾고 싶으면-->
		<li>${sessionScope.name}</li>
		<li>${applicationScope.name}</li>
	</ul>
	
	<ul>
		<li>Header 정보 읽기</li>
		<li><%= request.getHeader("User-Agent") %></li>
		<!-- 이름에 -가 들어가 .을 사용하지 못하면 배열처럼 출력 -->
		<li>${header["User-Agent"] }</li>
	</ul>
	
	<ul>
		<li>Cookies 정보 읽기</li>
		<li>${cookie.openYn.value}</li>
	</ul>
	
	<ul>
		<li>초기화 파라미터</li>
		<li><%=application.getInitParameter("contextConfigLocation") %></li>
		<li>${initParam.contextConfigLocation}</li>
	</ul>
	
	<ul>
		<li>EL 함수
		<li>리스트 크기 : ${fn:length(list)}
		<li>리스트 시작 : ${fn:startsWith(sessionScope.name,"세")}
	</ul>
	
	<ul>
		<li>escapeXml</li>
		<!-- escapeXml : true일 때 태그가 아니라 일반문자로 취급됨
			default가 true, 태그를 원하는대로 뿌려주고싶으면 false-->
		<li><c:out escapeXml = "true" value="<u>태그</u>"/></li>
		<li><c:out escapeXml = "false" value="<u>태그</u>"/></li>
	</ul>
	
</body>
</html>