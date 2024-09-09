package tester;

import static utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class UpdateTeamsWksAndAvg {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running " + sf);
			System.out.println("Enter Team abbreviation, updated wks and updated batting avg ");
			// create dao instance n call method
			TeamDao dao = new TeamDaoImpl();
			System.out.println(dao.updateTeamsWktsAndAvg(sc.next(), sc.nextInt(), sc.nextDouble()));
		} // JVM : sf.close() ---> DBCP(db conn pool) clenedd up!
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
