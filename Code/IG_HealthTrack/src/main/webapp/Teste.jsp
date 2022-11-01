<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css'><link rel="stylesheet" href="resources/css/menu.css">
</head>
<body>
<div class='dashboard'>
    <div class="dashboard-nav">
        <header><a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a><a href="#"
                                                                                   class="brand-logo"><i
                class="fas fa-anchor"></i> <span>BRAND</span></a></header>
        <nav class="dashboard-nav-list"><a href="#" class="dashboard-nav-item"><i class="fas fa-home"></i>
            Home </a><a
                href="#" class="dashboard-nav-item active"><i class="fas fa-tachometer-alt"></i> dashboard
        </a><a
                href="#" class="dashboard-nav-item"><i class="fas fa-file-upload"></i> Upload </a>
            <div class='dashboard-nav-dropdown'><a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i
                    class="fas fa-photo-video"></i> Media </a>
                <div class='dashboard-nav-dropdown-menu'><a href="#"
                                                            class="dashboard-nav-dropdown-item">All</a><a
                        href="#" class="dashboard-nav-dropdown-item">Recent</a><a
                        href="#" class="dashboard-nav-dropdown-item">Images</a><a
                        href="#" class="dashboard-nav-dropdown-item">Video</a></div>
            </div>
            <div class='dashboard-nav-dropdown'><a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i
                    class="fas fa-users"></i> Users </a>
                <div class='dashboard-nav-dropdown-menu'><a href="#"
                                                            class="dashboard-nav-dropdown-item">All</a><a
                        href="#" class="dashboard-nav-dropdown-item">Subscribed</a><a
                        href="#"
                        class="dashboard-nav-dropdown-item">Non-subscribed</a><a
                        href="#" class="dashboard-nav-dropdown-item">Banned</a><a
                        href="#" class="dashboard-nav-dropdown-item">New</a></div>
            </div>
            <div class='dashboard-nav-dropdown'><a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i
                    class="fas fa-money-check-alt"></i> Payments </a>
                <div class='dashboard-nav-dropdown-menu'><a href="#"
                                                            class="dashboard-nav-dropdown-item">All</a><a
                        href="#" class="dashboard-nav-dropdown-item">Recent</a><a
                        href="#" class="dashboard-nav-dropdown-item"> Projections</a>
                </div>
            </div>
            <a href="#" class="dashboard-nav-item"><i class="fas fa-cogs"></i> Settings </a><a
                    href="#" class="dashboard-nav-item"><i class="fas fa-user"></i> Profile </a>
          <div class="nav-item-divider"></div>
          <a
                    href="#" class="dashboard-nav-item"><i class="fas fa-sign-out-alt"></i> Logout </a>
        </nav>
    </div>
    <div class='dashboard-app'>
        <header class='dashboard-toolbar'><a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a></header>
        <div class='dashboard-content'>
            <div class='container'>
                <div class='card'>
                    <div class='card-header'>
                        <h1>Welcome back Jim</h1>
                    </div>
                    <div class='card-body'>
                        <p>Your account type is: Administrator</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js'></script><script  src="resources/js/menu.js"></script>
</body>
</html>