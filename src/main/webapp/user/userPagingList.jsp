<%@page import="kr.or.ddit.user.model.User"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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


<%@ include file="/commonJsp/basicLib.jsp"%>
<script>
	//문서 로딩이 완료된 후 작업 진행 
	$(document).ready(function() {
		//사용자 정보 클릭시 이벤트 핸들러 
		$('.userTr').on('click', function() {
			//클릭된 tr태그의 자식태그(td)중 첫번째 자식의 텍스트 문자열
			console.log($(this).children().first().text());
			var tdText = $(this).children().eq(1).text();
			console.log("tdText: " + tdText);

			// input 태그에 저장된 값 확인
			var inputValue = $(this).find("input").val();
			console.log("inputValue: " + inputValue);

			// data 속성으로 값(tr 태그에 저장된 값) 확인
			var dataValue = $(this).data("userid"); // 모두 소문자로 치환됨

			console.log("dataValue: " + dataValue);

			//input 태그에 값 설정 
			//$('#userId').val($(this).children().first().text());
			$("#userId").val(dataValue);
			//form태그 이용 전송 
			console.log("serialize : " + $('#frm').serialize());
			$('#frm').submit();
		})
	});
</script>
</head>
<body>
	<form id="frm" action="${cp }/user" method="get">
		<input type="hidden" id="userId" name="userId" />
	</form>
	<!-- header -->
	header
	<%@include file="/commonJsp/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">

				<%@ include file="/commonJsp/left.jsp"%>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>


								<%--루프 태그 for (USer user : userList) --%>
								<c:forEach items="${userList }" var="user">
									<tr class="userTr" data-userId="${user.userId }">
										<input type="hidden" value="${user.userId }" />
										<td>${user.userId }</td>
										<td>${user.userNm }</td>
										<td>${user.alias }</td>
										<td>${user.reg_dt_fmt }</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<br> <a href = "${cp }/userForm" class="btn btn-default center">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
<%-- 							이전페이지 가기 : 지금 있는 페이지에서 한 페이지 전으로
								단 1페이지인 경우는 li 태그에 class = "disabled"를 추가하고 이동경로는 차단  --%>
								<c:choose>
									<c:when test = "${pageVo.page == 1 }">
									<li class = "disabled"><a href = "#"aria-label-hidden="true">&laquo;</a></li>
									</c:when>
									<c:otherwise>
									<li><a href="${cp }/userPagingList?page=${pageVo.page-1 }" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span> </a></li>
									</c:otherwise>
								</c:choose>
								
<%-- 								<li class="disabled"><a href="${cp }/userPagingList?page=${param.page-1 }&pagesize=10" aria-label="Previous"> --%>
<!-- 										<span aria-hidden="true">&laquo;</span> -->
<!-- 								</a></li> -->
								
								<c:forEach begin="1" end="${pagenationSize }" var="page">
									<c:choose>
										<c:when test="${page == pageVo.page }">
											<%-- 								<li <c:if test = "${page == param.page }"> class = "active" </c:if> --%>
											<%-- 								<li class = "active"><a href="${cp }/userPagingList?page=${page }&pagesize=10">${page }</a></li> --%>
											<li class="active"><span>${page }</span></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${cp }/userPagingList?page=${page }">${page }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test = "${pageVo.page ==pagenationSize }">
										<li class = "disabled"><a href = "#"aria-label-hidden="true">&laquo;</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp }/userPagingList?page=${pageVo.page+1 }" aria-label="Next"><span
										aria-hidden="true">&raquo;</span> </a></li>
									</c:otherwise>
								</c:choose>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>