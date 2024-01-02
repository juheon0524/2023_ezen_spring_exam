<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board Modify page
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/modify" method="post">
					<div class="form-group">
						<label>Id</label>
						<input class="form-control" name="id" value="${home.id}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Name</label>
						<input class="form-control" name="title" value="${home.name}">
					</div>
					<div class="form-group">
						<label>Age</label>
						<input class="form-control" name="age" value="${home.age}">
					</div>
					<div class="form-group">
						<label>Birth</label>
						<input class="form-control" name="birth" value="${home.birth}">
					</div>
					<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
        			<button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
					<button type="submit" data-oper="list" class="btn btn-info">List</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form");
		$("button").on("click", function(e){
			e.preventDefault(); //이동중지
			
			var operation = $(this).data("oper");
			//console.log(operation);
			if(operation==="remove"){
				formObj.attr("action", "/board/remove"); //post방식으로 이동
			}else if(operation==="list"){
				/* self.location = "/board/list"
				return;   //get방식으로 이동 */
				formObj.attr("action", "/board/list").attr("method","get");
				formObj.empty();
			}
			
			formObj.submit();
		});
	});
</script>



<%@ include file="../includes/footer.jsp"%>
