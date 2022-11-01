<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>Dashboard</title>
      <%@ include file="_header.jsp" %>
   </head>
   <body>
      <div class="dashboard">
         <%@ include file="_menu.jsp" %>
         <div class='dashboard-app'>
            <header class='dashboard-toolbar'>
            <div class="container">
             <div class="row">
                  <div class="col">
                     <a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a>                        
                  </div>
                  <div class="col col-lg-2">
                     <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow  align-items-end">
                        <ul class="navbar-nav ml-auto">
                           <!-- Nav Item - User Information -->
                           <li class="nav-item dropdown no-arrow">
                              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                 data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <span class="mr-2 d-none d-lg-inline text-gray-600 small"><c:out value="${sessionScope.nomeUsuario}" /></span>
                              <img class="img-profile rounded-circle"
                                 src="resources/images/undraw_profile.svg">
                              </a>
                           </li>
                        </ul>
                     </nav>
                  </div>
               </div>
            </div>
            </header>
            <div class='dashboard-content'>
               <div class='container'>
                  <div class="row">
                     <!-- Earnings (Monthly) Card Example -->
                     <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-primary shadow h-100 py-2">
                           <div class="card-body">
                              <div class="row no-gutters align-items-center">
                                 <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                       Último Peso
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">82.5 kg</div>
                                 </div>
                                 <div class="col-auto">
                                    <i class="fas fa-weight fa-2x text-gray-300"></i>  
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                     <!-- Earnings (Monthly) Card Example -->
                     <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-success shadow h-100 py-2">
                           <div class="card-body">
                              <div class="row no-gutters align-items-center">
                                 <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                       IMC
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">24.9 Normal</div>
                                 </div>
                                 <div class="col-auto">
                                    <i class="fas fa-heartbeat fa-2x text-gray-300"></i>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                     <!-- Earnings (Monthly) Card Example -->
                     <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-info shadow h-100 py-2">
                           <div class="card-body">
                              <div class="row no-gutters align-items-center">
                                 <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                       Última Pressão
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">120/180</div>
                                 </div>
                                 <div class="col-auto">
                                    <i class="fas fa-file-medical-alt fa-2x text-gray-300"></i>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                     <!-- Pending Requests Card Example -->
                     <div class="col-xl-3 col-md-6 mb-4">
                        <div class="card border-left-warning shadow h-100 py-2">
                           <div class="card-body">
                              <div class="row no-gutters align-items-center">
                                 <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                       Última Refeição
                                    </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">Almoço - 17:00</div>
                                 </div>
                                 <div class="col-auto">
                                    <i class="fas fa-utensils fa-2x text-gray-300"></i>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- Content Row -->
                  <div class="row">
                     <!-- Area Chart -->
                     <div class="col-xl-12 col-lg-12">
                        <div class="card shadow mb-4">
                           <!-- Card Header - Dropdown -->
                           <div
                              class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                              <h6 class="m-0 font-weight-bold text-primary">Evolução do peso</h6>
                           </div>
                           <div class="card-body">
                              <div class="chart-area">
                                 <canvas id="myAreaChart"></canvas>
                              </div>
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