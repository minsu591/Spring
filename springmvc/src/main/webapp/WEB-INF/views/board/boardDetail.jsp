<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail</title>
</head>
<body>
	<h3>게시글 상세보기</h3>
	<p>게시글 번호 : ${board.bno}</p>
	<p>제목 : ${board.title}</p>
	<p>작성자 : ${board.writer}</p>
	<p>작성 일자 : ${board.regdate}</p>
	<textarea cols="50" rows="8" readonly>${board.content}</textarea>
	<br>
	<button onclick="location.href='boardUpdate?bno='+${board.bno}">수정</button>
	<button onclick="location.href='boardDelete?bno='+${board.bno}">삭제</button>
	<br>
	<button onclick="location.href='boardList'">목록으로</button>
</body>
</html>