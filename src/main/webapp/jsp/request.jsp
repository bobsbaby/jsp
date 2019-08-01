<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//jsp에 내장되어 있는 기본 객체가 8가지 : request, response
	//별도의 선언 없이 사용 가능 하다. 
	
%>
<body>

	request.getLocalAddr() local ip : <%=request.getLocalAddr()%><br>
	request.getRemoteAddr() 클라이언트 IP : <%=request.getRemoteAddr() %> <br>
	request.getContentLength() 요청정보길이 :  <%=request.getContentLength() %> <br>
	request.getCharacterEncoding() 요청정보 인코딩 : <%=request.getCharacterEncoding() %> <br>
	request.getContentType() 요청정보 컨텐트 타입 : <%=request.getContentType() %> <br>
	request.getProtocol() 요청 프로토콜 : <%=request.getProtocol() %> <br>
	
	<%--service에 들어가면 get method가 있음  --%>
	request.getMethod() 요청 메소드 : <%=request.getMethod() %> <br> 
	request.getRequestURI() 요청 URI :<%=request.getRequestURI() %> <br>
	
	<%-- 어플리케이션 이름 --%>
	request.getContextPath() 요청 context path : <%=request.getContextPath() %> <br>
	request.getServerName() 서버 이름 : <%=request.getServerName() %> <br>
	request.getServerPort() 서버 포트 : <%=request.getServerPort() %> <br>
	
	
</body>
</html>