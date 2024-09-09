package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
	// Add new team into the table
	String addTeam(Team team);

	// Find out and display team details by its abbreviation
	String getTeamDetailsByAbbr(String abbr);

	// Find out the teams, who need players with max age of the players > specified age
	List<String> getTeamsPlayersWithSpecifiedAge(int age);

	// Update the teams no of wickets taken and batting average
	String updateTeamsWktsAndAvg(String abbr, int wks, double avg);

	// Fetch team names, owner, wickets taken
	String fetchTeamsSpecificDetails(String abbr);
}
