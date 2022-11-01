<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alimentação</title>
<%@ include file="_headerForm.jsp" %>
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
                <div class="card-food"></div>
                <div class="card-body">
                    <h2 class="title">Alimentação</h2>
                    	<c:forEach items="${alimentacao}" var="a">
                    		<form action="/IG_HealthTrack/alimentacao" method="POST">
	                    		
	                    		<input type="hidden" value="editar" name="acao">
	                    		<input type="hidden" value="${a.codigo}" name="id">
			                        <li class="list-group-item">
										<div class="d-flex w-100 justify-content-between">
										    <h3 class="mb-1">${a.descricao}</h3>
										    <fmt:formatDate value="${a.dataHora.time}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
										    <small>Calorias: ${a.calorias} Gramas: ${a.gramas}</small>
										    </div>
										    <button class="btn btn--radius btn--green" value="editarAlimentacao.jsp" type="submit">Editar</button>
									  	</li>
								
							</form>
		               </c:forEach>
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