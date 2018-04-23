package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.Admin;
import project.beans.Student;
import project.myUtil.HibernateUtil;

public class AdminDao {

	public void saveAdmin(Admin admin)
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(admin);
		tran.commit();
		session.close();
	}
	public List<Admin> getAllDetails()
	{
		List<Admin> list = new ArrayList<Admin>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From Admin");
		list = query.list();
		tran.commit();
		session.close();
		return list;
	}
}
