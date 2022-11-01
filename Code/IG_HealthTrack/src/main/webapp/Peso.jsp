<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Peso</title>
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
                <div class="card-pesando"></div>
                <div class="card-body">
                    <h2 class="title">Registro de Peso</h2>
                     <form action="peso" method="POST">
                     <input type="hidden" value="cadastrar" name="acao">
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Peso" name="peso">
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2 js-datepicker" type="text" placeholder="Data de Registro" name="dataHoraMedicao">
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                </div>
                            </div>
                        </div>
                        <div class="p-t-30">
                            <button class="btn btn--radius btn--green" type="submit">Registrar</button>
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