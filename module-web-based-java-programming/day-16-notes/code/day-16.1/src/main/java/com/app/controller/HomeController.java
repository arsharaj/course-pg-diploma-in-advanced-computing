package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//add req handling method to render index page
	@RequestMapping("/")
	public String showHomePage() {
		return "/index";//AVN : /WEB-INF/views/index.jsp
	}
}
