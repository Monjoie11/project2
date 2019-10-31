package com.revature.project2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.revature.project2.util.LoggerUtil;


@Controller("/login")     //extends Component
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getHelloWorld() {
		LoggerUtil.info("Hello World!");
		return "Hello World!";
	}
	
}
