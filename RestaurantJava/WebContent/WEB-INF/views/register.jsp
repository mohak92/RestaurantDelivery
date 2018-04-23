<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <script src="js/require.js"></script>  
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
              
              <form id="register-form" method="post" role="form">
                <h2>Register</h2>
                	
                  <p id="errorText" style="color:red;text-align:center; display:none;">All fields are mandatory*</p>
				  <div class="form-group">
                    <input type="text" name="firstname" id="firstname" tabindex="1" class="form-control" placeholder="First Name" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="lastname" id="lastname" tabindex="2" class="form-control" placeholder="Last Name" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="password" name="password" id="password" tabindex="3" class="form-control" placeholder="Password">
                  </div>
				  
                  <div class="form-group">
                    <input type="password" name="confirm-password" id="confirm-password" tabindex="4" class="form-control" placeholder="Confirm Password">
                  </div>
				  
				  <div class="form-group">
					<select name="gender" id="gender" class="form-control" placeholder="gender">
					  <option>Male</option>
					  <option>Female</option>
					</select>
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="address" id="address" tabindex="5" class="form-control" placeholder="address" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="phone" id="phone" tabindex="6" class="form-control" placeholder="phone" value="" onkeypress='return event.charCode >= 48 && event.charCode <= 57' >
                  </div>
				  
                  <div class="form-group">
                    <input type="email" name="email" id="email" tabindex="7" class="form-control" placeholder="Email" value="">
                  </div>
                  
                  <div class="form-group">
                    <div class="row">
                       <div class="col-xs-12 form-group pull-left login-btn">
                        <a href="login.html">Login?</a>
                    <input type="submit" name="login-submit" id="register-submit" class="btn btn-primary" value="Register">					
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
	    <p>Copy Rights &copy; Restaurant Delivery All Rights Reserved</p>

       </div>	   
	
	</div>
	
	
	
	
	
	
	

		</div>
	 </div>
   </section>   
	<script>
	
	$("#register-submit").on('click',function(e){
			
			var isValid = validation();
			if(!isValid){
				$("#errorText").css("display","block");
				e.preventDefault();
				setTimeout(function(){
					$("#errorText").css("display","none");
				},5000);
			}else{
				//alert("processRegistration");
				$("#register-form").attr("action","processRegistration.html");
				$("#register-form").submit();
			}
	});
	
	function validation(){
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		var email = $("#email").val();
		var password = $("#password").val();
		var conpassword = $("#confirm-password").val();
		var gender = $("#gender").val();
		var address = $("#address").val();
		var phone = $("#phone").val();
		var flag = false;
		if(firstname && lastname){
			flag = true;
		}else{
			return false;
		}
		if((password.length > 8) && (conpassword.length >8) && (password==conpassword)){
			flag = true;
		}else{
			return false;
		}
		if(email.indexOf("@") > 0){
			flag = true;
		}else{
			return false;
		}
		if(address){
			flag = true;
		}else{
			return false;
		}
		if(flag){
			return flag;
		}
	}
	</script>	      
</body>

</html> 