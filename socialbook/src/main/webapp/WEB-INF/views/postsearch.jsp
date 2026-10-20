<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Search posts</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<h2>Search posts</h2>
		<form method="get"
			action="${pageContext.request.contextPath}/search/posts"
			class="input-group mb-4">
			<input class="form-control" name="q" value="<c:out value='${q}'/>">
			<button class="btn btn-primary">Search</button>
		</form>
		<c:forEach items="${posts}" var="p">
			<div class="card p-3 mb-3">
				<strong>${p.author.fullName}</strong>
				<p class="mt-2">
					<c:out value="${p.content}" />
				</p>
				<small>${p.createdAt}</small>
			</div>
		</c:forEach>
	</main>
</body>
</html>