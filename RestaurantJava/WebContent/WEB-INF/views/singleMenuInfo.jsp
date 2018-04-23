<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="project.beans.User,project.beans.Menuitems" %>
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
                  <li><a href="account.html"><span class=""></span>Account</a></li>
                  
	               <li><a href="logout.html"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>			  
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
              
              <form id="item-form" method="post" role="form" enctype="multipart/form-data" name="multipleUpload">
               
                <h2>Item Information</h2>
                 
               	 <% Menuitems menu = (Menuitems)session.getAttribute("MenuItemsInfo"); %>
               	 <p id="errorText" style="color:red;text-align:center; display:none;font-style:bold;">All fields are mandatory*</p>
				  <div class="form-group">
                    <input type="text" name="itemname" id="itemname" tabindex="1" class="form-control" placeholder="Item Name" value="<%=menu.getMenuname() %>">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="price" id="price" tabindex="2" class="form-control" placeholder="Price" value="<%=menu.getPrice() %>">
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="description" id="description" tabindex="2" class="form-control" placeholder="Description" value="<%=menu.getDescription() %>">
                  </div>
				  
                  
				  
				  <div class="form-group">
                    <input type="file" name="imageFile" id="image" tabindex="" class="form-control" placeholder="Image" value="" required>
                  </div>
				  
				  <div class="form-group">
                    <input type="text" name="category" id="category" tabindex="" class="form-control" placeholder="Category" value="">
                  </div>
                  
                  <div class="form-group">
                    <div class="row">
                       <div class="col-xs-12 form-group pull-left login-btn">
                        
                    <input type="submit" name="update-user" id="update-item" class="btn btn-primary" value="Update">					
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
	
	$("#update-item").on('click',function(e){
			
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
				$("#item-form").attr("action","updateMenus.html");
				$("#item-form").submit();
			}
	});
	
	function validation(){
		var itemname = $("#itemname").val();
		var price = $("#price").val();
		var description = $("#description").val();
		var category = $("#category").val();
		var image = $("#image").val();
		var flag = false;
		var object = {status:"NOTOK",result:false};
		if(itemname){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"itemname",result:false};
		}
		if(price){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"price",result:false};
		}
		if(description){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"description",result:false};
		}
		if(image){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"image",result:false};
		}
		if(category){
			flag = true;
			object.status = "OK";
			object.result = true;
		}else{
			return {status:"NOTOK",element:"category",result:false};
		}
		if(flag){
			return object;
		}
	}
	</script>
</body>
</html> 