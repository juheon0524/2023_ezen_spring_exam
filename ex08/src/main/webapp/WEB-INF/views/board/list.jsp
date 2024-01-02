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

	<h1>Board List</h1>
	<button id="regBtn" type="button"
		class="btn btn-xs btn-primary pull-right">Register New Board
	</button>
	
	<table width="100%"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>

					<c:forEach var="board" items="${list}">
						<tr class="odd gradeX">
							<td>${board.bno}</td>

							<td><a class="move" href="/board/get?bno=${board.bno}">${board.title}</a></td>

							<td>${board.writer}</td>
							<td><fmt:formatDate value="${board.regdate}"
									pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${board.updateDate}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</table>
	
	<script type="text/javascript">
	
	//register 호출
	$("#regBtn").on("click",function(){
		self.location = "/board/register";
	});
	</script>


</body>
</html>