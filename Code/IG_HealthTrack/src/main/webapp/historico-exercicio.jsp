<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historico de Atividades</title>
<%@ include file="_headerForm.jsp" %>
<link href="resources/css/personalizado.css" rel="stylesheet" media="all">
</head>
<body>
<div class="dashboard">
<%@ include file="_menu.jsp" %>
<div class='dashboard-app'>
        <header class='dashboard-toolbar'><a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a></header>
        <div class='dashboard-content'>
            <div class='container'>
<div class="page-wrapper p-t-30 p-b-100 font-robo">
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <div class="card-exercicio"></div>
                <div class="card-body">
                    <h2 class="title">Historico de Atividades</h2>
                    <form action="/IG_HealthTrack/atividade" method="POST">
	                    <div class="card">
	                        <ul class="list-group">
		                        <c:forEach items="${atividade}" var="a">
		                        	<li class="list-group-item">
									    <div class="d-flex w-100 justify-content-between">
									    <h5 class="mb-1">${a.descricao}</h5>
									    <p class="mb-1">${a.quilometragem }</p>
									    <small>Inicio: <fmt:formatDate value="${a.dataHoraInicio.time}" pattern="dd-MM-yyyy HH:mm:ss" />  Fim: <fmt:formatDate value="${a.dataHoraFim.time}" pattern="dd-MM-yyyy HH:mm:ss" /> </small>
									    </div>
									    <input type="hidden" value="editar" name="acao">
									    <input type="hidden" value="${a.codigo}" name="id">
									    <button class="btn btn--radius btn--green" type="submit">Editar</button>
								  	</li>
		                        </c:forEach>
							</ul>
						</div>
                    </form>
                </div>
            </div>
        </div>
    </div>

   </div>
        </div>
    </div>

</div>
<%@ include file="_footer.jsp" %>
</body>
</html>