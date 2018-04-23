<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.beans.User,project.beans.Orders" %>
 
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
		   <div class="col-sm-offset-4 col-sm-4">
		    <ul class="nav nav-tabs">
			  <li><a  href="userList.html">User List</a></li>
			  <li><a  href="itemList.html">Item List</a></li>
			  <li><a  href="orderList.html">Order List</a></li>
			  <li><a  href="locationList.html">Location List</a></li>
			</ul>
           </div>
		  
<section class="middlearea regularuserpage">
	
	<div class="col-md-8 col-md-offset-2">
    
    	<div >
    	<div class="col-sm-offset-4 col-sm-4 order-list-details">
                   <h4>List Of Orders</h4>
    	<%
    		ArrayList array = (ArrayList)session.getAttribute("orderInformation"); %>
    	<p>Number Of Orders: <b><%=array.size() %></b></p>
    		<%
    		for(int i=0;i<array.size();i++){
    			Orders orders = (Orders)array.get(i);
    	%>
		     
				
				<p>Order Number: <b><%=orders.getOrder_number() %></b></p>
				<p>Total: <b>$<%=orders.getTotal_amount() %></b> <a href="deleteOrder.html?order_num=<%=orders.getOrder_number() %>" class="btn btn-default">Delete Order</a></p>
              				 
		    
			<%
    		}
			%>
			</div>
			</div>
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
<style>
.regularuser{ background-color:none;}
.table {
    width: 100%;
    margin-bottom: 20px;
    background-color: #f6f6f6;
}
</style>  
</body>
</html> 