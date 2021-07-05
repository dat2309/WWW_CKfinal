<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new product</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">

		<h3>Product Directory</h3>
		<hr>

		<p class="h4 mb-4">Save Product</p>

		<form:form method="post" modelAttribute="product">
			<form:input type="hidden" path="id" />

			<tr>
				<td><form:input style="margin-top: 1em" class="form-control col-sm-4" type="text"
						path="name" placeholder="Name" /></td>
			</tr>
			<tr>
				<td><form:input style="margin-top: 1em" class="form-control col-sm-4" type="text"
						path="price" placeholder="Price" /></td>
			</tr>
			<tr>
				<td><form:input style="margin-top: 1em" class="form-control col-sm-4" type="text"
						path="description" placeholder="Description" /></td>
			</tr>

			<button style="margin-top: 1em" type="submit" class="btn btn-info col-2">Save</button>
		</form:form>
		
		<hr/>
		<a href="<c:url value='/'/>">Back to Product List</a>

	</div>
</body>
</html>