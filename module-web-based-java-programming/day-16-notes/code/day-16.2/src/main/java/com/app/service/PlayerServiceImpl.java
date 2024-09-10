package com.app.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PlayerDao;
import com.app.dao.TeamDao;
import com.app.pojos.Player;
import com.app.pojos.Team;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
	/*
	 * Did NOT use it here , since using a cascading here
	 * 
	 * @Autowired private PlayerDao playerDao;
	 */
	@Autowired
	private TeamDao teamDao;

	@Override
	public String addPlayerToTeam(Player newPlayer, String abbreviation) {
		// validate player details from the team's requirements
		// get team details from the abbreviation
		Team selectedTeam = teamDao.
				findByAbbreviation(abbreviation).orElseThrow();
		// validate
		int age = Period.between(newPlayer.getDob(), LocalDate.now()).getYears();
		if (age > selectedTeam.getMaxAge() || newPlayer.getBattingAvg() < selectedTeam.getBattingAvg()
				|| newPlayer.getWicketsTaken() < selectedTeam.getWicketsTaken())
			throw new RuntimeException("Invalid Player Details ...Please retry");
		// selectedTeam : persistent
		// simply set bi dir asso between Team n Player
		selectedTeam.addPlayer(newPlayer);
		return "Added player to the team";
	}// no exc ---session.flush -- auto dirty chking -- auto inserts player : cascade
		// !--commit

}
