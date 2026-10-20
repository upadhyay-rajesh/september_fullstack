<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Notifications</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<h2>Notifications</h2>
		<c:forEach items="${notifications}" var="n">
			<div class="card p-3 mb-2">
				<c:out value="${n.message}" />
				<small class="text-muted">${n.createdAt}</small>
			</div>
		</c:forEach>
		<c:if test="${empty notifications}">
			<p class="text-muted">No notifications yet.</p>
		</c:if>
	</main>
</body>
</html>