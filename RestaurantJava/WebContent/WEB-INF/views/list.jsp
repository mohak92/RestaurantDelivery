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
				  <li><a href="index.html"> Home</a></li>
				  <li><a href="#"><span class="glyphicon glyphicon-menu"></span>Navigate Application</a></li>
                    
	               <li><a href="#" id="login-form-link"> Logout</a></li>			  
				 
				  
				</ul>
							
			  </div>
			</nav> 
			  
		  </div>
		  
		  <div class="col-sm-offset-4 col-sm-4">
		    <ul class="nav nav-tabs">
			  <li><a data-toggle="tab" href="#menu1">User List</a></li>
			  <li><a data-toggle="tab" href="#menu2">Item List</a></li>
			  <li><a data-toggle="tab" href="#menu3">Order List</a></li>
			  <li><a data-toggle="tab" href="#menu4">Location List</a></li>
			</ul>
           </div>
		   
		   <div class="col-sm-12">
			<div class="tab-content">
			  <div id="menu1" class="tab-pane fade in active">
               <div class="col-sm-3 single-user-info">
				<form action="#" method="post" role="form">
                <h3>Single User's Information</h3>
                  
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
                     
                    <input type="submit" name="update-user" id="update-user" class="btn btn-primary" value="Update User">					
                  </div>
                    </div>
                  </div>
              </form>
			  </div>
			  
			  <div class="col-sm-9 user-details">
			     <h4>Scott</h4>
				 <p>This Salad is the best.</p>
				 <input type="submit" class="btn btn-primary" id="delete Review" value="delete Review">
				
			  </div>
			  
			  
			  
			  
			  
			  </div>
			  
			  
			  
			  <div id="menu2" class="tab-pane fade">
				<h3>Menu 2</h3>
				<p>Some content in menu 1.</p>
			  </div>
			  
			  
			  <div id="menu3" class="tab-pane fade">
			     <div class="col-sm-offset-4 col-sm-4 order-list-details">
                    <h4>List Of Orders</h4>
					<p>Number Of Items:-</p>
					<p>Order Number:</p>
					<p>Total:<input type="submit" value="Delete order"></p>
                 </div>				 
			
			     <div class="col-sm-offset-4 col-sm-4 order-list-details">
					<p>Number Of Items:-</p>
					<p>Order Number:</p>
					<p>Total:<input type="submit" value="Delete order"></p>
                 </div>
			
			     <div class="col-sm-offset-4 col-sm-4 order-list-details">
					<p>Number Of Items:-</p>
					<p>Order Number:</p>
					<p>Total:<input type="submit" value="Delete order"></p>
                 </div>
			  
			
			  </div>
			  
			  <div id="menu4" class="tab-pane fade">
				<h3>Menu 4</h3>
				<p>Some content in menu 2.</p>
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