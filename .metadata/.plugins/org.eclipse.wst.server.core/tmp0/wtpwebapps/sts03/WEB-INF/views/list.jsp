<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
</head>
<body>
<%@ include file="template/menu.jsp" %>
	<table class="table">
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>날짜</th>
				<th>금액</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${alist }" var="bean">
				<tr>
					<td><a href="./${bean.sabun }">${bean.sabun }</a></td>
					<td><a href="./${bean.sabun }">${bean.name }</a></td>
					<td><a href="./${bean.sabun }">${bean.nalja }</a></td>
					<td><a href="./${bean.sabun }">${bean.pay }</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>