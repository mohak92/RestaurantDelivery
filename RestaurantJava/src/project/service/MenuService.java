package project.service;

import project.beans.Menuitems;
import project.beans.User;
import project.dao.MenuDao;
import project.dao.UserDao;

import java.util.List;

public class MenuService {

	MenuDao menuDao = new MenuDao();

	public List<Menuitems> getMenuInformation(int shown_status){
		List<Menuitems> list = menuDao.getMenuInformation(shown_status);
		return list;
	}
	
	public List<Menuitems> getMenuInformationById(int menuId){
		List<Menuitems> list = menuDao.getMenuInformationById(menuId);
		return list;
	}
	
	public List<Menuitems> getMenuInformation(){
		List<Menuitems> list = menuDao.getMenuInformation();
		return list;
	}
	public void updateMenu(Menuitems menuitems,int id){
		menuDao.updateMenu(menuitems, id);
	}
	public void saveMenu(Menuitems menuitems){
		menuDao.saveMenu(menuitems);
	}
}
