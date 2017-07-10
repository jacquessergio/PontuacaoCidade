<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Pontuação Cidade</title>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/lib_front/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/lib_front/css/bootstrap-theme.min.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/lib_front/css/main.css">
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/lib_front/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/lib_front/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/lib_front/js/main.js"></script>
</head>

<body>

	<div id="blk_1_home">
	<div class="well">
		<sf:form modelAttribute="regiao" class="form-inline" action="Lista" method="POST">
			
			<p class="bg-danger">
				<sf:errors path="Nome" cssClass="erro" />
			</p>

			<div class="form-group">
				<label for="Nome">Cidade: </label> 
				<sf:input path="Nome" class="form-control" placeholder="Ex. Barueri" />
			</div>
			<div class="form-group">
				<label for="Estado">Estado: </label> 					
				<sf:input path="Estado" class="form-control" placeholder="Ex. São Paulo" />
			</div>
			<button type="submit"  class="btn btn-default">Buscar</button>
		</sf:form>
	</div>

		<table class="table table-bordered">
			<thead>
				<tr class="active">
					<th>Estado</th>
					<th>Cidade</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="getLista" items="${setLista}">
				<tr>
					<td>${getLista.estado}</td>
					<td>${getLista.nome}</td>
					<td><a href="javascript:getPontuacao('${getLista.nome}', '${getLista.estado}')"> Ver Pontuação</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
