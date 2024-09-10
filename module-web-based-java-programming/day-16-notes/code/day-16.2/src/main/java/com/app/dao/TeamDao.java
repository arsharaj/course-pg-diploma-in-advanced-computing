package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Team;

public interface TeamDao extends JpaRepository<Team,Integer>{
//add a method to get abbreviations of all teams
//	List<String> getAllTeamsAbbreviations();
	//custom query methods
	@Query("select t.abbreviation from Team t")
	List<String> getAllTeamsAbbreviations();
	
//get team's details from the abbr. : using finder methods
//	Team getTeamDetailsByAbbreviation(String abbr);
	Optional<Team> findByAbbreviation(String abbr);
	
}
