package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of "+getClass());
	}
	//add req handling method to render index page
	@GetMapping("/") //=@RequestMapping(method=GET) =>doGet
	public String showHomePage() {
		System.out.println("in show home page");
		return "/index";//AVN : /WEB-INF/views/index.jsp
	}

}
