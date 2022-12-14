<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div
	class="d-flex justify-content-between bg-primary text-white rounded">
	<nav class="navbar navbar-expand-lg ">
		<a class="navbar-brand text-white" href="#">BLOG</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active text-white"
					href="<c:url value='/home' />">Home</a> <a
					class="nav-item nav-link text-white"
					href="<c:url value='/about' />">About</a> <a
					class="nav-item nav-link text-white"
					href="<c:url value='/contact' />">Contact</a>
			</div>
		</div>
	</nav>

	<security:authorize access="isAnonymous()">
		<div>
			<a type="button" class="btn btn-link text-white"
				href="<c:url value='/login' />">Login</a> <a type="button"
				class="btn btn-link text-white" href="<c:url value='/signup' />">SignUp</a>
		</div>
	</security:authorize>

	<security:authorize access="isAuthenticated()">
		<a type="button" class="btn btn-link text-white"
				href="<c:url value='/logout' />">Logout</a>
	</security:authorize>

</div>
