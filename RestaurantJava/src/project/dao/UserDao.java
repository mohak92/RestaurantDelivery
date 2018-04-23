package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.User;
import project.myUtil.HibernateUtil;

public class UserDao {

	public List<User> getUserInfo(){
		
		List<User> list = new ArrayList<User>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from User U WHERE U.isAdmin = :isAdmin");
		query.setParameter("isAdmin","0");
		System.out.println(query);
		list = query.list();
		System.out.println("User List");
		System.out.println(list);
		return list;
		
	}
	public void saveUser(User user){
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(user);
		tran.commit();
		session.close();
	}
	
	public void updateUser(User user){
		System.out.println("First Name "+user.getFirstName());
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "UPDATE User set firstname = :firstname , lastname =  :lastname,password= :password,gender = :gender " + 
	             ", address = :address , phone = :phone WHERE email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("firstname",user.getFirstName());
		query.setParameter("lastname",user.getLastName());
		query.setParameter("password",user.getPassword());
		query.setParameter("gender",user.getGender());
		query.setParameter("address",user.getAddress());
		query.setParameter("phone",user.getPhone());
		query.setParameter("email",user.getEmail());
		
		int result = query.executeUpdate();
		System.out.println("Update Result "+result);
		tran.commit();
		session.close();
	}
	
	public boolean searchByEmail(String email){
		List<User> list = new ArrayList<User>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from User U WHERE U.email = :email");
		query.setParameter("email", email);
		list = query.list();
		if(list != null && !list.isEmpty()){
			System.out.println(list);
			return true;
		}
		return false;
	}
	
	public List<User> getDetailsByEmail(String email){
		List<User> list = new ArrayList<User>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from User U WHERE U.email = :email");
		query.setParameter("email", email);
		list = query.list();
		return list;
	}
	
	public List<User> getDetailsByID(int id){
		List<User> list = new ArrayList<User>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from User U WHERE U.id = :id");
		query.setParameter("id", id);
		list = query.list();
		return list;
	}
	
}
