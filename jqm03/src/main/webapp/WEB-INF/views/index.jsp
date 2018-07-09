<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="resources/js/cordova.js"></script>
<script type="text/javascript">

	function list(){
		jQuery.getJSON('list.json',function(data){
			// root:[{},{}]
			var arr=data.guests;
			var msg="";
			for(var i=0; i<arr.length; i++){
				var bean=arr[i];
				msg+="<tr>";
				msg+="<td>"+bean.sabun+"</td>";
				msg+="<td>"+bean.name+"</td>";
				msg+="<td>"+bean.nalja+"</td>";
				msg+="<td>"+bean.pay+"</td>";
				msg+="</tr>";
			}
			$('tbody').html(msg);
		});
	}

	$(document).ready(function(){
		list();
	});
</script>
</head>
<body>
	<h1>index page</h1>
	<table>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>날짜</th>
				<th>금액</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>














