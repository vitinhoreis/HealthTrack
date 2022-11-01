<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registre-se</title>
<%@ include file="_headerForm.jsp" %>
</head>
<body>
  <div class="page-wrapper p-t-30 p-b-100 font-robo">
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <div class="card-exercicio"></div>
                <div class="card-body">
                    <h2 class="title">Registre-se</h2>
                    <form action="usuario" method="POST" oninput='senha2.setCustomValidity(senha2.value != senha.value ? "As senhas não são iguais." : "")'>
                    <input type="hidden" value="cadastrar" name="acao">
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Nome" name="nome" required>
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Apelido" name="apelido">
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2 js-datepicker" type="text" placeholder="Data de Nascimento" name="dataNascimento" required>
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <select name="sexo" required>
                                            <option disabled="disabled" selected="selected">Sexo</option>
                                            <option value="0">Masculino</option>
                                            <option value="1">Feminino</option>
                                            <option value="2">Outro</option>
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
                                           data-mask-reverse="true">
                                </div>
                            </div> 
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="CPF" name="cpf" maxlength="14"  id="cpf" required
                                   data-mask="000.000.000-00"
                                   data-mask-reverse="true">
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="email" placeholder="Email" name="email" required>
                        </div>
                        <div class="input-group">
                            <input class="input--style-2" type="text" placeholder="Celular" required  maxlength="15"
                                   name="celular"
                                   id="celular"
                                   data-mask="00 00000-0000" 
                                   data-mask-reverse="true">
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="password" placeholder="Crie uma senha" name="senha" required>
                                </div>
                            </div>
                        </div>
                         <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="password" placeholder="Confirme a senha" name="senha2" required>
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