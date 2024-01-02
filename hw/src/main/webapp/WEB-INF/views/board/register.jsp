<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board Register
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="from" action="/board/register" method="post">
					<div class="form-group">
						<label>Name</label>
						<input class="form-control" name="name">
					</div>
					<div class="form-group">
						<label>Age</label>
						<input class="form-control" name="age">
					</div>
					<div class="form-group">
						<label>Birth</label>
						<input class="form-control" name="birth">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
					<button type="reset" class="btn btn-danger">Reset Button</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<%@ include file="../includes/footer.jsp"%>
