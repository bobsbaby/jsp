<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	//application에 저장되어 있는 ds를 가지고 온다. 
	BasicDataSource ds = (BasicDataSource) application.getAttribute("ds");
	long start = System.currentTimeMillis();
	for(int i = 0; i <=20; i++){
	//ds를 connection객체에 연결시켜준다. 
	Connection connection = ds.getConnection();
	//statement 객체에 connection 연결 
	Statement stmp = connection.createStatement();
	ResultSet rs = stmp.executeQuery("select * from lprod");
	
	while(rs.next()){
		out.print("lprod_id : " +rs.getInt(1) + "<br>");
		out.print("lprod_gu : "+ rs.getString(2) + "<br>");
		out.print("lprod_nm : " +rs.getString(3) + "<br>");
		out.print("--------------------------------------------" + "<br>");
	}
	
	rs.close();
	stmp.close();
	connection.close();
	}
	long end = System.currentTimeMillis();
	out.print("end-start : " + (end-start) + "ms <br>");
%>
</body>
</html>