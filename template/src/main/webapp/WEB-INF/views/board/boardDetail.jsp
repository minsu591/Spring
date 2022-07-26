<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
</head>
<body>
	<script>
		$(function(){
			//실행 부분
			replyList();
			replyDelete();
			replyInsert();
			replyUpdate();
			
			function replyList(){
				$.ajax({
					url : "http://localhost/mvc/reply/"+${board.bno}
				}).done(function(objs){
					for(obj of objs){
						makeDiv(obj);
					}
				})
			}
			
			function replyInsert(){
				$("#btnReAdd").click(function(){
					$.ajax({
						url : "http://localhost/mvc/reply",
						method : "post",
						data : {
							bno : ${board.bno},
							reply : $("#reply").val(),
							replyer : $("#replyer").val()
						}
					}).done(function(result){
						makeDiv(result);
					}).fail(function(){
						console.log("댓글 등록 실패");
					})
				})
				
			}
			
			function makeDiv(obj){
				let div = $(`<div data-rno ="\${obj.rno}">
					<span class="reWriter">\${obj.replyer}</span>
					<span class="reContent">\${obj.reply}</span>
					<span class="reDate">\${obj.replydate}</span>
					<span class="btnReUpd"><button>수정</button></span>
					<span class="btnReDel"><button>삭제</button></span>
				</div>`)
				
				$("#replyList").append(div)
			}
			
			function replyDelete(){
				$("#replyList").on("click","div .btnReDel",function(){
					let div = $(this).parent();
					let rno = div.data("rno");
					$.ajax({
						url : "http://localhost/mvc/reply/"+rno,
						method : "delete"
					}).done(function(result){
						div.remove();
					})
				})
			}
			
			function replyUpdate(){
				$("#replyList").on("click","div .btnReUpd",function(){
					let div = $(this).parent();
					let rno = div.data("rno");
					let btn = div.children(".btnReUpd");
					let orgReply = div.children(".reContent").text();
					let orgReplyer = div.children(".reWriter").text();
					div.children(".reWriter").contents().unwrap().wrap("<input class='reWriter'>");
					div.children(".reWriter").val(orgReplyer);
					div.children(".reContent").contents().unwrap().wrap("<input class='reContent'>");
					div.children(".reContent").val(orgReply);
					
					btn.click(function(){
						let reply = btn.parent().children(".reContent").val();
						let replyer = btn.parent().children(".reWriter").val();
						$.ajax({
							url : "http://localhost/mvc/reply",
							method : "put",
							data : JSON.stringify({reply, replyer, rno}),
							contentType : "application/json"
						}).done(function(result){
							div.children(".reWriter").contents().unwrap().wrap("<span class='reWriter'>");
							div.children(".reWriter").text(result.replyer);
							div.children(".reContent").contents().unwrap().wrap("<span class='reContent'>");
							div.children(".reContent").text(result.reply);
						})
					
					})
					
				})
			}
		})
	</script>
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
	
	<hr>
	<h4>댓글 리스트</h4>
	<div id="replyList">
		<div data-rno ="1">
			<span class="reWriter">댓글 작성자</span>
			<span class="reContent">내용</span>
			<span class="reDate">작성 일시</span>
			<span class="btnReUpd"><button>수정</button></span>
			<span class="btnReDel"><button>삭제</button></span>
		</div>
	</div>
	<hr>
	<form>
		작성자 : <input name="replyer" id="replyer">
		내용 :<input name="reply" id="reply">
		<button type="button" id="btnReAdd">댓글 등록</button>
	</form>
	
</body>
</html>