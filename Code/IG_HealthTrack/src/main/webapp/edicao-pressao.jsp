<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualização de registro de Pressão Arterial</title>
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
                <div class="card-pressao"></div>
                <div class="card-body">
                    <h2 class="title">Atualização de registro de Pressão Arterial</h2>
                    <form action="pressao" method="POST">
                    		<input type="hidden" value="editar" name="acao">
                    		<input type="hidden" value="${pressao.codigo}" name="codigo">
                                                  
                            <div class="input-group">
                                <input class="input--style-2" type="text" placeholder="Sistólica" name="sistolica" required maxlength="3"                               
                                       data-mask="000"
                                       data-mask-reverse="true"
                                       value="${pressao.sistolica}" >
                            </div>                    
                            <div class="input-group">
                                <input class="input--style-2" type="text" placeholder="Diastólica" name="diastolica" required maxlength="3"                               
                                        data-mask="000"
                                        data-mask-reverse="true"
                                        value="${pressao.diastolica}" >
                            </div>
                            <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="text" placeholder="Classificação" name="classificacao" required
                                     value="${pressao.classificacao}" >
                                </div>
                            </div>
                        	</div>                         
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2 js-datepicker" type="text" placeholder="Data de Nascimento" name="dataNascimento"  
                                    value='<fmt:formatDate value="${pressao.dataHoraMedicao.time }" pattern="dd/MM/yyyy"/>'
                                     required>
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                </div>
                            </div>
                                           
                        <div class="p-t-30">
                             <a href="#" class="btn btn--radius btn--green">Cancelar</a>
                            <button class="btn btn--radius btn--green" type="submit">Salvar</button>
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