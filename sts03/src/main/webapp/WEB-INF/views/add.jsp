<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
</head>
<body>
<%@ include file="template/menu.jsp" %>
<form action="./" method="post">
	<div class="form-group">
		<label for="sabun">sabun</label>
		<input type="text" class="form-control" name="sabun" id="sabun" placeholder="sabun을 입력하세요" />
	</div>
	<div class="form-group">
		<label for="name">name</label>
		<input type="text" class="form-control" name="name" id="name" placeholder="name을 입력하세요" />
	</div>
	<div class="form-group">
		<label for="pay">pay</label>
		<input type="text" class="form-control" name="pay" id="pay" placeholder="pay" />
	</div>
	<div role="group" class="btn-group">
	<button type="submit" class="btn btn-danger">입력</button>
	<button type="reset" class="btn btn-default">취소</button>
	</div>
</form>

</body>
</html>