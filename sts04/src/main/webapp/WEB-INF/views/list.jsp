<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script type="text/javascript">
	function detail(){
		$('.detailForm input').hide();
		$('.modal-title').html('상세페이지');
		$('.modal-footer').show();		
		$('.well-input').show();
	}
	function edit(){
		$('.detailForm input').show();
		$('.modal-title').html('수정페이지');
		$('.modal-footer').hide();
		$('.well-input').hide();
	}
	
	$(function(){
		detail();
		
		$('#myModal-${sabun }').modal({show:true});
		
		$('.yourModal').on('hide.bs.modal', function (e) { detail(); });
		$('.edit').click(function(){ edit(); });
	});


</script>

</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <p>비트교육센터</p>
      </a>
    </div>
    <ul class="nav navbar-nav">
    	<li><a href="#">Home</a></li>
    	<li><a href="#">List</a></li>
    	<li><a href="#" data-toggle="modal" data-target=".bs-example-modal-lg">Add</a></li>
		<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		      	<h4>입력페이지</h4>
		      </div>
		      <div class="modal-body">
		      	<form method="post">
		      		<div class="form-group">
		      			<label for="sabun">sabun</label>
		      			<input type="text" class="form-control" name="sabun" id="sabun" placeholder="사번" />
		      		</div>
		      		<div class="form-group">
		      			<label for="name">name</label>
		      			<input type="text" class="form-control" name="name" id="name" placeholder="이름" />
		      		</div>
		      		<div class="form-group">
		      			<label for="pay">pay</label>
		      			<input type="text" class="form-control" name="pay" id="pay" placeholder="금액" />
		      		</div>
			        <button type="submit" class="btn btn-primary">입력</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      	</form>
		      </div>
		      
		    </div>
		  </div>
		</div>
    </ul>
  </div>
</nav>

<div class="list-group">
	<c:forEach items="${alist }" var="bean">
	  <button type="button" class="list-group-item btn btn-default btn-lg" data-toggle="modal" data-target="#myModal-${bean.sabun }">
	  	<span class="badge">${bean.pay }</span>
	  	<h4 class="list-group-item-heading">${bean.sabun }</h4>
	    <p class="list-group-item-text">[${bean.nalja }]${bean.name }</p>
	  </button>
	  
<!-- Modal -->
		<div class="modal fade yourModal" id="myModal-${bean.sabun }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel-${bean.sabun }">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel-${bean.sabun }">${bean.sabun }님 상세페이지</h4>
		      </div>
		      <div class="modal-body">
		        <form action="./${bean.sabun }" method="post" class="detailForm">
		        	<input type="hidden" name="_method" value="put">
		      		<div class="form-group">
		      			<label for="sabun">sabun</label>
				        <div class="well well-sm">${bean.sabun }</div>
		      			<input type="hidden" value="${bean.sabun }" class="form-control" name="sabun" id="sabun" placeholder="사번" />
		      		</div>
		      		<div class="form-group">
		      			<label for="name">name</label>
				        <div class="well well-sm well-input">${bean.name }</div>
		      			<input type="text" value="${bean.name }" class="form-control" name="name" id="name" placeholder="이름" />
		      		</div>
		      		<div class="form-group">
		      			<label>nalja</label>
				        <div class="well well-sm">${bean.nalja }</div>
		      		</div>
		      		<div class="form-group">
		      			<label for="pay">pay</label>
				        <div class="well well-sm well-input">${bean.pay }</div>
		      			<input type="text" value="${bean.pay }" class="form-control" name="pay" id="pay" placeholder="금액" />
		      		</div>
			        <input type="submit" class="btn btn-danger" value="수정"/>
			        <input type="button" class="btn btn-default" data-dismiss="modal" value="Close"/>
		      	</form>
		      </div>
		      <div class="modal-footer">
		        <form action="./${bean.sabun }" method="post">
		        <input type="hidden" name="_method" value="delete">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary edit">수정</button>
		        <button type="submit" class="btn btn-danger delete">삭제</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
	</c:forEach>
</div>

</body>
</html>










