<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	
	<a href="${pageContext.request.contextPath}/user?myLocale=pt_BR">Portuguese</a>
	<a href="${pageContext.request.contextPath}/user?myLocale=en_US">English</a>
	
	
	<c:choose>
		<c:when test="${user.id>0}">
			<c:set var="formMethod" value="PUT"></c:set>
			<c:url var="formAction" value="/user/${user.id}"></c:url>
		</c:when>

		<c:otherwise>
			<c:set var="formMethod" value="POST"></c:set>
			<c:url var="formAction" value="/user"></c:url>
		</c:otherwise>
	</c:choose>

	<div class="container">
		<form:form modelAttribute="user" action="${formAction}"
			method="${formMethod}">
			<div class="col-xs-5">
				<div class="form-group row">
					<label><spring:message code="user.firstName"/></label>
					<form:input class="form-control " path="firstName" id="firstName"
						type="text" />
				</div>

				<div class="form-group row">
					<label><spring:message code="user.lastName"/></label>
					<form:input class="form-control" path="lastName" id="lastName"
						type="text" />
				</div>

				<div class="form-group row">
					<label><spring:message code="user.cpf"/></label>
					<form:input class="form-control" path="cpf" id="cpf" type="text" />
				</div>

				<div class="form-group row">
					<button class="btn btn-primary" type="submit">
						<i class="fa fa-floppy-o" aria-hidden="true"></i> Save
					</button>
				</div>
		</form:form>

		<h1>List of User</h1>
		
		<form class="form-inline" action="${pageContext.request.contextPath}/user/find-by">
			<div class="input-group"> 
				<input type ="text" class = "form-control" name="firstName" 
				placeholder="First Name"/>
			</div>
			
			<div class="input-group"> 
				<input type ="text" class = "form-control" name="lastName" 
				placeholder="Last Name"/>
			</div>
			
			<div class="input-group"> 
				<input type ="text" class = "form-control" name="cpf" 
				placeholder="Cpf"/>
			</div>
			<button type="submit" class="btn btn-primary">Pesquisar</button>
		</form>
		
		<table class="table table-hover table-bordered">
			<tr>
				<td>Last Name</td>
				<td>First Name</td>
				<td>CPF</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>

			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.lastName}</td>
					<td>${user.firstName}</td>
					<td>${user.cpf}</td>
					<td><a href="${pageContext.request.contextPath}/user/${user.id}">Edit</a></td>
					<td>
						<a href="#myModal_${user.id}" role="button" class="btn btn-danger" data-toggle="modal">Delete <i class="fa fa-trash-o"> </i></a>
					</td>
				</tr>
				
				<div id="myModal_${user.id}" class="modal fade">
					<div class="modal-dialog"> 
						<div class="modal-header">
							<h3 class="modal-title">Confirm Delete</h3>						
						</div>
						<div class="modal-body">
							<button class ="btn btn-default">Close</button>
							<a href="${pageContext.request.contextPath}/user/delete/${user.id} class="btn btn-danger"> Delete</a>
						</div>
					</div>
				</div>
				
			</c:forEach>
		</table>
</body>
</html>