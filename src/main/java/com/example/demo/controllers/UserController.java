package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.viewmodels.UserViewModel;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/profile")
	public String getProfile(Model model)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				CustomUserDetails customUser = (CustomUserDetails)authentication.getPrincipal();
				Long userId = customUser.getId();
		
		User user = null;
		Optional<User> userOptional = userRepo.findById(userId);
		
		if(userOptional.isPresent())
		{
			user = userOptional.get();
		}
		
		model.addAttribute("userViewModel", new UserViewModel(user.getId(),user.getUsername(), user.getPassword(), user.getAdmin()));
		return "profile";
	}
	
	@GetMapping("/users")
	public String getUsers(Model model)
	{
		model.addAttribute("users", userRepo.findAll());
		return "users";
	}
}
