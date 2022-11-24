<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Login</title>
<body>
	<div class="main-body py-5">
		<h4>LOGIN</h4>
		<p>Please fill out the following form with your login credentials:</p>

		<c:if test="${param.incorrectAccount != null}">
			<div class="alert alert-danger">Username or password incorrect
			</div>
		</c:if>
		<c:if test="${param.accessDenied != null}">
			<div class="alert alert-danger">you Not authorize</div>
		</c:if>

		<form action="j_spring_security_check" method="POST">
			<div class="form-group">
				<label for="textImput">Username</label> <input type="text"
					class="form-control" id="textImput" name="j_username" />
			</div>
			<div class="form-group">
				<label for="passInput">Password</label> <input type="password"
					class="form-control" id="passInput" placeholder="Password"
					name="j_password" />
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1" />
				<label class="form-check-label" for="exampleCheck1">Remember
					me next time</label>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
