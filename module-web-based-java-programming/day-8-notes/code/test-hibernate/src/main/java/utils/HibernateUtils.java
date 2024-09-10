package utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static {
		System.out.println("in static init block");
		sessionFactory=new Configuration() //EMPTY config obj
				.configure() //populated with entries in hibernate.cfg.xml
				.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
