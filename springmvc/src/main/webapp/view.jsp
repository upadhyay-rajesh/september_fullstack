<%@page import="com.springmvc.entity.FacebookUser"%>
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
FacebookUser f1 = (FacebookUser) request.getAttribute("myuser");
out.println(f1.getName());
out.println(f1.getPassword());
out.println(f1.getEmail());
out.println(f1.getAddress());
%>

</body>
</html>