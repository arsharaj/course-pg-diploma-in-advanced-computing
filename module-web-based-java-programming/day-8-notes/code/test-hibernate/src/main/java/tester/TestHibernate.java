package tester;

import static utils.HibernateUtils.getSessionFactory;
import org.hibernate.*;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running " + sf);
		} //JVM : sf.close() ---> DBCP(db conn pool) clenedd up!
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
