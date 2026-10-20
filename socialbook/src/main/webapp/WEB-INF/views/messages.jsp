<%@ include file="common.jsp"%><!doctype html>
<html>
<head>
<title>Messages</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body><%@ include file="nav.jsp"%><main
		class="container">
		<h2>Messages</h2>
		<div class="card p-3 mb-4">
			<h5>Send a message</h5>
			<form method="post"
				action="${pageContext.request.contextPath}/messages/send">
				<label class="form-label">Recipient</label><select
					class="form-select mb-2" name="recipientId" required><c:forEach
						items="${users}" var="u">
						<option value="${u.id}">${u.fullName}(${u.email})</option>
					</c:forEach></select>
				<textarea class="form-control mb-2" name="content" required
					maxlength="3000" placeholder="Your message"></textarea>
				<button class="btn btn-primary">Send</button>
			</form>
		</div>
		<h4>Inbox / Conversation</h4>
		<c:forEach items="${messages}" var="m">
			<div class="card p-3 mb-2">
				<strong>${m.sender.fullName} → ${m.recipient.fullName}</strong>
				<p class="mb-1">
					<c:out value="${m.content}" />
				</p>
				<small>${m.sentAt}</small><a
					href="${pageContext.request.contextPath}/messages/conversation?userId=${m.sender.id}">Open
					conversation with sender</a>
			</div>
		</c:forEach>
	</main>
</body>
</html>