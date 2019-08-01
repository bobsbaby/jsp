<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

table {
	width: 150px;
	text-align: center;
}

td {
	height : 80px 
}

</style>
</head>
<body>
	<!-- 조회된 결과값을 출력 -->

	<%--1. userdao 선언 
		2. getUserList() 호출
		3. 호출 결과(List<UserVo>)를 for loop을 통해 tr 태그를 반복 생성
		--%>

	<%
		UserDao dao = new UserDao();
		List<UserVo> list = dao.getUserList();
				%>

	<table border="1">
		<tr>
			<th>이름</th>
		</tr>

<%-- 		<%for (int i = 0; i < list.size(); i++ ) { %> --%>
<!-- 		<tr> -->
<%-- 			<td><%=list.get(i).getUserName() %></td> --%>
<!-- 		</tr> -->
		
<%-- 		<% } %> --%>
	
		<% for(UserVo user : list) {  %> 
		<tr>
			<td><%=user.getUserName()%> </td>
		<% } %>
			</tr>

	</table>

</body>
</html>