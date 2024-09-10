package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //singleton n eager
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of"+getClass());
	}
	//add req handling method : for saying hello 
	@RequestMapping("/hello")
	//key : /hello 
	//value : HelloController.sayHello1
	public String sayHello1()
	{
		System.out.println("in say hello1");
		return "/display";//Handler rets LVN --> D.S --> sends LVN -->
		//V.R --> AVN : /WEB-INF/views/display.jsp		
	}

}
