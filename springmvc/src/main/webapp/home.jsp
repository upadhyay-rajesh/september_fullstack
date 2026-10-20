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
	String email = request.getAttribute("myemail").toString();
%>
<a href="edit.htm?userid=<%= email %>">Edit Profile</a>
<a href="delete.htm?userid=<%= email %>">delete Profile</a>
<a href="view.htm?userid=<%= email %>">view Profile</a>

</body>
</html>