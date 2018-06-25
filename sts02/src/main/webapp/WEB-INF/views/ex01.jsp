<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex01 page</h1>
	<a href="guest/ex02">go ex02</a>
	<br/><br/><br/>
	<form action="guest/ex02" method="post">
		id:<input type="text" name="id" /><br/>
		su:<input type="number" name="pw" /><br/>
		<button type="submit">go ex02</button>
	</form>
</body>
</html>