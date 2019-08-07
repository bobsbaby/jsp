<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "<%=request.getContextPath() %>/sumCalculation" method = "post">
	
	start : <input type = "text" name = "start" value = "5"/>
	end : <input type = "text" name = "end" value = "10"/>

	<input type ="submit" value = "결과확인"/>

</form>



</body>
</html>