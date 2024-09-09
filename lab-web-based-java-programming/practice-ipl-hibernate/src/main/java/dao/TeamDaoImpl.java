package dao;

import pojos.Team;
import org.hibernate.*;
import static utils.HibernateUtils.getSessionFactory;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeam(Team team) {
		Session session = getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		try {
			session.save(team);
			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return "Sucessfully added.";
	}

}
