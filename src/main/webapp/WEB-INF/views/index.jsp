<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>SmartPV System</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/assets/img/logo" rel="icon">
  

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="/assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="/assets/vendor/line-awesome/css/line-awesome.min.css" rel="stylesheet">
  <link href="/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="/assets/css/style.css" rel="stylesheet">

  
</head>

<body>

  <!-- ======= Mobile Menu ======= -->
  <div class="site-mobile-menu site-navbar-target">
    <div class="site-mobile-menu-header">
      <div class="site-mobile-menu-close mt-3">
        <span class="icofont-close js-menu-toggle"></span>
      </div>
    </div>
    <div class="site-mobile-menu-body"></div>
  </div>

  <!-- ======= Header ======= -->
 
  <!-- ======= Hero Section ======= -->
  <section class="hero-section" id="hero">

    <div class="wave">

      <svg width="100%" height="355px" viewBox="0 0 1920 355" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
        <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
          <g id="Apple-TV" transform="translate(0.000000, -402.000000)" fill="#FFFFFF">
            <path d="M0,439.134243 C175.04074,464.89273 327.944386,477.771974 458.710937,477.771974 C654.860765,477.771974 870.645295,442.632362 1205.9828,410.192501 C1429.54114,388.565926 1667.54687,411.092417 1920,477.771974 L1920,757 L1017.15166,757 L0,757 L0,439.134243 Z" id="Path"></path>
          </g>
        </g>
      </svg>

    </div>

    <div class="container">
      <div class="row align-items-center">
        <div class="col-12 hero-text-image">
          <div class="row">
            <div class="col-lg-7 text-center text-lg-left">
              <h1 data-aos="fade-right">SMART PV SYSTEM&nbsp;</h1>
              <p class="mb-5" data-aos="fade-right" data-aos-delay="100">SmartPV is a system for monitoring and recording pv panels data. Also, to improve the efficiency of the system.</p>
              <p data-aos="fade-right" data-aos-delay="200" data-aos-offset="-500"><a href="/user" class="btn btn-outline-white">Admin Page</a></p>
            </div>
            <div class="col-lg-5 iphone-wrap">
              <img src="/assets/img/phone_1.png" alt="Image" class="phone-1" data-aos="fade-right">
              <img src="/assets/img/phone_2.png" alt="Image" class="phone-2" data-aos="fade-right" data-aos-delay="200">
            </div>
          </div>
        </div>
      </div>
    </div>

  </section><!-- End Hero -->

  <main id="main">

    <!-- ======= Home Section ======= -->
    <section class="section">
      <div class="container">

        <div class="row justify-content-center text-center mb-5">
          <div class="col-md-5" data-aos="fade-up">
            <h2 class="section-heading">The System Structure</h2>
          </div>
        </div>

        <div class="row">
          <div class="col-md-4" data-aos="fade-up" data-aos-delay="">
            <div class="feature-1 text-center">
              <div class="wrap-icon icon-1">
                <span class="icon la la-microchip"></span>
              </div>
              <h3 class="mb-3">Self Controlled  Device</h3>
              <p>An arduino device connected to a pv, battery, GSM module, GPS modeul, LDRs, Current Sensors, humdity Sensor, temperature sensor and Servo motors.</p>
            </div>
          </div>
          <div class="col-md-4" data-aos="fade-up" data-aos-delay="100">
            <div class="feature-1 text-center">
              <div class="wrap-icon icon-1">
                <span class="icon la la-mobile"></span>
              </div>
              <h3 class="mb-4">Andorid  Application</h3>
              <p>The Application used by the clients to monitors thier devices. The application was built using android studio (Kotlin).</p>
				<p data-aos="fade-right" data-aos-delay="200" data-aos-offset="-500"><a href="https://github.com/mbaker117/SmartPV_Android_Application" class="btn" style="background:#3780b4; color:white">Github Link</a></p>
            </div>
          </div>
          <div class="col-md-4" data-aos="fade-up" data-aos-delay="200">
            <div class="feature-1 text-center">
              <div class="wrap-icon icon-1">
                <span class="icon la la-brain  "></span>
              </div>
              <h3 class="mb-4">AI Module </h3>
              <p>The AI module is used to predicate the future energy that the system will produce. The AI was built using Python programming language and using Pytorch framework. The AI is hosted on Azure servers.</p>
            </div>
          </div>
			 <div class="col-md-4" data-aos="fade-up" data-aos-delay="300">
            <div class="feature-1 text-center">
              <div class="wrap-icon icon-1">
                <span class="icon la la-brain  "></span>
              </div>
              <h3 class="mb-4">Server API</h3>
              <p>The server API handles all the communications in the system and record all the requests. The server Api was built using Java programming language and using Spring Framework </p>
				<p data-aos="fade-right" data-aos-delay="200" data-aos-offset="-500"><a href="/swagger-ui.html" class="btn" style="background:#3780b4; color:white"> API Page </a></p>
				<p data-aos="fade-right" data-aos-delay="200" data-aos-offset="-500"><a href="https://github.com/mbaker117/SmartPV" class="btn" style="background:#3780b4; color:white">Github Link</a></p>
            </div>
          </div>
			
				 <div class="col-md-4" data-aos="fade-up" data-aos-delay="400">
            <div class="feature-1 text-center">
              <div class="wrap-icon icon-1">
                <span class="icon la la-laptop  "></span>
              </div>
              <h3 class="mb-4">Admin Panel</h3>
              <p>The Admin panel is used as a dashborad for all the data in the system. </p><br><br>
				<p data-aos="fade-right" data-aos-delay="200" data-aos-offset="-500"><a href="/user" class="btn" style="background:#3780b4; color:white">Admin Page</a></p>
            </div>
          </div>
        </div>

      </div>
    </section>

    <section class="section">

      <div class="container">
        <div class="row justify-content-center text-center mb-5" data-aos="fade">
          <div class="col-md-6 mb-5">
            <img src="/assets/img/aaa.png" alt="Image" class="img-fluid">
          </div>
        </div>

        <div class="row">
          <div class="col">
            <div class="step">
              
              <h3>The Overview digram of the system.</h3>
              <p>The digram above shows all the possible communication in the system.</p>
            </div>
          </div>
         
        </div>
      </div>

    </section>

    <section class="section">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-4 mr-auto">
            <h2 class="mb-4">Hardware Device</h2>
            <p class="mb-4">Our Hardware device that will send the reading every half an hour to server API.</p>
        
          </div>
          <div class="col-md-6" data-aos="fade-left">
            <img src="/assets/img/x.png" alt="Image" class="img-fluid">
          </div>
        </div>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-4 ml-auto order-2">
            <h2 class="mb-4">Android Application</h2>
            <p class="mb-4">The Mobile Application is used to monitor the current state of the device and the historicate data.</p>
           
          </div>
          <div class="col-md-6" data-aos="fade-right">
            <img src="/assets/img/a.png" alt="Image" class="img-fluid">
          </div>
        </div>
      </div>
    </section>

    <!-- ======= Testimonials Section ======= -->
    <section class="section border-top border-bottom">
      <div class="container">
        <div class="row justify-content-center text-center mb-5">
          <div class="col-md-4">
            <h2 class="section-heading">Our Team</h2>
          </div>
        </div>
           <div class="row justify-content-center">
          
       
                             
 <div class="col-md-4 text-center" data-aos="fade-up" data-aos-delay="100">
               
                  <img src="/assets/img/my.png" alt="Image" class="img-fluid rounded-circle mb-5">
                  <span class="d-block">
                    <span class="text-black">Mohammed Baker</span>, &mdash; Computer Engineering
                  </span>
                
			  </div>
          <div class="col-md-4 text-center"  data-aos="fade-up" data-aos-delay="200">
               
                  <img src="/assets/img/abd.png" alt="Image" class="img-fluid rounded-circle mb-5">
                  <span class="d-block">
                    <span class="text-black">Abd-Alqader Okasha</span>, &mdash; Computer Engineering
                  </span>
             
			  </div>
                
			     <div class="col-md-4 text-center"  data-aos="fade-up" data-aos-delay="300">
               
                  <img src="/assets/img/hazem.png" alt="Image" class="img-fluid rounded-circle mb-5">
                  <span class="d-block">
                    <span class="text-black">Hazem Marar</span>, &mdash; Supervisor                  </span>
             
			  </div>
               
     
          </div>
		  
		  
		  
		  
		  
		  </div>
      
     
    </section><!-- End Testimonials Section -->

    
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer class="footer" role="contentinfo">
    <div class="container">
   
      <div class="row justify-content-center text-center">
        <div class="col-md-7">
          <p class="copyright">&copy; Copyright PSUT. All Rights Reserved</p>
          <div class="credits">
     
          </div>
        </div>
      </div>

    </div>
  </footer>

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="/assets/vendor/jquery/jquery.min.js"></script>
  <script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="/assets/vendor/php-email-form/validate.js"></script>
  <script src="/assets/vendor/aos/aos.js"></script>
  <script src="/assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="/assets/vendor/jquery-sticky/jquery.sticky.js"></script>

  <!-- Template Main JS File -->
  <script src="/assets/js/main.js"></script>

</body>

</html>