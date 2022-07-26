<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${pageContext.request.contextPath}/board?name=choi&title=test
<!-- 만들어진 url을 변수로 넣을 수 있음 -->
<c:url value="/board" var="boardListUrl">
	<c:param name="name" value="choi"></c:param>
	<c:param name="title" value="test"></c:param>
</c:url>
<a href="${boardListUrl}">게시판</a>
<a href="<c:url value='boardList'/>">게시판</a>
</body>
</html>