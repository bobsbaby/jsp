<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	response.setHeader("Content-Disposition", "attachment; filename=line.xls");
	IUserDao userDao = new UserDao();
	List<UserVo> userlist = userDao.getUserList();
%>

<table>

	<tr>
		<td>이름</td>
		<td>나이</td>
	</tr>
	
	<% for (UserVo userVo : userlist) { %>
		<tr>
			<td><%=userVo.getUserName() %></td>
			<td></td>
		</tr>
	<%} %>
	
</table>
</body>
</html>