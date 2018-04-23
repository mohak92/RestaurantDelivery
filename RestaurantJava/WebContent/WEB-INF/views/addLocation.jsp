<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="project.beans.User" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8" />
  <title>Restaurant Delivery</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">


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
				String isAdmin = (String)session.getAttribute("isAdmin"); 
				if(!isAdmin.equals(null) && isAdmin.equals("1")){
				%>
				
				  <li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                  <li><a href="navigateApp.html"><span class=""></span>Navigate Application</a></li>
	               <li><a href="login.html"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>			  
				 <%}else{
					 %>
					 <li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
					 <li><a href="menuitems.html"><span class="glyphicon glyphicon-menu"></span> Menu</a></li>
                  <li><a href="viewOrders.html"><span class=""></span>View Orders</a></li>
                  <li><a href="account.html"><span class=""></span>Account</a></li>
	               <li><a href="logout.html"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					 <% 
				 } %>
				  
				</ul>
							
			  </div>
			</nav> 
			  
		  </div>
		  
		  
		 


    <div class="col-md-3 col-md-offset-4 login-details">
      <div class="panel panel-login">
        <div class="panel-body">
          <div class="row">
            <div class="col-lg-12">
              
              <form id="register-form" action="#" method="post" role="form" enctype="multipart/form-data" name="multipleUpload">
               	
               	<h2>Add Location</h2>
               	 <p id="errorText" style="color:red;text-align:center; display:none;font-style:bold;">All fields are mandatory*</p>
				  <div class="form-group">
                    <input type="text" name="location" id="location" tabindex="1" class="form-control" placeholder="Location" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="add" id="add" tabindex="2" class="form-control" placeholder="Address" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="city" id="city" tabindex="2" class="form-control" placeholder="City" value="">
                  </div>
				  
                  <div class="form-group">
                    <input type="text" name="staff" id="staffs" tabindex="2" class="form-control" placeholder="Staffs">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="zipcode" id="zipcode" tabindex="" class="form-control" placeholder="zipcode" value="">
                  </div>
				  
				  <div class="form-group">
                    <input type="file" name="imageFile" id="imageFile" tabindex="" class="form-control" placeholder="phone" value="">
                  </div>
				  <div class="form-group">
                    <div class="row">
                       <div class="col-xs-12 form-group pull-left login-btn">
                        
                    <input type="submit" name="update-user" id="addLocation" class="btn btn-primary" value="Add Location">					
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
	
	$("#addLocation").on('click',function(e){
			
			var isValid = validation();
			
			if(!isValid.result){
				$("#"+isValid.element).focus();
				$("#errorText").css("display","block");
				e.preventDefault();
				setTimeout(function(){
					$("#errorText").css("display","none");
				},5000);
			}else{
				//alert("processRegistration");
				$("#register-form").attr("action","addNewLocation.html");
				$("#register-form").submit();
			}
	});
	
	function validation(){
		var location = $("#location").val();
		var add = $("#add").val();
		var city = $("#city").val();
		var staff = $("#staffs").val();
		var image = $("#imageFile").val();
		var zip = $("#zipcode").val();
		var flag = false;
		var object = {status:"NOTOK",result:false};
		if(location){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"location",result:false};
		}
		if(add){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"add",result:false};
		}
		if(city){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"city",result:false};
		}
		if(image){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"image",result:false};
		}
		if(staff){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"staffs",result:false};
		}
		if(zip){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"zipcode",result:false};
		}

		if(flag){
			return object;
		}
	}
	</script>
</body>
</html> 