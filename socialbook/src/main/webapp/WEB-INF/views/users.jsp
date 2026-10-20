<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>People</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<h2>Find people</h2>
		<form method="get" class="row g-2 mb-4"
			action="${pageContext.request.contextPath}/users/search">
			<div class="col-md-8">
				<input class="form-control" name="q" value="<c:out value='${q}'/>"
					placeholder="Name or email">
			</div>
			<div class="col-md-4">
				<button class="btn btn-primary">Search</button>
			</div>
		</form>
		<div class="row g-3">
			<c:forEach items="${users}" var="u">
				<div class="col-md-6">
					<div class="card p-3">
						<h5>${u.fullName}</h5>
						<p>${u.city}</p>
						<small>${u.email}</small>
						<form method="post"
							action="${pageContext.request.contextPath}/users/${u.id}/friend"
							class="mt-3">
							<button class="btn btn-outline-primary btn-sm">Send
								friend request</button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>