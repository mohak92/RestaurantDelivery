<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="java.util.ArrayList,java.util.HashMap,project.beans.Menuitems,project.beans.Orders,project.beans.Location" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				</div>
		
				<section class="middlearea orderreceipt">
					<h2 class=" text-center">User's Passed Orders</h2>
					<%
					HashMap<Integer,Object> mapping = (HashMap<Integer, Object>) session.getAttribute("ordersHistory");
					
					for(int i=0;i<mapping.size();i++){
						HashMap<String,Object> map = (HashMap<String, Object>) mapping.get(i);
						Orders orders = (Orders) map.get("orderDetail");
						ArrayList arr = (ArrayList)map.get("menuInfo");
						Location location = (Location)map.get("location");
					%>
					<div class="col-md-12" >
						<div class="col-md-4 passed-order-menu" style="padding-top:25px;">          
							<ul style="list-style:none;">
							<%
							for(int j=0;j<arr.size();j++){
								Menuitems menu = (Menuitems)arr.get(j);
							%>
								<li>$<%=menu.getPrice() %></li>
								<li><%=menu.getMenuname() %></li>
								<%
							}
								%>
							</ul>
						</div>
						<div class="col-md-6 receipt text-center">
						<%
							double tax_val = ((orders.getTotal_amount()*orders.getTax())/100);
						%>
							Total: $<%=orders.getTotal_amount() %><br>
							Tax:$<%=tax_val %></br>
							Item:<%=arr.size() %></br>
							Order Number: <%=orders.getOrder_number() %></br><br>
							<%=location.getLocation_name() %></br>
							<%=location.getAddress() %>, <%=location.getCity() %> <%=location.getZipcode() %></br>
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
		</section>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>     
		<style>
			.orderreceipt{ width:65%; margin:auto}
			.orderreceipt .col-md-6 img{ width:80%}
			.orderreceipt .processorder{color:red; font-size:22px;}
			.receipt{ background-color:#67e57c; color:#fff; margin:25px; padding:20px; font-size:15px;}
		</style>
	</body>
</html>