<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Join SocialBook</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container auth-wrap">
		<div class="card shadow-sm p-4">
			<h2 class="text-primary">Create your account</h2>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
			<form method="post"
				action="${pageContext.request.contextPath}/register">
				<label class="form-label">Full name</label><input
					class="form-control mb-3" name="fullName" required maxlength="120"><label
					class="form-label">Email</label><input class="form-control mb-3"
					type="email" name="email" required><label
					class="form-label">Password</label><input class="form-control mb-3"
					type="password" name="password" minlength="8" required>
				<button class="btn btn-primary">Register</button>
				<a class="btn btn-outline-secondary"
					href="${pageContext.request.contextPath}/login">Back to login</a>
			</form>
		</div>
	</div>
</body>
</html>
