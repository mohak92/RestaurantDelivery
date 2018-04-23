 <!DOCTYPE html>
<html lang="en">
<head>
  <title>Restaurant Delivery</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

<script>  
  $(function() {
    $('#login-form-link').click(function(e) {
    	$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
</script>
  
  </head>

<body>

    
   <section class="header">
     <div class="container main-container">
	    <div class="row">
		    <div class="page-header">
		    <nav class="navbar">
			  <div class="container-fluid">
				<div class="navbar-header">
				  <a class="navbar-brand" href="#"><h1>Restaurant Delivery</h1></a>
				</div>
				
				<ul class="nav navbar-nav navbar-right">
				  <li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
				  <li><a href="menuitems.html"><span class="fa fa-bars"></span> Menu</a></li>
                    
	               <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>			  
				 
				  <li><a href="register.html"><span class="glyphicon glyphicon-user"></span> Register</a></li>
				  
				</ul>
							
			  </div>
			</nav> 
			  
		  </div>
		  
		  
		 


    <div class="col-md-4 col-md-offset-4 login-details">
      <div class="panel panel-login">
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
              <form id="login-form" action="processLogin.html" method="post" role="form" style="display: block;">
                <h2>Login</h2>
                  <div class="form-group">
                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                  </div>
                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                  </div>
                  <div class="col-xs-12 form-group pull-left login-btn">
                    <a href="register.html">Register?</a>
                    <input type="submit" name="login-submit" id="login-submit" class="btn btn-primary" value="Log In">					
                  </div>
                 
              </form>
              
            </div>
          </div>
        </div>
        
      </div>
    </div>


			<div class="col-sm-12">
			   <div class="footer text-center">
				<p>Copy Rights &copy; Restaurant Delivery All Rights Reserved</p>

			   </div>	   
			
			</div>
			
	
		</div>
	 </div>
   </section>   
	      
</body>
</html> 