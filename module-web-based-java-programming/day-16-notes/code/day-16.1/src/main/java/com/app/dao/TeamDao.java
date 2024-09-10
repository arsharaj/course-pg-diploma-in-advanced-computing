package com.app.dao;

import java.util.List;

import com.app.pojos.Team;

public interface TeamDao {
//add a method to get abbreviations of all teams
	List<String> getAllTeamsAbbreviations();
	//get team's details from the abbr.
	Team getTeamDetailsByAbbreviation(String abbr);
	
}
