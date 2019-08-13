<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>

<script>
	$(function(){
		$('#sum, #mul').click(function(){
			var sig = $(this).attr("id");
			$('form').attr('sign', sig);
		})
	})

</script>
</head>
<body>

<form action = "${pageContext.request.contextPath }/jsp/requestSum.jsp" method = "get">
	
	number : <input type = "text" name = "number" value = "5"/>
	number2 : <input type = "text" name = "number2" value = "10"/>
	sum : <input type = "radio" id = "sum" name = "sign" value = "합" checked/>
	mul : <input type = "radio" id = "mul" name = "sign" value = "곱"/>
	<input type ="submit" value = "결과확인"/>

</form>

</body>
</html>