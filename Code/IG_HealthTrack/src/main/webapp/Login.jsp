<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="_headerForm.jsp" %>

</head>
<body>
     <div class="page-wrapper p-t-30 p-b-100 font-robo">
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <div class="card-exercicio"></div>
                <div class="card-body">
                    <h2 class="title">Entrar</h2>
                    <form action="usuario" method="POST">
                      	<input type="hidden" value="login" name="acao">
                        <div class="input-group">
                            <input class="input--style-2" type="email" placeholder="Email" name="email">
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <input class="input--style-2" type="password" placeholder="Senha" name="senha">
                                </div>
                            </div>
                        </div>
                        <div class="p-t-30">
                        <button class="btn btn--radius btn--green" type="submit">Entrar</button>
                       </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

  <%@ include file="_footer.jsp" %>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>