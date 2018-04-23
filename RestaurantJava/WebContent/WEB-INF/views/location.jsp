 
 <%@page import="java.util.ArrayList,project.beans.Location"%>
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
			</nav> 
			  
		  </div>
		  
		  
<section class="middlearea locationpage">
	<h2 class="col-md-8">Location</h2>		
	<%
	ArrayList arr = (ArrayList)session.getAttribute("locations");
	
	for(int i=0;i<arr.size();i++){
		Location location = (Location)arr.get(i);
	%>
	<div class="col-md-12">
        <div class="col-md-4">          
			<img src="img/l1.jpg">
		</div> 
		<div class="col-md-8">
			
			<p class="title"><%=location.getLocation_name() %><br><%=location.getAddress() %>, <%=location.getCity() %> <%=location.getZipcode() %></p>
			<a href="showCart.html?location=<%=location.getId() %>" class="btn btn-default">Select Location</a>
		</div>	
	</div>
	<%
	}
	%>
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
.middlearea{ width:65%; margin:auto}
.locationpage .col-md-4 img{ width:80%}
.locationpage .processorder{color:red; font-size:22px;}
.locationpage .title{color:#fff; font-size:22px;}
.locationpage .col-md-12{ margin-bottom:20px;}
</style>  
</body>
</html> 