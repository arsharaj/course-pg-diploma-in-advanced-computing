package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory cls level anno to specify :
//class =>spring bean :  req handling controller  (=Handler) , singleton , eager
public class TestContoller {
	public TestContoller() {
		System.out.println("in ctor of " + getClass());
	}

	// add rq handling method to display welcome mesg to clnt
	@RequestMapping("/test1") // => service
	// mandatory method level anno -- can intercept ANY HTTP req(get/post.....)
	// HandlerMapping bean , Key : /test1
	// value : com.app.controller.TestContoller.testMe1
	public String testMe1() {
		System.out.println("in test me1");
		return "/display";// AVN : /WEB-INF/views/display.jsp
		//(Handler --> AVN --> D.S)
	}
}
