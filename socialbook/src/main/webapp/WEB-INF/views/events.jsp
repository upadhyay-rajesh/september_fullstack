<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Events</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<h2>Events</h2>
		<div class="card p-3 mb-4">
			<form method="post"
				action="${pageContext.request.contextPath}/events/create">
				<input class="form-control mb-2" name="title" required
					placeholder="Event title">
				<textarea class="form-control mb-2" name="description"
					placeholder="Details"></textarea>
				<label class="form-label">Date and time</label><input
					class="form-control mb-2" name="eventDate"
					placeholder="e.g. 2026-11-15 10:00 AM">
				<button class="btn btn-primary">Create event</button>
			</form>
		</div>
		<c:forEach items="${events}" var="e">
			<div class="card p-3 mb-3">
				<h5>${e.title}</h5>
				<p>${e.description}</p>
				<p class="text-muted">${e.eventDate}· Hosted by
					${e.creator.fullName}</p>
				<form method="post"
					action="${pageContext.request.contextPath}/events/${e.id}/rsvp">
					<button class="btn btn-outline-primary btn-sm">I'm
						interested / RSVP</button>
				</form>
			</div>
		</c:forEach>
	</main>
</body>
</html>