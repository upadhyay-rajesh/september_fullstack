<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Friends</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<h2>Friend requests</h2>
		<c:forEach items="${requests}" var="r">
			<div class="card p-3 mb-2">
				<strong>${r.requester.fullName}</strong>
				<div class="d-flex gap-2 mt-2">
					<form method="post"
						action="${pageContext.request.contextPath}/friends/${r.id}/respond">
						<input type="hidden" name="accept" value="true">
						<button class="btn btn-success btn-sm">Accept</button>
					</form>
					<form method="post"
						action="${pageContext.request.contextPath}/friends/${r.id}/respond">
						<input type="hidden" name="accept" value="false">
						<button class="btn btn-outline-danger btn-sm">Decline</button>
					</form>
				</div>
			</div>
		</c:forEach>
		<h2 class="mt-4">Friends</h2>
		<c:forEach items="${friends}" var="f">
			<div class="card p-3 mb-2">${f.requester.fullName}—
				${f.recipient.fullName}</div>
		</c:forEach>
	</main>
</body>
</html>