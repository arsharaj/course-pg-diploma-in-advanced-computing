package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Team;

@Repository
public class TeamDaoImpl implements TeamDao {
	//dep : EntitiyManager (super i/f of Hibernate Session)
	@Autowired
	private EntityManager manager;

	@Override
	public List<String> getAllTeamsAbbreviations() {
		String jpql="select t.abbreviation from Team t";
		return manager.createQuery(jpql, String.class)
				.getResultList();
	}

	@Override
	public Team getTeamDetailsByAbbreviation(String abbr1) {
		String jpql="select t from Team t where t.abbreviation=:abbr";
		return manager.createQuery(jpql, Team.class)
				.setParameter("abbr", abbr1)
				.getSingleResult();
	}
	

}
