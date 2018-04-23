package project.service;

import project.beans.User;
import project.dao.UserDao;
import java.util.List;

public class UserService {

	UserDao userDao = new UserDao();
	
	public List<User> getUserInfo(){
		List<User> list = userDao.getUserInfo();
		return list;
	}
	
	public void saveUser(User user){
		userDao.saveUser(user);
	}
	
	public void updateUser(User user){
		userDao.updateUser(user);
	}
	public boolean searchByEmail(String email){
		return userDao.searchByEmail(email);
	}
	
	public List<User> getDetailsByEmail(String email){
		List<User> list = userDao.getDetailsByEmail(email);
		return list;
	}
	
	public List<User> getDetailsByID(int id){
		List<User> list = userDao.getDetailsByID(id);
		return list;
	}
}
