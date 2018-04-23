package project.service;

import project.beans.Location;
import project.beans.Menuitems;
import project.beans.User;
import project.beans.User_Cart;
import project.dao.LocationDao;
import project.dao.MenuDao;
import project.dao.UserCartDao;
import project.dao.UserDao;

import java.util.List;

public class LocationService {

	MenuDao menuDao = new MenuDao();
	UserCartDao userCartDao = new UserCartDao();
	LocationDao locationDao = new LocationDao();
	public void saveMenuInCart(User_Cart user_cart){
		userCartDao.saveMenuInCart(user_cart);
	}
	public List<Location> getLocations(){
		List<Location> list = locationDao.getLocations();
		return list;
	}
	
	public List<Location> getLocationsById(int id){
		List<Location> list = locationDao.getLocationsById(id);
		return list;
	}
	
	public void updateLocation(Location location,int id){
		locationDao.updateLocation(location, id);
	}
	public void saveLocation(Location location){
		locationDao.saveLocation(location);
	}
	
}
