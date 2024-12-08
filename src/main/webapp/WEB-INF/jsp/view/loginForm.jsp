<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">
<head>
<title>Login page</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style1.css">

</head>
<body>
<div class="main-login">
	<div class="left-login">
		<h1>login page</h1>
		<img src="${pageContext.request.contextPath}/resources/img/person-working.svg" class="left-login-image" alt="Pessoa trabalhando">
	</div>
	<div class="right-login">
		<div class="card-login">
			<h1>LOGIN</h1>
						<form
							action="${pageContext.request.contextPath}/authenticateTheUser"
							class="login-form" method="POST">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}">
							<!-- CSRF token -->

							<c:if test="${param.error!=null}">

								<c:choose>
									<c:when test="${param.error=='disabled'}">
										<div class="alert alert-danger col-12">Account Disabled</div>
									</c:when>
									<c:when test="${param.error=='locked'}">
										<div class="alert alert-danger col-12">Account Locked</div>
									</c:when>
									<c:when test="${param.error=='expired'}">
										<div class="alert alert-danger col-12">Account Expired</div>
									</c:when>

									<c:otherwise>
										<div class="alert alert-danger col-12">Please verify
											your login or password</div>
									</c:otherwise>
								</c:choose>
							</c:if>










							<c:if test="${param.logout != null}">

								<div class="alert alert-success col-12">You are logged out
									of the system</div>

							</c:if>
							<div class="textfield">

								<input name="username" type="text"
									 placeholder="Username"
									required>
							</div>
							<div class="textfield">
								<input name="password" type="password"
									 placeholder="Password"
									required>
							</div>

							<button type="submit" class="btn-login">Login</button>



						</form>
					</div>
				</div>
			</div>





</body>
</html>

