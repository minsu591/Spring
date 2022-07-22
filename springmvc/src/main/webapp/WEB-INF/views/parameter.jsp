<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 스트링으로 받기 String -->
	<h4>스트링으로 받기</h4>
	<form action="req1">
		<input name="id">
		<button>스트링</button>
	</form>
	<hr>
	
	<!-- 스트링 배열로 받기 String[] -->
	<h4>String[],  스트링 배열로 받기</h4>
	<form action="req2">
		<label><input type="checkbox" name="ids" value="100">100</label>
		<label><input type="checkbox" name="ids" value="101">101</label>
		<label><input type="checkbox" name="ids" value="102">102</label>
		<button>스트링배열</button>
	</form>
	<hr>
	
	<!-- 맵으로 받기 Map -->
	<h4>Map으로 받기</h4>
	<form action="req3">
		<label><input type="checkbox" name="id1" value="100">100</label>
		<label><input type="checkbox" name="id2" value="101">101</label>
		<label><input type="checkbox" name="id3" value="102">102</label>
		<button>맵</button>
	</form>
	
	<hr>
	
	<!-- VO로 받기  -->
	<h4>VO로 받기</h4>
	<form action="req4">
		<input name="id">
		<label><input type="checkbox" name="ids" value="100">100</label>
		<label><input type="checkbox" name="ids" value="101">101</label>
		<label><input type="checkbox" name="ids" value="102">102</label>
		<button>VO</button>
	</form>
	
	<hr>
	<h4>List&lt;VO&gt;로 받기</h4>
	<form action="req5">
		<div name="id">
			<input name="list[0].id">
			<label><input type="checkbox" name="list[0].ids" value="100">100</label>
			<label><input type="checkbox" name="list[0].ids" value="101">101</label>
			<label><input type="checkbox" name="list[0].ids" value="102">102</label>
		</div>
		<div>
			<input name="list[1].id">
			<label><input type="checkbox" name="list[1].ids" value="100">100</label>
			<label><input type="checkbox" name="list[1].ids" value="101">101</label>
			<label><input type="checkbox" name="list[1].ids" value="102">102</label>
		</div>
		<div>
			<input name="list[2].id">
			<label><input type="checkbox" name="list[2].ids" value="100">100</label>
			<label><input type="checkbox" name="list[2].ids" value="101">101</label>
			<label><input type="checkbox" name="list[2].ids" value="102">102</label>
		</div>
		
		<button>List&lt;VO&gt;</button>
	</form>
	
	<hr>
	<h4>파일로 받기</h4>
	<form action="req6" method="post" enctype="multipart/form-data">
		<input name="id">
		<label><input type="checkbox" name="ids" value="100">100</label>
		<label><input type="checkbox" name="ids" value="101">101</label>
		<label><input type="checkbox" name="ids" value="102">102</label>
		<input type="file" name="pic" multiple = "multiple">
		<button>file</button>
	</form>
	
	<hr>
	<h4>a에 값 담기</h4>
	<a href="req7/choi/20">pathvariable</a>
	
	
</body>
</html>