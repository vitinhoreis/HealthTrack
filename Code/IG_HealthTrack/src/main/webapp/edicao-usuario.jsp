<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualização cadastro</title>
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
                    <h2 class="title">Atualização cadastro</h2>
                    <form action="usuario" method="POST" oninput='senha2.setCustomValidity(senha2.value != senha.value ? "As senhas não são iguais." : "")'>
                    		<input type="hidden" value="editar" name="acao">
                    		<input type="hidden" value="${usuario.codigo}" name="codigo">
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Nome" name="nome" value="${usuario.nome}" required>
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Apelido" name="apelido"  value="${usuario.apelido}" >
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2 js-datepicker" type="text" placeholder="Data de Nascimento" name="dataNascimento"  
                                    value='<fmt:formatDate value="${usuario.dataNascimento.time }" pattern="dd/MM/yyyy"/>'
                                     required>
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="sexo" required>
                                          <option value="0"
                                            ${usuario.sexo == 0 ? 'selected="true"' : ''}>Masculino</option>
                                            <option value="1"
                                            ${usuario.sexo == 1 ? 'selected="true"' : ''}>Feminino</option>
                                            <option value="2"
                                            ${usuario.sexo == 2 ? 'selected="true"' : ''}>Outro</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="text" placeholder="Altura em centímetros" name="altura" required maxlength="3"
                                           id="altura"
                                           data-mask="000"
                                           data-mask-reverse="true"
                                           value="${usuario.altura}" >
                                </div>
                            </div> 
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="CPF" name="cpf" maxlength="14"  id="cpf" required
                                   data-mask="000.000.000-00"
                                   data-mask-reverse="true"
                                   value="${usuario.cpf}" >
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="email" placeholder="Email" name="email" required  value="${usuario.email}">
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Celular" required  maxlength="15"
                                   name="celular"
                                   id="celular"
                                   data-mask="00 00000-0000" 
                                   data-mask-reverse="true"
                                   value="${usuario.celular}" >
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="password" placeholder="Crie uma senha" name="senha" required
                                     value="${usuario.senha}" >
                                </div>
                            </div>
                        </div>
                         <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="password" placeholder="Confirme a senha" name="senha2" required
                                     value="${usuario.senha}" >
                                </div>
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