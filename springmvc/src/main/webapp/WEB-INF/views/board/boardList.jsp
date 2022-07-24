<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 목록</h3>
	<br>
	<button onclick="location.href='boardInsert'">게시글 등록</button>
	<table border="1">
		<tr>
			<th>BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th>UPDATEDATE</th>
		</tr>
		<c:forEach var = "board" items="${boards}" >
		<tr onclick='detail(${board.bno})'>
			<td >${board.bno}</td>
			<td>${board.title}</td>
			<td>${board.writer}</td>
			<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
			<td><fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
		</tr>
	</c:forEach>
	</table>
	<script>
		function detail(bno){
			location.href='boardDetail?bno='+bno;
		}
	</script>
	
</body>
</html>