package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.log.Logger;
import com.example.demo.log.LoggerFactory;
import com.example.demo.log.LoggerFactory.LoggerType;

@Controller
public class LoginController {
	
	private final Logger logger = 
	           LoggerFactory.getLogger(LoggerType.FILE);
	
	@GetMapping("/login")
	public String loginForm(Model model,
							@RequestParam(value = "logout", required = false) String logout, 
							@RequestParam(value = "error", required = false) String error)
	{
		if(logout != null){
			model.addAttribute("logoutPoruka", "You just logged out!");
			logger.log("User logged out!");
		}
		
		if(error != null){
			model.addAttribute("errorPoruka", "Incorrect username or password!");
		}
		
		if(logout == null && error == null)
		{
			logger.log("Sucessful log in!");
		}
		
		return "login";
	}
}
