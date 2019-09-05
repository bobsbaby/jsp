<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cp }/js/jquery-3.4.1.min.js"></script>

</head>
<body>
	<h2>wrapper.jsp</h2>
	<form action="${cp }/wrapper" method = "post">
		<!-- name 속성이 있으면 공백이더라도 parameter는 간다. --> 
		unt_cd : <input type = "text" name = "unt_cd" /><br>
				 <input type = "submit" value = "전송" />
	</form>
	
</body>
</html>