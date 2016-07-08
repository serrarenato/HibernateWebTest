<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Clientes Lista</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Lista de Clientes </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Primeiro Nome</th>
				        <th>Ultimo Nome</th>
				        <th>Email</th>
				        <th>Nascimento</th>
				        <th>Email</th>
				        <th></th>
				        <th width="100"></th>
				        <th width="100"></th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>${customer.dateBorn}</td>
						<td>${customer.email}</td>
						<td><a href="<c:url value='/edit-customer-${customer.id}' />" class="btn btn-success custom-width">editar</a></td>
						<td><a href="<c:url value='/delete-customer-${customer.id}' />" class="btn btn-danger custom-width">apagar</a></td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/new-customer' />">Novo Cliente</a>
	 	</div>
   	</div>
</body>
</html>