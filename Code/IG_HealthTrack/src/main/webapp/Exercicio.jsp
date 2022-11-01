<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registre Exercicio</title>
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
                <div class="card-exercicio"></div>
                <div class="card-body">
                    <h2 class="title">Exerc�cio</h2>
                    <form action="atividade" method="POST">
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Nome do exerc�cio" name="name">
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Quilometragem" name="quilometragem">
                        </div>
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="dificuldade" id="dificuldade">
                                    <option disabled="disabled" selected="selected">N�vel de dificuldade</option>
                                    <option>F�cil</option>
                                    <option>Moderado</option>
                                    <option>Dif�cil</option>
                                    <option>Muito dif�cil</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                            </div>
                        </div>
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                               <select name="tipo" id="tipo">
                                    <option disabled="disabled" selected="selected">Tipo de Exercicio</option>
                                    <option>Yoga</option>
                                    <option>Aer�bica</option>
                                    <option>Nata��o</option>
                                    <option>Corrida</option>
                                    <option>Caminhada</option>
                                    <option>Muscula��o</option>
                                    <option>Pedalada</option>
                                </select>
								
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                            </div>
                        </div>
                        <input type="hidden" value="cadastrar" name="acao">
                        <div class="p-t-30">
                            <button class="btn btn--radius btn--green" type="submit">Enviar</button>
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