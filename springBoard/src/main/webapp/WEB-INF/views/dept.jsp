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
	<ul>
		<c:forEach var="d" items="${dept}">
			<li>${d.department_id}</li>
			<li>${d.department_name}</li>
			<li>${d.manager_id}</li>
			<li>${d.location_id}</li>
		</c:forEach>
		
	</ul>
</body>
</html>