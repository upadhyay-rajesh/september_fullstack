<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Groups</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<h2>Communities / Groups</h2>
		<div class="card p-3 mb-4">
			<form method="post"
				action="${pageContext.request.contextPath}/groups/create">
				<input class="form-control mb-2" name="name" required
					placeholder="Group name">
				<textarea class="form-control mb-2" name="description"
					placeholder="Description"></textarea>
				<button class="btn btn-primary">Create group</button>
			</form>
		</div>
		<div class="row g-3">
			<c:forEach items="${groups}" var="g">
				<div class="col-md-6">
					<div class="card p-3">
						<h5>${g.name}</h5>
						<p>${g.description}</p>
						<small>Created by ${g.creator.fullName}</small>
						<form method="post"
							action="${pageContext.request.contextPath}/groups/${g.id}/join"
							class="mt-3">
							<button class="btn btn-outline-primary btn-sm">Join
								group</button>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>