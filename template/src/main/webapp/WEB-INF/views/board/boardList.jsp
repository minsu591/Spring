<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
	rel="stylesheet" />
</head>
<body>
	<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script>
		$(function(){
			$('[name="type"]').val('${cri.type}');
			
			//수정, 삭제 메세지 출력
			var result1 = '${result1}';
			var result2 = '${param.result2}';
			
			if(result1 != ''){
				const myModal = new bootstrap.Modal('#staticBackdrop',{});
				const modal2 = $("#staticBackdrop");
				$("#msg").val(result1);
				myModal.show(modal2);
			}
			
		})
		
		function detail(bno){
				location.href='boardDetail?bno='+bno;
		}
		
		function goPage(num){
			searchFrm.pageNum.value=num; //$("[name='pageNum']").val(num)
			searchFrm.submit();
		}
	</script>
	<h3>게시글 목록</h3>
	<br>
	<div class="card">
		<div class="card-header">
			<form name="searchFrm">
				<input type="hidden" name="pageNum" value="1"> <select
					name="type">
					<option value="title"
						<c:if test="${cri.type=='title'}">selected</c:if>>제목</option>
					<option value="content"
						<c:if test="${cri.type=='content'}">selected</c:if>>내용</option>
					<option value="writer"
						<c:if test="${cri.type=='writer'}">selected</c:if>>작성자</option>
				</select> <input name="keyword" value="${cri.keyword}">
				<button>검색</button>
			</form>
		</div>
		<div class="card-body">
			<table border="1" id="myTable"
				class="table table-striped table-hover">
				<thead>
					<tr>
						<th>BNO</th>
						<th>TITLE</th>
						<th>WRITER</th>
						<th>REGDATE</th>
						<th>UPDATEDATE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boards}">
						<tr onclick='detail(${board.bno})'>
							<td>${board.bno}</td>
							<td>${board.title}</td>
							<td>${board.writer}</td>
							<td><fmt:formatDate value="${board.regdate}"
									pattern="yyyy-MM-dd hh:mm:ss" /></td>
							<td><fmt:formatDate value="${board.updatedate}"
									pattern="yyyy-MM-dd hh:mm:ss" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<input name="title" id="msg">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Understood</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- 페이징 -->
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="page-item"><a class="page-link" href="#"
					onclick="goPage(${pageMaker.startPage-1})">Previous</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
				var="num">
				<li class="page-item"><a class="page-link" href="#"
					onclick="goPage(${num})">${num}</a></li>
			</c:forEach>

			<c:if test="${pageMaker.next}">
				<li class="page-item"><a class="page-link" href="#"
					onclick="goPage(${pageMaker.endPage+1})">Next</a></li>
			</c:if>
		</ul>
	</nav>
</body>
</html>