package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//optional BUT reco for separation
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}
	//add rq handling method to test ModelAndView
	@GetMapping("/test1")
	//Key : /test/test1 , method=GET
	//val : TestController.testModelAndView
	public ModelAndView testModelAndView() {
		System.out.println("in test m n v");
		//ModelAndView(String lvn , String attrName,Object val)
		return new ModelAndView("/test/test1", 
				"server_ts", LocalDateTime.now());
	}//Handler rets M&V to D.S --> D.S sends LVN --> V.R --> AVN 
	//   /WEB-INF/views/test/test1.jsp , D.S saves ModelAttr under req scope
	//forward the clnt to the view layer.
	//add a rq handling method to test Model map
	@GetMapping("/test2")
	public String testModelMap(Model modelAttrMap) {
		System.out.println("in test model map "+modelAttrMap);//empty Map {}
		modelAttrMap.addAttribute("server_ts", LocalDateTime.now())
		.addAttribute("number_list", List.of(1,2,3,4,5));
		return "/test/test2";
		//Handler explicitly rets LVN --> D.S
		//impl rets Model map --> D.S --> LVN --> V.R --> AVN 
		//D.S --> adds 2 model attrs under request scope n then forwards
		//the clnt to view layer.
		
	}
}
