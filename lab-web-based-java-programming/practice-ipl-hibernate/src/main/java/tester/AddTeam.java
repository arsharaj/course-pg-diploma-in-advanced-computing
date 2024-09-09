package tester;

import static utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Team;

public class AddTeam {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running " + sf);
			System.out.println("Enter team details : name | abbrevation | owner | max_age | batting_avg | wickets_taken");
			// create dao instance n call method
			TeamDao dao = new TeamDaoImpl();
			Team team = new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			System.out.println(dao.addTeam(team));
		} // JVM : sf.close() ---> DBCP(db conn pool) clenedd up!
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
