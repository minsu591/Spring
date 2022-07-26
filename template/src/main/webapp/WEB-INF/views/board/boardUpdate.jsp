<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board Update</title>
</head>
<body>
	<h3>게시글 수정</h3>
	<form action="boardUpdate" method="post">
		게시글 번호 : <input type="text" name="bno" value="${board.bno}" readonly><br>
		제목 : <input type="text" name="title" value="${board.title}"><br>
		작성자 : <input type="text" name="writer" value="${board.writer}"><br>
		<textarea cols="50" rows="8" name="content">${board.content}</textarea>
		<br>
		<button>수정완료</button>
		<button type="reset">취소</button>
	</form>
	<button onclick="location.href='boardList'">목록으로</button>
</body>
</html>