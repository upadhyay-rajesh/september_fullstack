<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Login | SocialBook</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/style.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container auth-wrap">
		<div class="card shadow-sm p-4">
			<h1 class="text-primary fw-bold">SocialBook</h1>
			<p class="text-muted">Connect with people who matter.</p>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
			<c:if test="${not empty success}">
				<div class="alert alert-success">${success}</div>
			</c:if>
			<form method="post" action="${pageContext.request.contextPath}/login">
				<div class="mb-3">
					<label class="form-label">Email</label><input class="form-control"
						type="email" name="email" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Password</label><input
						class="form-control" type="password" name="password" required>
				</div>
				<button class="btn btn-primary w-100">Log in</button>
			</form>
			<p class="mt-3 mb-0">
				New here? <a href="${pageContext.request.contextPath}/register">Create
					an account</a>
			</p>
		</div>
	</div>
</body>
</html>
