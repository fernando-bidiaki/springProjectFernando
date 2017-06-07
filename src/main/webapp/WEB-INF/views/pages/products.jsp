<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Form</title>
</head>
<body>
	<form:form modelAttribute="product"
		action="${pageContext.request.contextPath}/product" method="POST">
		<div>
			<label>Product Name:</label>
			<form:input path="productName" id="productName" type="text" />

		</div>

		<div>
			<label>Product Price</label>
			<form:input path="productPrice" id="productPrice" type="text" />
		</div>

		<div>
			<button type="submit">Save</button>
		</div>
	</form:form>

	<h2>List of Products</h2>
	<table>
		<tr>
			<td>Product Name</td>
			<td>Price</td>
		</tr>

		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.productName}</td>
				<td>${product.productPrice}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>