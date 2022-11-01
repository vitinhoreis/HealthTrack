<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_header.jsp" %>
<title>Health Track</title>
</head>
<!-- body -->
   <body class="main-layout">
      <!-- loader  -->
      <div class="loader_bg">
         <div class="loader"><img src="resources/images/loading.gif" alt="#" /></div>
      </div>
      <!-- end loader -->
      <!-- header -->
      <header>
         <!-- header inner -->
         <div class="header">
            <div class="container-fluid">
               <div class="row">
                  <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col logo_section">
                     <div class="full">
                        <div class="center-desk">
                           <div class="logo">
                              <a href="index.html"><img src="resources/images/logo.png" alt="#" /></a>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                     <nav class="navigation navbar navbar-expand-md navbar-dark ">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarsExample04">
                           <ul class="navbar-nav mr-auto">
                              <li class="nav-item">
                                 <a class="nav-link" href="index.html">Contato</a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="Login.jsp">Login </a>
                              </li>
                              <li class="nav-item">
                                 <a class="nav-link" href="cadastro-usuario.jsp">Registro</a>
                              </li>
                           </ul>
                           <div class="sign_btn"><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></div>
                        </div>
                     </nav>
                  </div>
               </div>
            </div>
         </div>
      </header>
      <!-- end header inner -->
      <!-- end header -->
      <!-- banner -->
      <section class="banner_main">
         <div class="container-fluid">
            <div class="row d_flex">
               <div class="col-md-6">
                  <div class="text-bg">
                     <div class="padding_lert">
                        <h1>Exercicio e Saúde!</h1>
                        <span></span>
                        <p>Monitore os seu progresso fisico e a sua saúde com o Helath Track!</p>
                        <a class="read_more" href="#">Saiba mais</a>
                     </div>
                  </div>
               </div>
               <div class="col-md-6">
                  <div class="text-img">
                     <figure><img src="resources/images/toy_img.png" alt="#"/></figure>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- end banner -->
      <!-- features -->
      <div class="Features">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage">
                     <h2>HEALTH TRACK</h2>
                     <span></span>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-md-4">
                  <div class="Our_box">
                     <i><img src="resources/icon/icon1.png" alt="#"/></i>
                     <h4>EXERCÍCIOS <br></h4>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="Our_box">
                     <i><img src="resources/icon/icon2.png" alt="#"/></i>
                     <h4>ALIMENTAÇÃO <br></h4>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="Our_box">
                     <i><img src="resources/icon/icon3.png" alt="#"/></i>
                     <h4>MONITORAMENTO <br></h4>
                  </div>
               </div>
               <div class="col-md-12">
                  <a class="read_more" href="#">Saiba mais</a>
               </div>
            </div>
         </div>
      </div>
      <!-- end Features -->
      <!-- discount -->
      <!--
      <div class="discount">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage">
                     <h2>FITNESS CLASSES THIS SUMMER. PAY NOW AND GET 25% DISCOUNT</h2>
                     <span>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor a</span>
                     <a class="read_more">Read More</a>
                  </div>
               </div>
            </div>
         </div>
      </div>      
      <!-- end discount -->
      <!-- request -->
      <!--
      <div class="request">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage">
                     <h2>Rqueste a call back</h2>
                     <span>There are many variations of passages of Lorem Ipsum available, but the majority have suffered a</span>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-md-4">
                  <form id="request" class="main_form">
                     <div class="row">
                        <div class="col-md-12 ">
                           <input class="contactus" placeholder="Name" type="type" name="Name"> 
                        </div>
                        <div class="col-md-12">
                           <input class="contactus" placeholder=" Phone" type="type" name="Phone"> 
                        </div>
                        <div class="col-md-12">
                           <input class="contactus" placeholder=" Email" type="type" name="Email">                          
                        </div>
                        <div class="col-md-12">
                           <textarea class="textarea" placeholder="Message" type="type" Message="Name">Message </textarea>
                        </div>
                        <div class="col-sm-12">
                           <button class="send_btn">Send</button>
                        </div>
                     </div>
                  </form>
               </div>
               <div class="col-md-8">
                  <div class="back_img">
                     <figure><img src="images/img.jpg" alt="#"/></figure>
                  </div>
               </div>
            </div>
         </div>
      </div>
      -->
      <!-- end request -->
      <!-- people -->
      <div class="people">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage">
                     <h2> O que as pessoas estão falando sobre o Health Track</h2>
                     <span>looking at its layout. The point of using Lorem Ipsumreadable content of a page when looking at its layout.</span>
                  </div>
               </div>
            </div>
            <div class="row">
               <div class="col-md-12">
                  <div id="myCarousel" class="carousel slide people_Carousel " data-ride="carousel">
                     <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                     </ol>
                     <div class="carousel-inner">
                        <div class="carousel-item active">
                           <div class="container">
                              <div class="carousel-caption ">
                                 <div class="row">
                                    <div class="col-md-8 offset-md-2">
                                       <div class="test_box">
                                          <h4>Duis aute</h4>
                                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. x ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate</p>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="carousel-item">
                           <div class="container">
                              <div class="carousel-caption">
                                 <div class="row">
                                    <div class="col-md-8 offset-md-2">
                                       <div class="test_box">
                                          <h4>Duis aute</h4>
                                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. x ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate</p>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="carousel-item">
                           <div class="container">
                              <div class="carousel-caption">
                                 <div class="row">
                                    <div class="col-md-8 offset-md-2">
                                       <div class="test_box">
                                          <h4>Duis aute</h4>
                                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. x ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate</p>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                     <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                     <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                     <span class="sr-only">Previous</span>
                     </a>
                     <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                     <span class="carousel-control-next-icon" aria-hidden="true"></span>
                     <span class="sr-only">Next</span>
                     </a>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- end people -->

     
<%@ include file="_footer.jsp" %>
  </body>

</html>