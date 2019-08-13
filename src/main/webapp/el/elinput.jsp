<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/elScope" method="post">
		request : <input type="text" name="req" value="brown" /><br>
		session : <input type="text" name="session" value="cony" /><br>
		application : <input type="text" name="application" value="sally" /><br>
		<input type="submit" value="전송" />
	</form>

	<h2>el scope test</h2>
	<%
		//pageCountext
		pageContext.setAttribute("attr", "page_attr");
		request.setAttribute("attr", "request_attr");
		session.setAttribute("attr", "session_attr");
		application.setAttribute("attr", "application_attr");
	%>
	pageScope : ${pageScope.attr } <br>
	requestScope : ${requestScope.attr } <br>
	sessionScope : ${sessionScope.attr } <br>
	applicationScope : ${applicationScope.attr } <br>
	el : ${attr}
	<br>

	<%
		//(page = 1) 	S
		pageContext.removeAttribute("attr", pageContext.PAGE_SCOPE);
	%>
	
	el : ${attr} <br>
	<br>

	<%
		//(page = 1 request = 2) 	
		pageContext.removeAttribute("attr", pageContext.REQUEST_SCOPE);
	%>

	el : ${attr} <br>
	
	<%
		//(page = 1 request = 2 session = 3) 	
		//pagecontext 객체로 -> session, request, application, servlet 객체를 구할 수 있다. 
		//모든 객체로 접근 가능
		pageContext.removeAttribute("attr", pageContext.SESSION_SCOPE);
	%>

	el : ${attr}
	<br>
</body>
</html>