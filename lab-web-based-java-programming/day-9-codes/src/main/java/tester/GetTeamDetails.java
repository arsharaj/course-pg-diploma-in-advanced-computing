package tester;

import static utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class GetTeamDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running " + sf);
			System.out.println("Enter team abbreviation : ");
			// create dao instance n call method
			TeamDao dao = new TeamDaoImpl();
			System.out.println(dao.getTeamDetailsByAbbr(sc.next()));
		} // JVM : sf.close() ---> DBCP(db conn pool) clenedd up!
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
