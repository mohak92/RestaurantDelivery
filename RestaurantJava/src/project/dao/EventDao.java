package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.Admin;
import project.beans.Event;
import project.myUtil.HibernateUtil;

public class EventDao {

	public void saveEvent(Event event)
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(event);
		tran.commit();
		session.close();
	}
	public List<Event> getAllDetails()
	{
		List<Event> list = new ArrayList<Event>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("From Event");
		list = query.list();
		tran.commit();
		session.close();
		return list;
	}
}
