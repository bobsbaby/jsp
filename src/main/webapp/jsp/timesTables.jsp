<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-spacing: 5px;
}

td {
	border: 2px solid pink;
	height: 50px;
	width: 80px;
	text-align: center;
}
</style>
</head>
<body>
	times tables.jsp
	<table>
		<%for(int i = 1; i <=9; i++){	%>
		<tr>
			<%for (int j = 2; j <=9; j++){ %>
			<td><%= j + "*" + i + "=" + i * j %></td>
			<%} %>
		</tr>
		<%} %>
	</table>
</body>
</html>