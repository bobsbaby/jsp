<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 파라미터를 받는다
		input tag의 name 속성이 파라미터 이름
		userId, password
		String userID = request.getParameter("userId"); -> 문자열 
		String userID = request.getParameter(userId); -> 객체

		String password = request.getParameter("password");
	 -->
	 
	 <%
		//POST방식 한글 지원
		//parameter를 받은 다음에 setcharacter를 해주면 적용이 안 되므로 제일 처음에 해줘야 한다. 
		//parameter 관련 메소드를 호출하기 전에 setCharacterEncoding 메소드를 호출해야 인코딩 설정이 적용된다.
	 	request.setCharacterEncoding("utf-8");
	 %>
	 request method : <%=request.getMethod() %><br>
	 
	<%
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
	%>
	
	<h2>request.getParameter()</h2>
	parameter userId : <%=userId %> <br>
	parameter password : <%=password %> <br>
	
	<%
		//값이 여러개인 경우 배열로 받을 수 있다. 
		String[] userIds = request.getParameterValues("userId");
		
	%>
	
	<h2>request.getParameterValues()</h2>
	<%for(String str : userIds){ %>
		parameter userId : <%=str %> <br>
	<%} %>
		parameter password : <%=password %><br>
	<%
		Map<String, String[]> requestMap = request.getParameterMap();
		Set<String> keyset = requestMap.keySet();
		
	%>
	<h2>request.getParameterMap()</h2>
	
	<%for(String key : keyset){ %>
		<%=key %> : <%=Arrays.toString(requestMap.get(key))%> <br>
	<%} %>
	
	<%
			
		Enumeration<String> parameterNames = request.getParameterNames();
	%>
	
	<h2>request.getParameterNames()</h2>
	
	<%while(parameterNames.hasMoreElements()){
		String parameterName = parameterNames.nextElement();
		%>
		
		<%=parameterName %> <br>
		
		<% }%>
	
</body>
</html>


















