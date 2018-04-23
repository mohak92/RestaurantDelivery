<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="project.beans.User" %>
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
				<%
				
					String email = (String)session.getAttribute("email");
					if(email!=null){
				%>
				  <li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
				  <li><a href="menuitems.html"><span class="fa fa-bars"></span> Menu</a></li>
				  <li><a href="account.html"><span class=""></span>Account</a></li>
                  <li><a href="logout.html"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
				  <%
				}else{
					%>
					<li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
					  <li><a href="menuitems.html"><span class="fa fa-bars"></span> Menu</a></li>
	                    
		               <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>			  
					 
					  <li><a href="register.html"><span class="glyphicon glyphicon-user"></span> Register</a></li>
				<% 
				}
				%>
				</ul>
							
			  </div>
			</nav> 
			  
		  </div>
		  
		  <div class="col-sm-offset-3 col-sm-6 home-div-img">
		    <img src="img/main-img.jpg" alt="home-img" class="img-responsive" height="400">
		  </div>
		  
		  <div class="col-sm-offset-3 col-sm-6">
		    <div class="col-sm-6 content-main">
			<p>"One cannot think well, sleep well if one has not DINED well" </p>
			</div>
		     
			<div class="col-sm-6">
			<p>Pizza might just be the ultimate delivery meal so why not up the ante a bit? This Clinton Hill pizzeria by husband-and-wife team Matt and Emily Hyland has only been open since early 2014, but its dough, mozzarella-both made in-house, by hand-and wood-burning oven have quickly established it as a force. </p>
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