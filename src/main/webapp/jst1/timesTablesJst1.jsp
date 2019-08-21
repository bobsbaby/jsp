<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
	body { padding-top: 50px; }
	td, th { text-align: center; }
	th { background: silver; font-size: 20px; }
</style>
<script>
	$(function() {
		var arr = [];
		 
		for(var i=0; i<10; i++) {
		    arr[i] = "#" + Math.round(Math.random() * 0xffffff).toString(16);
		    console.log(arr[i]);
		}
		
		$.each($("td"), function() {
			$(this).css("background", arr[$(this).text().substring(0, 1)]);
		})
		
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<%--구구단 --%>
	<div class="container">
		<table border="1" class="table table-bordered">
			<c:forEach begin="0" end="9" var="i">
				<tr>
					<c:forEach begin="2" end="9" var="j">
						<c:choose >
							<c:when test="${i == 0 }">
								<th>${j }단</th>
							</c:when>
							<c:otherwise>
								<td>${j } x ${i } = ${i*j }</td>
							</c:otherwise>
						</c:choose> 
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html> 