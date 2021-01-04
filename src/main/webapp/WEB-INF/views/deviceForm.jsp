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
<title>Device Form Page</title>
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
							<h6 class="h2 text-white d-inline-block mb-0">Device</h6>

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
							<h3 class="mb-0">Device Form</h3>

						</div>
						<!-- Light table -->
						<form:form style="padding: 1%" method="post" action="saveDevice"
							modelAttribute="device">
							<form:hidden path="id" />

							<div class="form-group ">
								<label for="example-text-input" class="form-control-label">IMEI</label>
								<form:input class="form-control" type="text" path="imei"
									id="example-text-input" />
								<form:errors path="imei" cssClass="error" />
							</div>
							<div class="form-group">
								<label for="example-number-input" class="form-control-label">Rated
									Out </label>
								<form:input class="form-control" type="number" min="0"
									path="ratedOut" id="example-number-input" />
								<form:errors path="ratedOut" cssClass="error" />
							</div>
							<div class="form-group">
								<label for="example-number-input" class="form-control-label">Rated
									Capacity</label>
								<form:input class="form-control" type="number" min="0"
									path="ratedCapacity" id="example-number-input" />
								<form:errors path="ratedCapacity" cssClass="error" />
							</div>

							<div class="form-group">
								<label for="example-checkbox-input" class="form-control-label">Activated</label><br>
								

								<div class="form-check form-check-inline">

									<form:radiobutton path="activated" value="true"
										class="form-check-input" />
									<label class="form-check-label"> True </label>
								</div>
								<div class="form-check form-check-inline">
									<form:radiobutton path="activated" value="false"
										class="form-check-input" />
									<label class="form-check-label"> False </label>
								</div>
								
							</div>
							<div class="d-flex justify-content-center">
								<input type="submit" value="SAVE" class="btn" id="mainColor"
									style="color: #FFFFFF;" />
							</div>
						</form:form>
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



