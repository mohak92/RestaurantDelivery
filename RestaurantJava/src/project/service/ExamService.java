package project.service;

import java.util.List;

import project.beans.Exam;
import project.dao.ExamDao;

public class ExamService {
	
	ExamDao examDao=new ExamDao();
	public List<Exam> getAllDetails()
	{
		List<Exam> list = examDao.getAllDetails();
		return list;
	}

}
