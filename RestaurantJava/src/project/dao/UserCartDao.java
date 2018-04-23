package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.Menuitems;
import project.beans.User_Cart;
import project.myUtil.HibernateUtil;

public class UserCartDao {

	public void saveMenuInCart(User_Cart user_cart){
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(user_cart);
		tran.commit();
		session.close();
	}
	
	public List<User_Cart> getCartInformation(int user_id){
		List<User_Cart> list = new ArrayList<User_Cart>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from User_Cart M WHERE M.user_id = :userID");
		query.setParameter("userID", user_id);
		list = query.list();
		return list;
	}
	
	public void deleteMenuItem(int menuid,int user_id){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "DELETE FROM User_Cart WHERE user_id = :userID AND menuitemid = :menuID";
		Query query = session.createQuery(hql);
		query.setParameter("userID", user_id);
		query.setParameter("menuID", menuid);
		int result = query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public void deleteMenuItemByUserID(int user_id){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "DELETE FROM User_Cart WHERE user_id = :userID";
		Query query = session.createQuery(hql);
		query.setParameter("userID", user_id);
		int result = query.executeUpdate();
		tran.commit();
		session.close();
	}
	
}
