<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.beans.User,project.beans.Menuitems" %>
 <!DOCTYPE html>
<html lang="en">
<head>
  <title>Restaurant Delivery</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
				if(email != null){
					
				%>
				  <li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Home</a></li>
				  <li><a href="menuitems.html"><span class="fa fa-bars"></span> Menu</a></li>
				  <li><a href="account.html"><span class=""></span>Account</a></li>
	              <li><a href="logout.html"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>			  
				  <%}else{
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
		  
		  
<section class="middlearea paymentpage">
	
	<div class="col-md-12 text-right">
	 <% 
   		String order_num = (String) session.getAttribute("ordernumber");
   %>
	 <a href="cancelOrder.html?order_num=<%=order_num %>" >Cancel Order</a>
	</div>
	
	<div class="col-md-4 col-md-offset-4">
      
		<div class="paymentdiv">
		
			<form id="payment-form" method="post" role="form" style="display: block;">
                <h2>Payment Information</h2>
                <p id="errorText" style="color:red;text-align:center; display:none;font-style:bold;">All fields are mandatory*</p>
                  <div class="form-group">
                    <input type="text" name="creaditcard" id="creaditcard" tabindex="1" class="form-control" placeholder="Creadit Card" value="" onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
                  </div>
                  <div class="form-group">
                    <input type="password" name="securenumber" id="securenumber" tabindex="2" class="form-control" placeholder="Secure Number" onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="zipcode" id="zipcode" tabindex="3" class="form-control" placeholder="Zip Code" onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
                  </div>
                  <div class="form-group">
                    
                    <input type="submit" name="login-submit" id="login-submit" class="btn btn-primary" value="Process">					
                  </div>
                 
              </form>
		</div>
		
	</div>
	
	
</section>		  
		  
		 




	<div class="col-sm-12">
       <div class="footer text-center">
	    <p>Copy Rights Restaurant Delivery All Rights Reserved</p>

       </div>	   
	
	</div>
	
	
	
	
	
	
	

		</div>
	 </div>
   </section>   
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>     
<script>
	
	$("#login-submit").on('click',function(e){
			
			var isValid = validation();
			console.log(isValid);
			if(!isValid.result){
				$("#errorText").css("display","block");
				e.preventDefault();
				setTimeout(function(){
					$("#errorText").css("display","none");
				},5000);
			}else{
				//alert("processRegistration");
				$("#payment-form").attr("action","completePayment.html");
				$("#payment-form").submit();
			}
	});
	
	function validation(){
		var creaditcard = $("#creaditcard").val();
		var securenumber = $("#securenumber").val();
		var zipcode = $("#zipcode").val();
		
		var flag = false;
		var object = {status:"NOTOK",result:false};
		if(creaditcard){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"creaditcard",result:false};
		}
		if(securenumber){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"securenumber",result:false};
		}
		if(zipcode){
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
<style>
.paymentdiv{ background-color:#67e57c; padding:5px 30px 20px 30px; margin:50px 0px;}
</style>  
</body>
</html> 