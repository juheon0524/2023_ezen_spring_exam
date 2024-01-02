<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Board Register</h1>
	<form role="from" action="/board/register" method="post">
		<div class="form-group">
			<label>Title</label> <input class="form-control" name="title">
		</div>
		<div class="form-group">
			<label>Text-area</label>
			<textarea class="form-control" rows="3" name="content"></textarea>
		</div>
		<div class="form-group">
			<label>Writer</label> <input class="form-control" name="writer">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
		<button type="reset" class="btn btn-danger">Reset Button</button>
	</form>
</body>
</html>









