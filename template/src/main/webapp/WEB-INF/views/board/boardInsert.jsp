<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 등록</h3>
	<form action="boardInsert" method="post">
		제목 : <input name="title"><br>
		작성자 : <input name="writer"><br>
		내용 : <textarea name="content" rows="5"	cols="33"></textarea>
		<br>
		<button>등록</button>
		<input type="reset" value="취소">
	</form>
	<br>
	<button onclick="location.href='boardList'">목록으로</button>

</body>
</html>