package com.app.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Player;
import com.app.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {
//  http://localhost:8080/ctx_path/players/add
	// dep : PlayerService i/f
	@Autowired
	private PlayerService playerService;

	// add request handling method , to add player in the DB
	@PostMapping("/add")
	public String addPlayer(Model map, Player transientPlayer,
			HttpSession session)

	{
		System.out.println("in add player " + transientPlayer + " " + transientPlayer.getMyTeam().getabbreviation());
		// Create transient Player object n pass it to PlayerService layer
		try {
			map.addAttribute("mesg",
					playerService.addPlayerToTeam(transientPlayer, transientPlayer.getMyTeam().getabbreviation()));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			//save err mesg in the session scope : since using a redirect here.
			session.setAttribute("mesg", e.getMessage());
			// in case of any errs : redirect the clnt to the TeamController again, as a
			// next request coming from the clnt
			return "redirect:/teams/abbrs";
		}
		return "/players/show";
	}

}
