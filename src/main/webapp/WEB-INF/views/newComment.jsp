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
				<h1>review of ${piscina.address}</h1>
				<div>
					<form:errors path="newComment.*" class="text-danger" />
				</div>
				<form:form action="/new/comment/${piscina.id}" method="post"
					modelAttribute="newComment">
					<div class="form-group row mb-3">
						<form:label path="comentario" for="comentario"
							class="col-sm-2 col-form-label">leave a comment</form:label>
						<div class="col-sm-10">
							<form:textarea path="comentario" class="form-control"/>
						</div>
					</div>
					<div class="form-group row mb-3">
						<form:label path="rating" for="rating"
							class="col-sm-2 col-form-label">rating</form:label>
						<div class="col-sm-10">
							<form:select path="rating" class="form-select">
								<form:option value="0">select</form:option>
								<form:option value="1">1</form:option>
								<form:option value="2">2</form:option>
								<form:option value="3">3</form:option>
								<form:option value="4">4</form:option>
								<form:option value="5">5</form:option>
							</form:select>
						</div>
					</div>
					<button class="btn btn-primary" type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>