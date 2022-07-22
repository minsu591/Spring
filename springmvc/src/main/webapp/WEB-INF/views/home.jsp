<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	<img src="img/dog.jpg"/>
	<P>  The time on the server is ${serverTime}. </P>
	<button onclick="location.href='empInsert'">empInsert</button>
	<button onclick="location.href='empList'">empList</button>
	<button onclick="location.href='empUpdate'">empUpdate</button>
</body>
</html>
