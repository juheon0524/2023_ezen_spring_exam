<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/subscrInsert.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>구독권 등록</title>

</head>

<body>
	<%@ include file="includes/header.jsp"%>
	<div class="shareContainer">
		<div class="shareImg" style="background: url(image/svisual_img.png);"></div>
		<div class="shareContentWrap">
			<div class="shareNav">
				<ul>
					<li class="navTitle">관리자 페이지</li>
					<li><span>도서 관리&nbsp;&nbsp;&nbsp;</span> <i
						class="fa-solid fa-chevron-down book-chevron-down"></i> <i
						class="fa-solid fa-chevron-up book-chevron-up"
						style="display: none;"></i></li>
					<li class="bookNav"><span style=""><a
							href="BookServlet?command=book_insert_form">도서등록</a></span></li>
					<li class="bookNav"><span>도서수정</span></li>
					<li class="bookNav"><span>도서연체 관리</span></li>
					<li class="bookNav"><span>대여도서 관리</span></li>
					<li class="bookNav"><span>반납도서 관리</span></li>
					<li><span>구독권 관리</span> <i
						class="fa-solid fa-chevron-down subscription-chevron-down"></i> <i
						class="fa-solid fa-chevron-up subscription-chevron-up"
						style="display: none;"></i></li>
					<li class="subscriptionNav"><span><a
							href="BookServlet?command=subscr_list">구독권 조회</a></span></li>
					<li class="subscriptionNav"><span class="keyword"><a
							href="BookServlet?command=subscr_insert_form">구독권 등록</a></span></li>
				</ul>
			</div>
			<div class="shareContentBox">
				<div class="shareContentTitle">
					<div class="contentTitle">구독권 등록</div>
					<div class="contentNav">
						<span>홈</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>관리자 페이지</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>구독권 관리</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>구독권 등록</span>
					</div>
				</div>

				<div class="shareContent">
					<form action="BookServlet?command=subscr_insert" method="post"
						name="frm" class="subscrInsertWrap">
						<input type="hidden" name="command" value="subscr_insert">
						<table>

							<tr>
								<th>구독권명</th>
								<td><input type="text" name="subscrname"
									class="subscrInsert"></td>
							</tr>
							<tr>
								<th>판매가격</th>
								<td><input type="text" name="price" class="subscrInsert"></td>
							</tr>
							<tr>
								<th>판매개시일</th>
								<td><input type="text" name="salefromdate"
									class="subscrInsert"></td>
							</tr>
							<tr>
								<th>판매종료일</th>
								<td><input type="text" name="saletodate"
									class="subscrInsert"></td>
							</tr>
							<tr>
								<th>구독기간</th>
								<td><input type="text" name="subscrperiod"
									class="subscrInsert"></td>
							</tr>
							<tr>
								<th>대여가능 도서수</th>
								<td><input type="text" name="allowedbookcnt"
									class="subscrInsert"></td>
							</tr>
							<tr>
								<th>등록자</th>
								<td><input type="text" name="memberid" class="subscrInsert"></td>
							</tr>

						</table>
						<div class="subscrInsertBtnBox">
							<input type="submit" value="등록" onclick="return subscrCheck()">
							<input type="reset" value="취소" class="subscrInsertBtn">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$(".book-chevron-down").click(function() {
				$(".bookNav").show();
				$(this).hide();
				$(".book-chevron-up").show();
			});

			$(".book-chevron-up").click(function() {
				$(".bookNav").hide();
				$(this).hide();
				$(".book-chevron-down").show();
			});
		});

		$(document).ready(function() {
			$(".subscription-chevron-down").click(function() {
				$(".subscriptionNav").show();
				$(this).hide();
				$(".subscription-chevron-up").show();
			});

			$(".subscription-chevron-up").click(function() {
				$(".subscriptionNav").hide();
				$(this).hide();
				$(".subscription-chevron-down").show();
			});
		});
		
		function subscrCheck(){
		    if(document.frm.subscrname.value.length == 0){
		        alert("구독권명을 확인해 주세요.");
		        return false;
		    }
		    if(document.frm.price.value.length == 0){
		        alert("구독권 가격을 확인해 주세요.");
		        return false;
		    }
		    if(document.frm.salefromdate.value.length == 0){
		        alert("판매시작일자를 확인해 주세요.");
		        return false;
		    }
		    if(document.frm.saletodate.value.length == 0){
		        alert("판매종료일자를 확인해 주세요.");
		        return false;
		    }
		    if(document.frm.subscrperiod.value.length == 0){
		        alert("구독기간을 확인해 주세요.");
		        return false;
		    }
		    if(document.frm.allowedbookcnt.value.length == 0){
		        alert("대여가능 도서수를 확인해 주세요.");
		        return false;
		    }
		    if(document.frm.memberid.value.length == 0){
		        alert("등록자를 확인해 주세요.");
		        return false;
		    }
		    if(document.frm.registereddate.value.length == 0){
		        alert("등록/수정일자를 확인해 주세요.");
		        return false;
		    }
		    
		    let fromdate = new Date(document.frm.salefromdate.value);
		    let todate = new Date(document.frm.saletodate.value);
		    let nowdate = new Date();
		    if (todate < fromdate){
				alert("판매종료일자는 판매시작일자 이후로 입력해 주세요");
				return false;
			}
			if (fromdate < nowdate){
				alert("판매개시일은 이전 날짜를 입력할 수 없습니다.");
				return false;
			}
		    
		    return true;
		}
	</script>

	<%@ include file="includes/footer.jsp"%>
</body>

</html>