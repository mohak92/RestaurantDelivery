package project.service;

import java.util.List;


import project.beans.Student;
import project.dao.StudentDao;

public class StudentService {

	StudentDao studentDao=new StudentDao();
	public void saveStudent(Student student)
	{
		studentDao.saveStudent(student);
	}
	
	public List<Student> getAllDetails()
	{
		List<Student> list = studentDao.getAllDetails();
		return list;
	}
	public void updateProfile(String detail,String detail1,String detail2,String detail3)
	{
		studentDao.updateProfile(detail,detail1,detail2,detail3);
	}
}
