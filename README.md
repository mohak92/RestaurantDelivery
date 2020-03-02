# Restaurant Delivery
A full stcak Java application to order food from restaurant, role based authentication and admin functionalities such as add new food items to menu, view all custeromers, update all custeomer see invices.

## Technologies: 
•	JDK 8
•	Tomcat 8 or 8.5
•	Spring MVC
•	Hibernate ORM
•	Database MySQL

## Screenshots

## Local Workspace Setup:
*	Import the project in eclipse
*	Run the restaurant_delivery.sql file in MySQLWorkbench
*	Open the hibernate.cfg.xml file and change the username and password according to your MySQL database.
*	Right click on project select Run as and click o Run on Server.
*	Click on Register and enter your details to register click register and then logout.
*	Go to the MySQL database in the user table find the isAdmin column and change it from 0 to 1.
*	Again register a few customers.
*	Restart the project and that’s it.
*	Admin will be able to see user list, add items to menu edit locations.
*	Login as customer go to menu click on Add to order and the click on process order then select location to see your cart.
*	In cart to cancel order click on cancel order or to delete an item click on Delete Item.
*	To continue click on process order enter your payment information click process and done.
* Click on Account then click on View Orders to see your order history

