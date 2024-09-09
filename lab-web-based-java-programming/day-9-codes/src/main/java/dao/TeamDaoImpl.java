package dao;

import static utils.HibernateUtils.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

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

	@Override
	public String getTeamDetailsByAbbr(String abbr) {
		String message = "Team details not found.";
		String jpql = "select t from Team t where t.abbrevation = :abbr";
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			Team team = session.createQuery(jpql, Team.class).setParameter("abbr", abbr).getSingleResult();
			if (team != null) {
				message = team.toString();
			}
			txn.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			System.out.println("Session Completed.");
		}
		return message;
	}

	@Override
	public List<String> getTeamsPlayersWithSpecifiedAge(int age) {
		List<String> teamDetails = null;
		String jpql = "select t.name from Team t where t.maxAge > :age";
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			teamDetails = session.createQuery(jpql, String.class).setParameter("age", age).getResultList();
			txn.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			System.out.println("Session Completed.");
		}
		return teamDetails;
	}

	@Override
	public String updateTeamsWktsAndAvg(String abbr, int wks, double avg) {
		String message = "Details could not be updated.";
		String jpql = "select t from Team t where t.abbrevation = :abbr";
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			Team team = session.createQuery(jpql, Team.class).setParameter("abbr", abbr).getSingleResult();
			team.setWicketsTaken(wks);
			team.setBattingAvg(avg);
			message = "Details updated successfully.";
			txn.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			System.out.println("Session Completed.");
		}
		return message;
	}

	@Override
	public String fetchTeamsSpecificDetails(String abbr) {
		String message = null;
		String jpql = "select new pojos.Team(teamId, abbrevation, owner, wicketsTaken) from Team t where t.abbrevation = :abbr";
		Session session = getSessionFactory().getCurrentSession();
		Transaction txn = session.beginTransaction();
		try {
			Team team = session.createQuery(jpql, Team.class).setParameter("abbr", abbr).getSingleResult();
			team.setAbbrevation("CSK");
			team.setName("Chennai Super King");

			message = "[" + team.getTeamId() + ", " + team.getAbbrevation() + ", " + team.getOwner() + ", "
					+ team.getWicketsTaken() + "]";
			txn.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			System.out.println("Session Completed.");
		}
		return message;
	}

}
