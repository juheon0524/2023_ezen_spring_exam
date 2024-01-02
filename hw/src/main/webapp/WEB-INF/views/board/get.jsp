<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board Read page
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
					<div class="form-group">
						<label>Id</label>
						<input class="form-control" name="id" value="${home.id}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Name</label>
						<input class="form-control" name="name" value="${home.name}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Age</label>
						<input class="form-control" name="age" value="${home.age}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Birth</label>
						<input class="form-control" name="birth" value="${home.birth}" readonly="readonly">
					</div>
					<button data-oper="modify" class="btn btn-default">Modify</button>
					<button data-oper="list" class="btn btn-info">List</button>
					
					<form id="operForm" action="/board/modify" method="get">
						<input type="hidden" id="id" name="id" value="${home.id}">
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
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#id").remove();
			operForm.attr("action", "/board/list").submit();
		});
	});
</script>


<%@ include file="../includes/footer.jsp"%>
