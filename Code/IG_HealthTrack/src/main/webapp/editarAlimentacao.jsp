<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Alimentação</title>
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
         
                    <form method="POST">
                    <input type="hidden" value="atualizar" name="acao">
                    <input type="hidden" value="${id}" name="id">
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="${al.descricao}" name="name">
                        </div>
                        <div class="row row-space">
                            
                            <div class="col-2">
                                
                            </div>
                        </div>
                    	<div class="input-group">
                            <input class="input--style-2" type="text" placeholder="${al.gramas}" name="peso">
                        </div>
                        <div class="row row-space">
                            
                            <div class="col-2">
                                
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="text" placeholder="${al.calorias}" name="caloria">
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
                    <form method="POST">
                    <input type="hidden" value="apagar" name="acao">
                    <input type="hidden" value="${id}" name="id">
                    	<div class="p-t-30">
                            <button class="btn btn--radius btn--green" type="submit">Apagar</button>
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