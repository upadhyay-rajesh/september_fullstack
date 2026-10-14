<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%-- Configures UTF-8 output. --%>
<!DOCTYPE html>
<%-- Declares HTML5 document. --%>
<html lang="en">
<%-- Starts English-language page. --%>
<head>
<meta charset="UTF-8">
<%-- Defines character encoding. --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- Enables responsive layout. --%>
<title>Instagram Hibernate - Login</title>
<%-- Sets browser title. --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<%-- Loads the local stylesheet. --%>
</head>
<body>
	<%-- Starts visible document body. --%>
	<main class="card">
		<%-- Creates centered content card. --%>
		<h1>Instagram Hibernate</h1>
		<%-- Displays application heading. --%>
		<h2>Login</h2>
		<%-- Displays form heading. --%>
		<%
		if (request.getAttribute("error") != null) {
		%><p class="error"><%=request.getAttribute("error")%></p>
		<%
		}
		%><%-- Displays server-side validation errors. --%>
		<%
		if (request.getAttribute("message") != null) {
		%><p class="success"><%=request.getAttribute("message")%></p>
		<%
		}
		%><%-- Displays server-side success message. --%>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<%-- Submits a standard HTTP POST; no JavaScript or AJAX. --%>
			<label>Username</label>
			<%-- Labels username input. --%>
			<input name="username" required>
			<%-- Collects username. --%>
			<label>Password</label>
			<%-- Labels password input. --%>
			<input type="password" name="password" required>
			<%-- Collects password. --%>
			<button type="submit">Login</button>
			<%-- Submits form to LoginServlet. --%>
		</form>
		<%-- Ends login form. --%>
		<p>
			New user? <a href="${pageContext.request.contextPath}/register">Register
				here</a>
		</p>
		<%-- Links to registration servlet. --%>
	</main>
	<%-- Ends card. --%>
</body>
<%-- Ends body. --%>
</html>
<%-- Ends document. --%>
