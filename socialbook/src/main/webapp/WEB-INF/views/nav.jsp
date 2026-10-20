<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
	<div class="container">
		<a class="navbar-brand fw-bold"
			href="${pageContext.request.contextPath}/feed">SocialBook</a>
		<div class="navbar-nav flex-row flex-wrap gap-3">
			<a class="nav-link text-white"
				href="${pageContext.request.contextPath}/feed">Feed</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/profile">Profile</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/users/search">People</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/friends">Friends</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/messages">Messages</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/notifications">Notifications</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/saved">Saved</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/groups">Groups</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/events">Events</a><a
				class="nav-link text-white"
				href="${pageContext.request.contextPath}/logout">Logout</a>
		</div>
	</div>
</nav>
