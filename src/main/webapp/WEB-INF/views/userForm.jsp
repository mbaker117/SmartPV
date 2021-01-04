<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="SmartPV Admin User Page">
<meta name="author" content="Mohammed Baker & Abd-Alqader okasha">
<title>User Form Page</title>
<!-- Favicon -->
<link rel="icon" href="logo_03.png" type="image/png">
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


	<div class="main-content" id="panel">


		<!-- Header -->
		<!-- Header -->
		<div class="header  pb-6" id="mainColor">
			<div class="container-fluid">
				<div class="header-body">
					<div class="row align-items-center py-4">
						<div class="col-lg-6 col-7">
							<h6 class="h2 text-white d-inline-block mb-0">User</h6>

						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- Page content -->
		<div class="container-fluid mt--6">
			<div class="row">
				<div class="col">
					<div class="card">
						<!-- Card header -->
						<div class="card-header border-0">
							<h3 class="mb-0">User Form</h3>
							
						</div>
						<!-- Light table -->
						<form:form style="padding: 1%" method="post" action="saveUser" modelAttribute="user">
						<form:hidden path="id" />
						
							<div class="form-group ">
								<label for="example-text-input" class="form-control-label">First
									Name</label> <form:input class="form-control" type="text"  path="firstName"
									id="example-text-input"/>
									<form:errors path="firstName" cssClass="error"/>
							</div>
							<div class="form-group">
								<label for="example-search-input" class="form-control-label">Last
									Name</label> <form:input class="form-control" type="search" path="lastName"
									 id="example-search-input"/>
									 <form:errors path="lastName" cssClass="error"/>
							</div>
							<div class="form-group">
								<label for="example-email-input" class="form-control-label">Email</label>
								<form:input class="form-control" type="email" path="email"
									id="example-email-input"/>
									<form:errors path="email" cssClass="error"/>
							</div>

							<div class="form-group" hidden="true">
								<label for="example-password-input" class="form-control-label">Password</label>
								<form:input class="form-control" type="text" value="0000" path="password"
									id="example-password-input"/>
									<form:errors path="password" cssClass="error"/>
							</div>
							<div class="d-flex justify-content-center">
								<input type="submit" value="SAVE" class="btn" id="mainColor" style="color:#FFFFFF;" />
							</div>
						</form:form>
					</div>



				</div>
			</div>
			</div>
			<!-- Argon Scripts -->
			<!-- Core -->
			<script src="assets/vendor/jquery/dist/jquery.min.js"></script>
			<script src="assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
			<script src="assets/vendor/js-cookie/js.cookie.js"></script>
			<script src="assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
			<script
				src="assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
			<!-- Argon JS -->
			<script src="assets/js/argon.js?v=1.2.0"></script>
</body>

</html>



