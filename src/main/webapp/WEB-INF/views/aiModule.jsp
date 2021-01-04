<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="SmartPV Admin User Page">
<meta name="author" content="Mohammed Baker & Abd-Alqader okasha">
<title>Ai Page</title>
<!-- Favicon -->
<link rel="icon" href="logo.png" type="image/png">
<!-- Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
<!-- Icons -->
<link rel="stylesheet" href="assets/vendor/nucleo/css/nucleo.css"
	type="text/css">
<link rel="stylesheet"
	href="assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
	type="text/css">
<!-- Argon CSS -->
<link rel="stylesheet" href="assets/css/argon.css?v=1.2.0"
	type="text/css">
<link rel="stylesheet" href="assets/css/custom.css" type="text/css">

</head>

<body>
	<!-- Sidenav -->
	<nav
		class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white"
		id="sidenav-main">
		<div class="scrollbar-inner">
			<!-- Brand -->
			<div class="sidenav-header  align-items-center">
				<a class="navbar-brand" href="javascript:void(0)"> <img
					src="assets/img/logo.png" class="navbar-brand-img" alt="...">
				</a>
			</div>
			<div class="navbar-inner">
				<!-- Collapse -->
				<div class="collapse navbar-collapse" id="sidenav-collapse-main">
					<!-- Nav items -->
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="/user"> <i class="ni ni-single-02"
								id="textColor"></i> <span class="nav-link-text">Users</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/device">
								<i class="fa fa-microchip " id="textColor"></i> <span
								class="nav-link-text">Devices</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/ai">
								<i class=" fas fa-brain " id="textColor"></i> <span
								class="nav-link-text">AI Model Info</span>
						</a></li>

					</ul>


				</div>
			</div>
		</div>
	</nav>
	<!-- Main content -->
	<div class="main-content " id="panel">

  <!-- Topnav -->
    <nav class="navbar navbar-top navbar-expand navbar-dark  border-bottom "  id="mainColor">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!-- Search form -->
        
          <!-- Navbar links -->
          <ul class="navbar-nav align-items-center  ml-md-auto ">
            <li class="nav-item d-xl-none">
              <!-- Sidenav toggler -->
              <div class="pr-3 sidenav-toggler sidenav-toggler-dark" data-action="sidenav-pin" data-target="#sidenav-main">
                <div class="sidenav-toggler-inner">
                  <i class="sidenav-toggler-line"></i>
                  <i class="sidenav-toggler-line"></i>
                  <i class="sidenav-toggler-line"></i>
                </div>
              </div>
            </li>
           
                  
          </ul>
         
        </div>
      </div>
    </nav>
		<!-- Header -->
		<!-- Header -->
		<div class="header pb-6" id="mainColor">
			<div class="container-fluid">
				<div class="header-body">
					<div class="row align-items-center py-4">
						<div class="col-lg-6 col-7">
							<h6 class="h2 text-white d-inline-block mb-0">Ai Info</h6>

						</div>
						
					</div>
				</div>
			</div>
		</div>
		<!-- Page content -->
		<div class="container-fluid mt--6 ">
			<div class="row">
				<div class="col">
					<div class="card">
						<!-- Card header -->
						<div class="card-header border-0">
							<h3 class="mb-0">Ai Info</h3>
						</div>
						<!-- Light table -->
						<div class="table-responsive">
							<table class="table align-items-center table-flush ">
								<thead class="thead-light">
									<tr>
										<th scope="col" class="word-wrap" data-sort="name">Efficiency</th>
										<th scope="col" class="word-wrap" data-sort="budget">Count</th>
								

										
									</tr>
								</thead>
								
								
								
									<tbody class="list">
										<tr>
											<td class="budget">${info.efficiency} %</td>

											<td class="budget">${info.count}</td>


										
										</tr>

									</tbody>
							
							</table>
						</div>



					</div>
				</div>
				<!-- Argon Scripts -->
				<!-- Core -->
				<script src="assets/vendor/jquery/dist/jquery.min.js"></script>
				<script
					src="assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
				<script src="assets/vendor/js-cookie/js.cookie.js"></script>
				<script src="assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
				<script
					src="assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
				<!-- Argon JS -->
				<script src="assets/js/argon.js?v=1.2.0"></script>
				<script>
$(window).click(function(e) {

	   if($(".navbar-collapse").hasClass("show")){
	      $('.navbar-collapse').removeClass("show"); 
	      e.preventDefault();
	      }
	});
	 $('.navbar-collapse').click(function(event){
	     event.stopPropagation();
	 });
</script>
</body>

</html>