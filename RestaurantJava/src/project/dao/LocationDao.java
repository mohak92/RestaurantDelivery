package project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project.beans.Location;
import project.beans.Menuitems;
import project.myUtil.HibernateUtil;

public class LocationDao {

	
	
	public List<Location> getLocations(){
		List<Location> list = new ArrayList<Location>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Location");
		list = query.list();
		return list;
	}
	
	public List<Location> getLocationsById(int id){
		List<Location> list = new ArrayList<Location>();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Location WHERE id = :id");
		query.setParameter("id", id);
		list = query.list();
		return list;
	}
	
	public void saveLocation(Location location){
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction tran=session.beginTransaction();
		session.save(location);
		tran.commit();
		session.close();
	}
	
	public void updateLocation(Location location,int id){
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "UPDATE Location set location_name = :location , address =  :add,city= :city,zipcode = :zip,image = :image,staffs = :staffs WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("location",location.getLocation_name());
		query.setParameter("add",location.getAddress());
		query.setParameter("city",location.getCity());
		query.setParameter("zip",location.getZipcode());
		query.setParameter("image",location.getImage());
		query.setParameter("staffs",location.getStaffs());
		query.setParameter("id", id);
		
		
		int result = query.executeUpdate();
		System.out.println("Update Result "+result);
		tran.commit();
		session.close();
	}
	
}
