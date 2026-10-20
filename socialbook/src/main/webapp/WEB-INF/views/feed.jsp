<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Feed | SocialBook</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/style.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<div class="row g-4">
			<aside class="col-lg-3">
				<div class="card p-3">
					<h5>${me.fullName}</h5>
					<p class="text-muted mb-1">${me.city}</p>
					<p>${me.bio}</p>
					<a href="${pageContext.request.contextPath}/profile">Edit
						profile</a>
					<hr>
					<form method="get"
						action="${pageContext.request.contextPath}/search/posts">
						<label class="form-label">Search posts</label><input name="q"
							class="form-control mb-2" placeholder="Search text">
						<button class="btn btn-outline-primary w-100">Search</button>
					</form>
				</div>
			</aside>
			<section class="col-lg-6">
				<c:if test="${not empty error}">
					<div class="alert alert-danger">${error}</div>
				</c:if>
				<div class="card p-3 mb-4">
					<h5>What's on your mind?</h5>
					<form method="post"
						action="${pageContext.request.contextPath}/posts/create">
						<textarea class="form-control mb-2" name="content" rows="3"
							required maxlength="4000" placeholder="Share an update..."></textarea>
						<input class="form-control mb-2" name="imageUrl"
							placeholder="Optional image URL">
						<div class="d-flex gap-2">
							<select class="form-select" name="visibility"><option>PUBLIC</option>
								<option>FRIENDS</option>
								<option>PRIVATE</option></select>
							<button class="btn btn-primary">Publish</button>
						</div>
					</form>
				</div>
				<c:forEach items="${posts}" var="p">
					<div class="card p-3 mb-3">
						<div class="d-flex justify-content-between">
							<strong>${p.author.fullName}</strong><small class="text-muted">${p.createdAt}</small>
						</div>
						<p class="mt-3 post-content">
							<c:out value="${p.content}" />
						</p>
						<c:if test="${not empty p.imageUrl}">
							<p>
								<a href="<c:out value='${p.imageUrl}'/>" target="_blank"
									rel="noopener">Open attached image</a>
							</p>
						</c:if>
						<div class="d-flex gap-2 flex-wrap">
							<form method="post"
								action="${pageContext.request.contextPath}/posts/${p.id}/like">
								<button class="btn btn-sm btn-outline-primary">Like /
									Unlike</button>
							</form>
							<form method="post"
								action="${pageContext.request.contextPath}/posts/${p.id}/save">
								<button class="btn btn-sm btn-outline-secondary">Save</button>
							</form>
							<c:if test="${p.author.id == me.id}">
								<form method="post"
									action="${pageContext.request.contextPath}/posts/${p.id}/delete">
									<button class="btn btn-sm btn-outline-danger">Delete</button>
								</form>
							</c:if>
						</div>
						<form method="post"
							action="${pageContext.request.contextPath}/posts/${p.id}/comment"
							class="mt-3">
							<div class="input-group">
								<input class="form-control" name="content"
									placeholder="Write a comment" required maxlength="2000">
								<button class="btn btn-outline-primary">Comment</button>
							</div>
						</form>
						<form method="post"
							action="${pageContext.request.contextPath}/posts/${p.id}/report"
							class="mt-2">
							<div class="input-group">
								<input class="form-control form-control-sm" name="reason"
									placeholder="Report reason (optional)">
								<button class="btn btn-sm btn-outline-warning">Report</button>
							</div>
						</form>
					</div>
				</c:forEach>
			</section>
			<aside class="col-lg-3">
				<div class="card p-3">
					<h5>Discover people</h5>
					<c:forEach items="${users}" var="u">
						<c:if test="${u.id != me.id}">
							<p class="mb-2">
								<strong>${u.fullName}</strong><br>
								<small>${u.city}</small>
							</p>
						</c:if>
					</c:forEach>
					<a href="${pageContext.request.contextPath}/users/search">Find
						people</a>
				</div>
			</aside>
		</div>
	</main>
</body>
</html>
