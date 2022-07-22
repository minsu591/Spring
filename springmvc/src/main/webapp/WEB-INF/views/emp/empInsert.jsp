<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
</head>
<body>
	<h4>사원 등록</h4>
	<form action="empInsert" method="post">
		<label>firstName : <input name="firstName" placeholder="firstName"></label><br>
		<label>lastName : <input name="lastName" placeholder="lastName"></label><br>
		<label>hireDate : <input type="date" name="hireDate" placeholder="hireDate"></label><br>
		<label>email : <input name="email" placeholder="email"></label><br>
		<label>JobId : <input name="jobId" placeholder="JobId"></label>
		<button>등록</button>
	</form>
</body>
</html>