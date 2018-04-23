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
				  <li><a href="home.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
				  <li><a href="menuitems.html"><span class="glyphicon glyphicon-menu"></span> Menu</a></li>
                    
	               <li><a href="login.html" id="login-form-link"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>			  
				 <li><a href="account.html"><span class=""></span>Account</a></li>
				  <li><a href="register.html" id="register-form-link"><span class="glyphicon glyphicon-user"></span> Register</a></li>
				  
				</ul>
							
			  </div>
			</nav> 
			  
		  </div>
		  
		  
		 


    <div class="col-md-4 col-md-offset-4 login-details">
      <div class="panel panel-login">
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
              <form id="login-form" action="#" method="post" role="form" style="display: block;">
                <h2>LOGIN</h2>
                  <div class="form-group">
                    <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                  </div>
                  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                  </div>
                  <div class="col-xs-12 form-group pull-left login-btn">
                    <a href="">Register</a>
                    <input type="submit" name="login-submit" id="login-submit" class="btn btn-primary" value="Log In">					
                  </div>
                 
              </form>
              <form id="register-form" action="#" method="post" role="form" style="display: none;">
                <h2>REGISTER</h2>
                  
				  <div class="form-group">
                    <input type="text" name="firstname" id="firstname" tabindex="1" class="form-control" placeholder="firstname" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="lastname" id="lastname" tabindex="2" class="form-control" placeholder="lastname" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                  </div>
				  
                  <div class="form-group">
                    <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
                  </div>
				  
				  <div class="form-group">
					<select name="gender" id="gender" class="form-control" placeholder="gender">
					  <option>Male</option>
					  <option>Female</option>
					</select>
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="address" id="address" tabindex="" class="form-control" placeholder="address" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="phone" id="phone" tabindex="" class="form-control" placeholder="phone" value="">
                  </div>
				  
                  <div class="form-group">
                    <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email" value="">
                  </div>
                  
                  <div class="form-group">
                    <div class="row">
                       <div class="col-xs-12 form-group pull-left login-btn">
                        <a href="">Register</a>
                    <input type="submit" name="login-submit" id="login-submit" class="btn btn-primary" value="Log In">					
                  </div>
                    </div>
                  </div>
              </form>
            </div>
          </div>
        </div>
        
      </div>
    </div>


	<div class="col-sm-12">
       <div class="footer text-center">
	    <p>Copy Rights Restaurant Delivery All Rights Reserved</p>

       </div>	   
	
	</div>
	
	
	
	
	
	
	

		</div>
	 </div>
   </section>   
	      
</body>
</html> 