package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String loginForm(Model model,
							@RequestParam(value = "logout", required = false) String logout, 
							@RequestParam(value = "error", required = false) String error)
	{
		if(logout != null){
			model.addAttribute("logoutPoruka", "You just logged out!");
		}
		
		if(error != null){
			model.addAttribute("errorPoruka", "Incorrect username or password!");
		}
		
		return "login";
	}
}
