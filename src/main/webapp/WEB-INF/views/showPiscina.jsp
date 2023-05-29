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
<title>inserta un título aquí</title>

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
						<a href="/search" class="text-dark">Volver atrás</a> |
						<a href="/logout" class="text-dark">logout</a>
					</c:when>
					<c:otherwise>
						<a href="/search" class="text-dark">Volver atrás</a> |
						<a href="/guest/signin" class="text-dark">Sign in/Sign up</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p><c:out value="${piscina.address}"></c:out></p>
				<p><c:out value="${piscina.description}"></c:out></p>
				
			</div>
			<div class="col">
				<p>email: <c:out value="${piscina.owner.email}"></c:out></p>
				<p>name: <c:out value="${piscina.owner.firstName} ${piscina.owner.lastName}"></c:out></p>
				<p>pool size: <c:out value="${piscina.poolSize}"></c:out></p>
				<p>cost: $<c:out value="${piscina.cost}"></c:out></p>
			</div>
		</div>
	</div>
</body>
</html>