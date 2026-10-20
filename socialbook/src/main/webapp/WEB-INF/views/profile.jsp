<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>My profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<div class="row g-4">
			<div class="col-lg-5">
				<div class="card p-4">
					<h2>Profile settings</h2>
					<form method="post"
						action="${pageContext.request.contextPath}/profile/update">
						<label class="form-label">Full name</label><input
							class="form-control mb-3" name="fullName"
							value="<c:out value='${profile.fullName}'/>" required><label
							class="form-label">Bio</label>
						<textarea class="form-control mb-3" name="bio"><c:out
								value="${profile.bio}" /></textarea>
						<label class="form-label">City</label><input
							class="form-control mb-3" name="city"
							value="<c:out value='${profile.city}'/>"><label
							class="form-label">Profile visibility</label><select
							class="form-select mb-3" name="privacy"><option
								${profile.privacy == 'PUBLIC' ? 'selected' : ''}>PUBLIC</option>
							<option ${profile.privacy == 'FRIENDS' ? 'selected' : ''}>FRIENDS</option>
							<option ${profile.privacy == 'PRIVATE' ? 'selected' : ''}>PRIVATE</option></select>
						<button class="btn btn-primary">Save profile</button>
					</form>
					<p class="text-muted mt-3">Email: ${profile.email}</p>
				</div>
			</div>
			<div class="col-lg-7">
				<h3>My posts</h3>
				<c:forEach items="${posts}" var="p">
					<div class="card p-3 mb-3">
						<small class="text-muted">${p.createdAt}</small>
						<p>
							<c:out value="${p.content}" />
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</main>
</body>
</html>