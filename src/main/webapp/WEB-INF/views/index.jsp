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
			<div class="col text-end">
				<c:choose>
					<c:when test="${user!=null}">
						<a href="/logout" class="text-dark">logout</a>
					</c:when>
					<c:otherwise>
						<a href="/guest/signin" class="text-dark">Sign in/Sign up</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-4 text-center">
				<h6>Find places to swim and sleep on water bnb</h6>
				<form method="post" action="/search">
					<div class="form-group row mb-3">
						<div class="col-sm-10">
							<input type="text" class="form-control" id="address"
								name="address" />
						</div>
						<div class="col-sm-2">
							<button class="btn btn-outline-primary">Buscar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>