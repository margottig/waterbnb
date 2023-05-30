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
<title>Dashboard</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-between">
			<div class="col-2">
				<p>current listings</p>
			</div>
			<div class="col-2">
				<a href="/search" class="text-dark">search</a> |
				<a href="/logout" class="text-dark">logout</a>
			</div>
		</div>
		<div class="row">
			<div class="col-11">
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
					<c:forEach items="${user.piscinas}" var="piscina">
						<tr>
							<td><c:out value="${piscina.address}"></c:out></td>
							<td><c:out value="${piscina.poolSize}"></c:out></td>
							<td>$<c:out value="${piscina.cost}"></c:out></td>
							<td><a href=""><c:out value="${piscina.rating}"></c:out>/5 - edit</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<p>New listing</p>
			<div class="col-6">
				<form:form class="border p-4" method="post" action="/new/pool"
					modelAttribute="newPool">
					<input name="owner" value="${user.id}" type="hidden"/>
					<div class="form-group row mb-3">
						<form:label path="address" for="address"
							class="col-sm-2 col-form-label">address</form:label>
						<div class="col-sm-10">
							<form:input path="address" type="text" class="form-control"
								id="firstName" />
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="description" for="description"
							class="col-sm-2 col-form-label">description</form:label>
						<div class="col-sm-10">
							<form:textarea path="description" type="text" class="form-control"
								id="description" />
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="cost" for="cost" class="col-sm-8 col-form-label">cost per night</form:label>
						<div class="col-sm-4">
							<form:input path="cost" type="number" class="form-control"
								id="cost" />
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="poolSize" for="poolSize"
							class="col-sm-8 col-form-label">Pool size</form:label>
						<div class="col-sm-4">
							<form:select path="poolSize" class="form-select">
								<form:option value="small">Small</form:option>
								<form:option value="medium">Medium</form:option>
								<form:option value="large">Large</form:option>
							</form:select>
						</div>
					</div>
					<div class="form-group row justify-content-end">
						<div class="col-2">
							<button type="submit" class="btn btn-outline-primary">submit</button>
						</div>
					</div>
				</form:form>
				<div>
					<form:errors path="newPool.*" class="text-danger" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>