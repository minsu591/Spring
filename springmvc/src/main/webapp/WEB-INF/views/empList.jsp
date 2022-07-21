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
	<script>
		
	</script>
	<h3>사원정보 리스트</h3>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.employee_id}</td>
					<td>${emp.first_name}</td>
					<td>${emp.last_name}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>