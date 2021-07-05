<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All product</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
</head>
<body>
	<div class="container" style="margin-top: 2em">
		<h3>Product Directory</h3>
		<hr>
		<!-- Add a button -->
		<a href="<c:url value='/showFormForAdd'/>"
			class="btn btn-primary btn-sm mb-3"> Add Product </a>
		<div class="col-sm-10">
			<div class="row">
				<table class="table table-bordered table-striped">
					<thead class="table-dark">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Price</th>
							<th>Description</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listProduct}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.name}</td>
								<td>${item.price}</td>
								<td>${item.description}</td>
								<td><a href="<c:url value='/showFormForUpdate/${item.id}'/>"
									class="btn btn-info btn-sm"> Update </a> <a
									href="<c:url value='/delete/${item.id}'/>"
									class="btn btn-danger btn-sm"
									onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">
										Delete </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>