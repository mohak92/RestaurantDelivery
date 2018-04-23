package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.Menuitems;
import project.beans.User;
import project.myUtil.HibernateUtil;

public class MenuDao {

	public List<Menuitems> getMenuInformation(int shown_status){
		List<Menuitems> list = new ArrayList<Menuitems>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Menuitems M WHERE M.status = :status");
		query.setParameter("status", shown_status);
		list = query.list();
		return list;
	}
	
	public List<Menuitems> getMenuInformationById(int menuId){
		List<Menuitems> list = new ArrayList<Menuitems>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Menuitems M WHERE M.id = :id");
		query.setParameter("id", menuId);
		list = query.list();
		return list;
	}
	
	public List<Menuitems> getMenuInformation(){
		List<Menuitems> list = new ArrayList<Menuitems>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Menuitems");
		list = query.list();
		return list;
	}
	
	public void saveMenu(Menuitems menuitems){
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(menuitems);
		tran.commit();
		session.close();
	}
	
	public void updateMenu(Menuitems menuitems,int id){
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "UPDATE Menuitems set menuname = :menuname , image =  :image,description= :description,price = :price WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("menuname",menuitems.getMenuname());
		query.setParameter("image",menuitems.getImage());
		query.setParameter("description",menuitems.getDescription());
		query.setParameter("price",menuitems.getPrice());
		query.setParameter("id", id);
		
		
		int result = query.executeUpdate();
		System.out.println("Update Result "+result);
		tran.commit();
		session.close();
	}
	
}
