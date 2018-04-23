package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.Student;
import project.myUtil.HibernateUtil;

public class StudentDao {
	
	public void saveStudent(Student student)
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(student);
		tran.commit();
		session.close();
	}
	public List<Student> getAllDetails()
	{
		List<Student> list = new ArrayList<Student>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From Student");
		list = query.list();
		tran.commit();
		session.close();
		return list;
	}
	public void updateProfile(String detail,String detail1,String detail2,String detail3)
	{
		
	}
}
