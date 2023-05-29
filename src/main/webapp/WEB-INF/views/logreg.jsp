<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WaterBnB</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<c:choose>
					<c:when test="${user != null}">
					<a href="/logout">logout</a>
					</c:when>
					<c:otherwise>
					<a href="/">home</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col">
				<p>Register</p>
				<form:form class="border p-3" method="post" action="/user/new"
					modelAttribute="newUser">
					<div class="form-group row mb-3">
						<form:label path="firstName" for="firstName"
							class="col-sm-2 col-form-label">Nombre</form:label>
						<div class="col-sm-10">
							<form:input path="firstName" type="text" class="form-control"
								id="firstName" />
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="lastName" for="lastName"
							class="col-sm-2 col-form-label">Apellido</form:label>
						<div class="col-sm-10">
							<form:input path="lastName" type="text" class="form-control"
								id="lastName" />
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="email" for="email"
							class="col-sm-2 col-form-label">email</form:label>
						<div class="col-sm-10">
							<form:input path="email" type="text" class="form-control"
								id="email" />
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="password" for="password"
							class="col-sm-2 col-form-label">password</form:label>
						<div class="col-sm-10">
							<form:input path="password" type="password" class="form-control"
								id="password" />
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="passwordConfirmation" for="passwordConfirmation"
							class="col-sm-2 col-form-label">password confirm</form:label>
						<div class="col-sm-10">
							<form:input path="passwordConfirmation" type="password"
								class="form-control" id="passwordConfirmation" />
						</div>
					</div>
					<div class="form-group row mb-3 justify-content-end">
						<div class="col-4">
							<form:select path="role" class="form-select">
								<form:option value="0">select</form:option>
								<form:option value="1">host</form:option>
							</form:select>
						</div>
					</div>
					<button class="btn btn-outline-primary">registrar</button>
				</form:form>
				<div>
					<form:errors path="newUser.*" class="text-danger" />
				</div>
			</div>
			<div class="col">
				<p>Login</p>
				<form:form class="border p-3" method="post" action="/login"
					modelAttribute="login">
					<div class="form-group row mb-3">
						<form:label path="email" for="email"
							class="col-sm-2 col-form-label">email</form:label>
						<div class="col-sm-10">
							<form:input path="email" type="email" class="form-control"
								id="logemail" />
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="password" for="password"
							class="col-sm-2 col-form-label">password</form:label>
						<div class="col-sm-10">
							<form:input path="password" type="password" class="form-control"
								id="logpassword" />
						</div>
					</div>
					<button class="btn btn-outline-primary">Ingresar</button>
				</form:form>
				<div>
					<form:errors path="login.*" class="text-danger" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>