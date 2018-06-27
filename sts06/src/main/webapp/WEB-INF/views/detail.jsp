<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var btn=false;
		$('input').attr('readonly','readonly');
		$('button').eq(0).on('click',function(){
			if(btn){
				$('form').submit();
			}else{
				$('.edit').removeAttr('readonly');
				$('#nalja').removeAttr('name');
				$('h1').html('수정 페이지');
				btn=true;
			}
		});
		$('button').eq(1).click(function(){
			if(btn){
				$('.edit').attr('readonly','readonly');
				$('h1').html('상세 페이지');
				btn=false;
			}else{
				window.history.back();
			}
		});
		$('button').eq(2).click(function(){
			var param='idx='+$('#sabun').val();
			$.post('./delete',param,function(){
				window.location.href='./list';
			});
		});
	});
</script>
</head>
<body>
	<h1>상세 페이지</h1>
	<form action="update" method="post">
		<div>
			<label for="sabun">sabun</label>
			<input type="text" value="${bean.sabun }" name="sabun" id="sabun" />
		</div>
		<div>
			<label for="name">name</label>
			<input type="text" value="${bean.name }" class="edit" name="name" id="name" />
		</div>
		<div>
			<label for="nalja">nalja</label>
			<input type="text" value="${bean.nalja }" name="nalja" id="nalja" />
		</div>
		<div>
			<label for="pay">pay</label>
			<input type="text" value="${bean.pay }" class="edit" name="pay" id="pay" />
		</div>
		<button type="button">수정</button>
		<button type="button">뒤로</button>
		<button type="button">삭제</button>
	</form>
</body>
</html>