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
	<h3>사원정보 리스트</h3>
	<form method="get">
		사번 : <input name="employeeId"><br>
		부서 : <input type="checkbox" name="depts" value="10">10
		      <input type="checkbox" name="depts" value="20">20
		      <input type="checkbox" name="depts" value="30">30<br>
		직무 : <select name="jobId">
				  <option value="">선택
				  <option value="MK_REP">MK_REP
				  <option value="IT_PROG">IT_PROG
				  <option value="SA_MAN">SA_MAN
				  <option value="AD_PRES">AD_PRES
			  </select><br>
		입사일자 : <input type="date" name="sdt">~<input type="date" name="edt"><br>
		<button>검색</button>
	</form>
	<hr>
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
					<td><a href="empUpdate/${emp.employeeId}">${emp.employeeId}</a></td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>