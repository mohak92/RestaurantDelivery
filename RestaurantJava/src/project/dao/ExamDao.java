package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.Exam;
import project.myUtil.HibernateUtil;

public class ExamDao {

	public List<Exam> getAllDetails()
	{
		List<Exam> list = new ArrayList<Exam>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From Exam");
		list = query.list();
		tran.commit();
		session.close();
		return list;
	}
}
