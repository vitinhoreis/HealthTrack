<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de Pressão Arterial</title>
<%@ include file="_headerForm.jsp" %>
</head>
<body>
  <div class="page-wrapper p-t-30 p-b-100 font-robo">
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <div class="card-pressao"></div>
                <div class="card-body">
                    <h2 class="title">Registro de Pressão Arterial</h2>
                    <form action="pressao" method="POST">
                    <input type="hidden" value="cadastrar" name="acao">
                       	<div class="input-group">
                           	<input class="input--style-2" type="number" placeholder="Sistólica" name="sistolica" required maxlength="3"
                           	data-mask="000"
                            data-mask-reverse="true">
                       	</div>
                       	<div class="input-group">
                           	<input class="input--style-2" type="number" placeholder="Diastólica" name="diastolica" required maxlength="3"
                           	data-mask="000"
                            data-mask-reverse="true">
                       	</div>
                       	<div class="input-group">
                           	<input class="input--style-2" type="text" placeholder="Classificação" name="classificacao" required>
                       	</div>
                       	<div class="row row-space">
                           	<div class="col-2">
                               	<div class="input-group">
                                   	<input class="input--style-2 js-datepicker" type="text" placeholder="Data do Registro" name="dataHoraMedicao">
                                   	<i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                               	</div>
                           	</div>
                       	</div>
                       	<div class="p-t-30">
                           	<button class="btn btn--radius btn--green" type="submit">Salvar</button>
                       	</div>
                   	</form>
                </div>
            </div>
        </div>
    </div>
<%@ include file="_footer.jsp" %>
</body>
</html>