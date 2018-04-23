package project.service;

import project.beans.Menuitems;
import project.beans.Orders;
import project.beans.User;
import project.beans.User_Cart;
import project.dao.MenuDao;
import project.dao.OrderDao;
import project.dao.UserCartDao;
import project.dao.UserDao;

import java.util.List;

public class OrderService {

	
	UserCartDao userCartDao = new UserCartDao();
	OrderDao orderDao = new OrderDao();
	
	public void saveOrder(Orders orders){
		orderDao.saveOrder(orders);
	}
	public List<Orders> getOrderInfoByUserId(int user_id,String status){
		List<Orders> list = orderDao.getOrderInfoByUserId(user_id,status);
		return list;
	}
	
	public void deleteOrder(String orderid){
		orderDao.deleteOrder(orderid);
	}
	
	public List<Orders> getOrderInfoByStatus(String status){
		List<Orders> list = orderDao.getOrderInfoByStatus(status);
		return list;
	}
	
	
}
