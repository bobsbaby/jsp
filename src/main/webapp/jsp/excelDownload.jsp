<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.IUserService"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@ page language="java"
	contentType="application/vnd.ms-excel; charset=UTF-8"
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
	IUserService userService = new UserService();
	List<User> userlist = userService.getUserList();
	%>

	<table>

		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>

		<%
			for (User userVo : userlist) {
		%>
		<tr>
			<td><%=userVo.getUserNm()%></td>
			<td><%=userVo.getUserId()%></td>
			<td><%=userVo.getPass()%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>