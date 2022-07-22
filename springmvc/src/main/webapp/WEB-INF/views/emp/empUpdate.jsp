<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empUpdate.jsp</title>
</head>
<body>
	<h4>사원 수정</h4>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<form action="${path}/empUpdate" method="post">
	<!-- action=" -->
		<label>employeeId : <input name="employeeId" value="${emp.employeeId}"readonly></label><br>
		<label>firstName : <input name="firstName" value="${emp.firstName}"></label><br>
		<label>lastName : <input name="lastName" value="${emp.lastName}"></label><br>
		<label>hireDate : <input type="date" name="hireDate"
						value='<fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/>'></label><br>
		<label>email : <input name="email" value="${emp.email}" placeholder="email"></label><br>
		<label>JobId : <input name="jobId" value="${emp.jobId}" placeholder="JobId"></label>
		<button>등록</button>
		<button type="button" id="btnDelete">삭제</button>
	</form>
	<script>
		btnDelete.addEventListener("click",function(){
			location.href="${path}/empDelete?employeeId=${emp.employeeId}";
		})
	</script>
</body>
</html>