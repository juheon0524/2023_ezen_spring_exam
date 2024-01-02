<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<h1>Board Moidfy</h1>
	<form role="form" action="/board/modify" method="post">
		<div class="form-group">
			<label>Bno</label> <input class="form-control" name="bno"
				value="${board.bno}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>Title</label> <input class="form-control" name="title"
				value="${board.title}">
		</div>
		<div class="form-group">
			<label>Text-area</label>
			<textarea class="form-control" rows="3" name="content">${board.content}</textarea>
		</div>
		<div class="form-group">
			<label>Writer</label> <input class="form-control" name="writer"
				value="${board.writer}" readonly="readonly">
		</div>
		<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
		<button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
		<button type="submit" data-oper="list" class="btn btn-info">List</button>
	</form>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form");
		$("button").on("click", function(e) {
			e.preventDefault(); //이동중지

			var operation = $(this).data("oper");
			//console.log(operation);
			if (operation === "remove") {
				formObj.attr("action", "/board/remove"); //post방식으로 이동
			} else if (operation === "list") {
				/* self.location = "/board/list"
				return;   //get방식으로 이동 */
				formObj.attr("action", "/board/list").attr("method", "get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();

				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
			}

			formObj.submit();
		});
	});
</script>
</html>




