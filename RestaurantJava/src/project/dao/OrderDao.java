package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.Location;
import project.beans.Menuitems;
import project.beans.Orders;
import project.beans.User_Cart;
import project.myUtil.HibernateUtil;

public class OrderDao {

	
	public void saveOrder(Orders orders){
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(orders);
		tran.commit();
		session.close();
	}
	
	public List<Orders> getOrderInfoByUserId(int user_id,String status){
		List<Orders> list = new ArrayList<Orders>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Orders M WHERE M.user_id = :userID AND M.status = :status");
		query.setParameter("userID", user_id);
		query.setParameter("status", status);
		list = query.list();
		return list;
	}
	
	public void deleteOrder(String orderid){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "DELETE FROM Orders WHERE order_number = :orderid";
		Query query = session.createQuery(hql);
		query.setParameter("orderid", orderid);
		int result = query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public List<Orders> getOrderInfoByStatus(String status){
		List<Orders> list = new ArrayList<Orders>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Orders M WHERE M.status = :status");
		
		query.setParameter("status", status);
		list = query.list();
		return list;
	}
	
}
