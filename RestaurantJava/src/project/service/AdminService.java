package project.service;

import java.util.List;

import project.beans.Admin;
import project.dao.AdminDao;

public class AdminService {
	
	AdminDao adminDao=new AdminDao();
	public void saveAdmin(Admin admin)
	{
		adminDao.saveAdmin(admin);
	}
	public List<Admin> getAllDetails()
	{
		List<Admin> list=adminDao.getAllDetails();
		return list;
	}

}
