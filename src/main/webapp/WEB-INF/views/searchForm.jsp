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
						<a href="/" class="text-dark">Home</a> |
						<a href="/logout" class="text-dark">logout</a>
					</c:when>
					<c:otherwise>
						<a href="/" class="text-dark">Home</a> |
						<a href="/guest/signin" class="text-dark">Sign in/Sign up</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form method="post" action="/search">
					<div class="form-group row mb-3">
					<label>find your pool!</label>
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
		<div class="row">
			<div class="col">
				<table class="table table-hover border">
					<thead>
						<tr>
							<th>Address</th>
							<th>Pool Size</th>
							<th>Cost per night</th>
							<th>Details</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${piscinas}" var="piscina">
							<tr>
								<td><c:out value="${piscina.address}"></c:out></td>
								<td><c:out value="${piscina.poolSize}"></c:out></td>
								<td><c:out value="${piscina.cost}"></c:out></td>
								<td><a href="/pools/${piscina.id}"><c:out value="${piscina.rating}"></c:out>/5 - See more</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>