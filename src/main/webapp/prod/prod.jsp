<%@page import="kr.or.ddit.lprod.model.LprodVo"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>


<%@ include file = "/commonJsp/basicLib.jsp" %>

</head>
<body>
<form id = "frm" action ="${cp }/prodList" method = "get">
	<input type = "hidden" id = "lprod_gu" name = "lprod_gu"/>
</form>
<!-- header -->	
header
<%@include file = "/commonJsp/header.jsp" %>
<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	
	<%@ include file = "/commonJsp/left.jsp" %>

</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>제품그룹명</th>
					<th>제품그룹번호</th>
					<th>바이어이름</th>
					<th>제품아이디</th>
					<th>제품명</th>
					<th>가격</th>
				</tr>

				
				<%--루프 태그 for (USer user : userList) --%>
				<c:forEach items="${prod}" var="prod">
					<tr class = "lprodTr">
						<td>${prod.LPROD_NM}</td>
						<td>${prod.PROD_LGU}</td>
						<td>${prod.BUYER_NAME}</td>
						<td>${prod.PROD_ID}</td>
						<td>${prod.PROD_NAME}</td>
						<td>${prod.PROD_PRICE}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>