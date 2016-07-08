<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Clientes</title>
<link href="<c:url value='/static/css/bootstrap.css' />" 	rel="stylesheet"></link>
<style>
	.has-error{
		color:red;
	}
	.btnPos{
		margin-right: 30px;
		float: right;		
	}
</style>
</head>


<body>
	<div class="container">
		<div class="well col-md-7">
			<div class="row">
				<h1>Cadastro de Clientes</h1>

				<form:form method="POST" modelAttribute="customer"
					class="form-horizontal">

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="firstName">Primeiro
								nome</label>
							<div class="col-md-7">
								<form:input type="text" path="firstName" id="firstName"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="firstName" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="lastName">Ultimo
								nome</label>
							<div class="col-md-7">
								<form:input type="text" path="lastName" id="lastName"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="lastName" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="sex">Sexo</label>
							<div class="col-md-7" class="form-control input-sm">
								<form:radiobutton path="sex" value="M" />
								Masculino
								<form:radiobutton path="sex" value="F" />
								Feminino
								<div class="has-error">
									<form:errors path="sex" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="dateBorn">Date
								de Nascimento</label>
							<div class="col-md-7">
								<form:input type="text" path="dateBorn" id="dateBorn"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="dateBorn" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="email">Email</label>
							<div class="col-md-7">
								<form:input type="text" path="email" id="email"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="email" class="help-inline" />
								</div>
							</div>
						</div>
					</div>



					<div class="row">					
					
						<div class="form-actions btnPos">
							<input type="submit" value="Enviar" class="btn btn-warning">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>