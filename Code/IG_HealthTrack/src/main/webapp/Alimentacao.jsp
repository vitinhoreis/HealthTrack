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
                    <form action="/IG_HealthTrack/alimentacao" method="POST">
                    <input type="hidden" value="cadastrar" name="acao">
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Nome do alimento" name="name">
                        </div>
                        <div class="row row-space">
                            
                            <div class="col-2">
                                
                            </div>
                        </div>
                    <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Peso" name="peso">
                        </div>
                        <div class="row row-space">
                            
                            <div class="col-2">
                                
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="text" placeholder="Calorias" name="caloria">
                                </div>
                            </div>
                        </div>
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="tipo" id="tipo">
                                    <option disabled="disabled" selected="selected">Tipo de Refeição</option>
                                    <option>Café da manhã</option>
                                    <option>Brunch</option>
                                    <option>Almoço</option>
                                    <option>Lanche</option>
                                    <option>Jantar</option>
                                    <option>Sobremesa</option>
                                    <option>Ceia</option>
                                    <option>Pré-treino</option>
                                    <option>Pós-treino</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
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