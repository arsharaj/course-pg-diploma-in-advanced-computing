package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Player;
import com.app.service.TeamService;

@Controller
@RequestMapping("/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;

	public TeamController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to get all teams abbreviations
	@GetMapping("/abbrs")
	public String getAllTeamsAbbreviations(Model map, Player newPlayer) {
		//SC : map.addAttribute("player",new Player());  MOdel --> View 
		System.out.println("in get all teams abbr " + map);//{player : playerpojo}
		map.addAttribute("teams_abbr", teamService.getAllTeamsAbbreviations());
		System.out.println("map again "+map);//populated with 2 entries 
		return "/teams/add_player_form";// AVN : /WEB-INF/views/teams/add_player_form.jsp
	}
}
