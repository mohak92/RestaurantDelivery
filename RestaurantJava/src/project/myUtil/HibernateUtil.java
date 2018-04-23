package project.myUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory getSessionFactory()
	{
		Configuration con=new Configuration().configure();
		SessionFactory factory=con.buildSessionFactory();
		return factory;
	}

}
