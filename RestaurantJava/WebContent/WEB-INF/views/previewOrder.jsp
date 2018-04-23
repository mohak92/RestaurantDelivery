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
		  
		  
<section class="middlearea menuitem">

  <div class="col-md-12 text-right">   
   <ul class="pager text-right">
   <% 
   		String order_num = (String) session.getAttribute("ordernumber");
   %>
     <li class="text-left"><a href="processPayment.html?order_num=<%=order_num %>">Process Order</a></li>
     <li class="text-right"><a href="cancelOrder.html?order_num=<%=order_num %>">Cancel Order</a></li>
  </ul>
	
  </div>	
  
  <div class="col-md-10 menu-item-text-center">
	<h2 class="text-center">Menu Items</h2>
   </div>

  	<% 
		ArrayList arr = (ArrayList)session.getAttribute("orderMenuInfo");
	
		for(int i=0;i<arr.size();i++){
			Menuitems menu = (Menuitems)arr.get(i);
  	%>
	<div class="col-md-12">
        <div class="col-md-4">          
			<img src="img/p1.jpg">
		</div> 
		<div class="col-md-8 menu-item-detail text-center">
			<h4><%=menu.getPrice() %> <%=menu.getMenuname() %></h4>
			<p class="menuitem-2"><a href="deleteMenu.html?menuId=<%=menu.getId() %>" class="btn btn-default">Delete Item</a></p>
		</div>	
	</div>
	<%
		}
	%>
	
</section>		  
		  
		 
 



	<div class="col-sm-12">
       <div class="footer text-center">
	    <p>Copy Rights &copy; Restaurant Delivery All Rights Reserved</p>

       </div>	   
	
	</div>
	
	
		</div>
	 </div>
   </section>   
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>     

</body>
</html> 