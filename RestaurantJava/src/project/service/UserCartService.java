package project.service;

import project.beans.Menuitems;
import project.beans.User;
import project.beans.User_Cart;
import project.dao.MenuDao;
import project.dao.UserCartDao;
import project.dao.UserDao;

import java.util.List;

public class UserCartService {

	
	UserCartDao userCartDao = new UserCartDao();

	public void saveMenuInCart(User_Cart user_cart){
		userCartDao.saveMenuInCart(user_cart);
	}
	public List<User_Cart> getCartInformation(int user_id){
		List<User_Cart> list = userCartDao.getCartInformation(user_id);
		return list;
	}
	
	public void deleteMenuItem(int menuid , int user_id){
		userCartDao.deleteMenuItem(menuid,user_id);
	}
	
	public void deleteMenuItemByUserID(int user_id){
		userCartDao.deleteMenuItemByUserID(user_id);
	}
	
}
