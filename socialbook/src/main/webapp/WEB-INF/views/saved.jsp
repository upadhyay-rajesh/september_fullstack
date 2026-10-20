<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Saved posts</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<h2>Saved posts</h2>
		<c:forEach items="${posts}" var="p">
			<div class="card p-3 mb-3">
				<strong>${p.author.fullName}</strong>
				<p>
					<c:out value="${p.content}" />
				</p>
				<small>${p.createdAt}</small>
			</div>
		</c:forEach>
	</main>
</body>
</html>