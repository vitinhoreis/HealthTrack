<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Histórico de registros de Peso</title>
<%@ include file="_headerForm.jsp" %>
</head>
<body>
<div class="dashboard">
<%@ include file="_header.jsp" %>
<%@ include file="_menu.jsp" %>
<div class='dashboard-app'>
        <header class='dashboard-toolbar'><a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a></header>
        <div class='dashboard-content'>
	   		<div class="container">
		
			<h1>Registros de Peso</h1>
			
			<table class="table table-striped">	
				<tr>
					<th>Código de registro</th>
					<th>Código usuário</th>
					<th>Peso</th>
					<th>Data de registro</th>
					<th></th>
				</tr>
				<c:forEach items="${peso}" var="ap">
					<tr>
						<td>${p.codigo}</td>
						<td>${p.codigoUsuario}</td>
						<td>${p.gramas}</td>
						<td>
							<fmt:formatDate value="${p.dataMedicao}" pattern="dd/mm/yyyy" />
						</td>
						<td>
							<c:url value="pressao" var="link">
								<c:param name="acao" value="abrir-form-edicao"/>
								<c:param name="codigo" value="${p.codigo}"/>
							</c:url>	
							<a href="${link}">Editar</a>
							<button type="button"
							class="btn btn-danger btn-xs"
							data-toggle="modal"
							data-target="#excluirModal"
							onclick="codigoExcluir.value =${p.codigo}">
								Excluir
							</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		
			</div>
        </div>
    </div>

</div>
<%@ include file="_footer.jsp" %>
<!-- Modal -->
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog"
aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
				<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				Deseja realmente excluir?
			</div>
			<div class="modal-footer">
				<form action="peso" method="post">
					<input type="hidden" name="acao" value="excluir">
					<input type="hidden" name="codigo" value="codigoExcluir">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-danger">Excluir</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>