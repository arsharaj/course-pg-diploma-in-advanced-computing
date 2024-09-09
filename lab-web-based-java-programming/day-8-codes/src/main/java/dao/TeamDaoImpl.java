package dao;

import pojos.Team;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeamDetails(Team newTeam) {
		// 1. open hibernate session from SF
		Session session = getFactory().openSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.save(newTeam);
			//end of try => success
			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx n re throw the exc to the caller
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			// close the session
			if (session != null)
				session.close();
		}
		return "Added new Team with ID "+newTeam.getTeamId();
	}

}
