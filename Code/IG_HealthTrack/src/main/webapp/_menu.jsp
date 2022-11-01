<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>Insert title here</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css'>
      <link rel="stylesheet" href="resources/css/menu.css">
   </head>
   <body>
      <div class='dashboard'>
         <div class="dashboard-nav">
            <header><a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a><a href="#"
               class="brand-logo"><i class="fas fa-h-square"></i> <span>Health Track</span></a></header>
            <nav class="dashboard-nav-list">
               <a href="dashboard.jsp" class="dashboard-nav-item"><i class="fas fa-home"></i>
               Home </a><a
                  href="Peso.jsp" class="dashboard-nav-item"><i class="fas fa-weight"></i> Peso
               </a><a
                  href="cadastro-pressao.jsp" class="dashboard-nav-item"><i class="fas fa-file-medical-alt"></i> Pressão Arterial</a>
               <a href="Exercicio.jsp" class="dashboard-nav-item"><i class="fas fa-running"></i> Exercício </a>
               <a
                  href="Alimentacao.jsp" class="dashboard-nav-item"><i class="fas fa-utensils"></i> Alimentação
               </a>
          <div class='dashboard-nav-dropdown'><a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i class="fas fa-history"></i>
           Histórico </a>
                <div class='dashboard-nav-dropdown-menu'><a
                        href="/IG_HealthTrack/alimentacao" class="dashboard-nav-dropdown-item">Alimentação</a><a
                        href="/IG_HealthTrack/atividade" class="dashboard-nav-dropdown-item">Atividades</a><a
                        href="/IG_HealthTrack/pressaolistar" class="dashboard-nav-dropdown-item">Pressão Arterial</a></div>
            </div>
               		    <c:url value="usuario" var="link">
							<c:param name="codigo" value="4"/>
						</c:url>
               <a
                  href="${link}" class="dashboard-nav-item"><i class="fas fa-user"></i> Perfil </a>
               <div class="nav-item-divider"></div>
               <a
                  href="Index.jsp" class="dashboard-nav-item"><i class="fas fa-sign-out-alt"></i> Logout </a>
            </nav>
         </div>
      </div>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js'></script><script  src="resources/js/menu.js"></script>
   </body>
</html>