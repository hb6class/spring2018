<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
</head>
<body>
<%@ include file="template/menu.jsp" %>
<div class="jumbotron">
  <h1>Hello, world!</h1>
	<P>  The time on the server is ${serverTime}. </P>
  <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
</div>

</body>
</html>
