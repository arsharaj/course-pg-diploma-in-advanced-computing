package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in ctor of "+getClass());
	}
	//add rq handling method to deliver index page
	//Key : /
	//value  : HomeController.showHomePage
	@RequestMapping("/")
	public String showHomePage()
	{
		System.out.println("in show home page");
		return "/index";//Handler rets LVN --> D.S --> V.R --> AVN
		//  /WEB-INF/views/index.jsp
	}

}
