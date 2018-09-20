package com.example.demo.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.log.Logger;
import com.example.demo.log.LoggerFactory;
import com.example.demo.log.LoggerFactory.LoggerType;
import com.example.demo.model.MainMenu;
import com.example.demo.model.Page;
import com.example.demo.repository.*;


@Controller
public class HomeController {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private PageRepository pageRepository;
	@Autowired
	private MainMenuRepository mainMenuRepository;
	@Autowired
	private SubMenuRepository subMenuRepository;
	
	private final Logger logger = 
	           LoggerFactory.getLogger(LoggerType.FILE);
	
	@RequestMapping("/")
	  public String stdRedirect(){
	    return "redirect:/index/9";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		model.addAttribute("posts", postRepository.findAll());
		model.addAttribute("main_menu", mainMenuRepository.findAll());
		model.addAttribute("sub_menu", subMenuRepository.findAll());
		
		return "dashboard";
	}
	
	@GetMapping("/index")
	public String home(Model model) {
		
		model.addAttribute("posts", postRepository.findAll());
		model.addAttribute("main_menu", mainMenuRepository.findAll());
		model.addAttribute("sub_menu", subMenuRepository.findAll());
		
		return "redirect:/index/9";
	}
	
	@GetMapping("/index/{page_id}")
	public String page(@PathVariable("page_id") Long pageId, Model model, HttpSession session) {
		
		Page page = null;
		Optional<Page> pageOptional = pageRepository.findById(pageId);
		
		if(pageOptional.isPresent())
		{
			page = pageOptional.get();
		}		
		
		for(MainMenu item : mainMenuRepository.findAll()) {
			item.setSubMenus(subMenuRepository.findByMainMenu(item));
		}
		
		model.addAttribute("posts", postRepository.findByPage(page));
		model.addAttribute("main_menu", mainMenuRepository.findAll());	
		model.addAttribute("sub_menu", subMenuRepository.findAll());
		model.addAttribute("page", page);
		session.setAttribute("page_id", pageId);
		
		logger.log("Home Page data filled");
		
		return "index";
	}
	
}
